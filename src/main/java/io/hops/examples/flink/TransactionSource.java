package io.hops.examples.flink;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.page.PageReadStore;

import org.apache.parquet.hadoop.ParquetFileReader;

import org.apache.parquet.hadoop.util.HadoopInputFile;
import org.apache.parquet.io.ColumnIOFactory;

import org.apache.parquet.io.MessageColumnIO;
import org.apache.parquet.io.RecordReader;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.tools.json.JsonRecordFormatter;
import org.apache.parquet.tools.read.SimpleRecordMaterializer;
import org.apache.parquet.tools.read.SimpleRecord;

public class TransactionSource implements SourceFunction<Tuple2<String, String>> {

  private final String pathToParquet;
  private final int sleepPerEvent;
  private boolean isRunning = true;

  ParquetFileReader reader;
  MessageType schema;
  PageReadStore pages;
  JsonRecordFormatter.JsonGroupFormatter formatter;

  public TransactionSource(String pathToParquet, int sleepPerEevent){
    this.sleepPerEvent = sleepPerEevent;
    this.pathToParquet = pathToParquet;
  }

  @Override
  public void run(SourceContext<Tuple2<String, String>> sourceContext) throws Exception {

    reader = ParquetFileReader.open(HadoopInputFile.fromPath(new Path(pathToParquet), new Configuration()));
    schema = reader.getFooter().getFileMetaData().getSchema();
    formatter = JsonRecordFormatter.fromSchema(schema);

    while ((pages = reader.readNextRowGroup()) != null) {
      long rows = pages.getRowCount();
      MessageColumnIO columnIO = new ColumnIOFactory().getColumnIO(schema);
      RecordReader<SimpleRecord> recordReader = columnIO.getRecordReader(pages, new SimpleRecordMaterializer(schema));

      for (int i = 0; i < rows; i++) {
        SimpleRecord simpleRecord = recordReader.read();
        String record = formatter.formatRecord(simpleRecord);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        JsonNode jsonNode = objectMapper.readTree(record);
        String event = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // TODO (Davit): there is an issue with timestamp conversion
        //SourceTransaction sourceTransaction = objectMapper.readValue(event, SourceTransaction.class);

        // produce an event
        sourceContext.collect(new Tuple2<>(jsonNode.get("user_uuid").asText(), event));

        // produce a Watermark
        sourceContext.emitWatermark(new Watermark(0L));
        Thread.sleep(sleepPerEvent);
      }
    }
    reader.close();
  }

  @Override
  public void cancel() {
    isRunning = false;
  }
}
