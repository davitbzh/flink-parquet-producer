package io.hops.examples.flink;

import com.logicalclocks.hsfs.FeatureStoreException;
import com.logicalclocks.hsfs.metadata.HopsworksClient;
import com.logicalclocks.hsfs.metadata.HopsworksHttpClient;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Properties;

public class Main {

  private static Properties getKafkaProperties(String topic) throws FeatureStoreException {
    HopsworksHttpClient client = HopsworksClient.getInstance().getHopsworksHttpClient();
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "broker.kafka.service.consul:9091");
    properties.put("security.protocol", "SSL");
    properties.put("ssl.truststore.location", client.getTrustStorePath());
    properties.put("ssl.truststore.password", client.getCertKey());
    properties.put("ssl.keystore.location", client.getKeyStorePath());
    properties.put("ssl.keystore.password", client.getCertKey());
    properties.put("ssl.key.password", client.getCertKey());
    properties.put("ssl.endpoint.identification.algorithm", "");
    properties.put("topic", topic);
    return properties;
  }

  public static void main(String[] args) throws Exception {

    String pathToParquet ="hdfs:///Projects/test_pr/Resources/example2.parquet/part-00000-2367033d-8149-4bae-a89f-d315bfd07c7e-c000.snappy.parquet";
    int sleepPerEvent = 60000;
    String topicName = "test_topic";

    // define flink env
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.getConfig().enableObjectReuse();
    env.enableCheckpointing(30000);

    DataStream<String> stream = env.addSource(new TransactionSource(pathToParquet, sleepPerEvent))
      .keyBy(r -> r.f0).map(new MapFunction<Tuple2<String, String>, String>() {
        @Override
        public String map(Tuple2<String, String> stringTuple2) throws Exception {
          return stringTuple2.f1;
        }
      });

    Properties kafkaCinfig = getKafkaProperties(topicName);
    KafkaSink<String> sink = KafkaSink.<String>builder()
      .setKafkaProducerConfig(kafkaCinfig)
      .setBootstrapServers(kafkaCinfig.getProperty("bootstrap.servers"))
      .setRecordSerializer(KafkaRecordSerializationSchema.builder()
        .setTopic(topicName)
        .setValueSerializationSchema(new SimpleStringSchema())
        .build()
      )
      .setDeliverGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
      .build();

    stream.sinkTo(sink);

    env.execute("Transactions producer");
  }
}
