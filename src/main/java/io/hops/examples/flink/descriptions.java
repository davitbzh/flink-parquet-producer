/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.hops.examples.flink;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class descriptions extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1008932590177728954L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"descriptions\",\"namespace\":\"io.hops.examples.flink\",\"fields\":[{\"name\":\"scheme\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"text\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<descriptions> ENCODER =
      new BinaryMessageEncoder<descriptions>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<descriptions> DECODER =
      new BinaryMessageDecoder<descriptions>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<descriptions> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<descriptions> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<descriptions>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this descriptions to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a descriptions from a ByteBuffer. */
  public static descriptions fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String scheme;
  @Deprecated public java.lang.String text;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public descriptions() {}

  /**
   * All-args constructor.
   * @param scheme The new value for scheme
   * @param text The new value for text
   */
  public descriptions(java.lang.String scheme, java.lang.String text) {
    this.scheme = scheme;
    this.text = text;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return scheme;
    case 1: return text;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: scheme = (java.lang.String)value$; break;
    case 1: text = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'scheme' field.
   * @return The value of the 'scheme' field.
   */
  public java.lang.String getScheme() {
    return scheme;
  }

  /**
   * Sets the value of the 'scheme' field.
   * @param value the value to set.
   */
  public void setScheme(java.lang.String value) {
    this.scheme = value;
  }

  /**
   * Gets the value of the 'text' field.
   * @return The value of the 'text' field.
   */
  public java.lang.String getText() {
    return text;
  }

  /**
   * Sets the value of the 'text' field.
   * @param value the value to set.
   */
  public void setText(java.lang.String value) {
    this.text = value;
  }

  /**
   * Creates a new descriptions RecordBuilder.
   * @return A new descriptions RecordBuilder
   */
  public static io.hops.examples.flink.descriptions.Builder newBuilder() {
    return new io.hops.examples.flink.descriptions.Builder();
  }

  /**
   * Creates a new descriptions RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new descriptions RecordBuilder
   */
  public static io.hops.examples.flink.descriptions.Builder newBuilder(io.hops.examples.flink.descriptions.Builder other) {
    return new io.hops.examples.flink.descriptions.Builder(other);
  }

  /**
   * Creates a new descriptions RecordBuilder by copying an existing descriptions instance.
   * @param other The existing instance to copy.
   * @return A new descriptions RecordBuilder
   */
  public static io.hops.examples.flink.descriptions.Builder newBuilder(io.hops.examples.flink.descriptions other) {
    return new io.hops.examples.flink.descriptions.Builder(other);
  }

  /**
   * RecordBuilder for descriptions instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<descriptions>
    implements org.apache.avro.data.RecordBuilder<descriptions> {

    private java.lang.String scheme;
    private java.lang.String text;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.hops.examples.flink.descriptions.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.scheme)) {
        this.scheme = data().deepCopy(fields()[0].schema(), other.scheme);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.text)) {
        this.text = data().deepCopy(fields()[1].schema(), other.text);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing descriptions instance
     * @param other The existing instance to copy.
     */
    private Builder(io.hops.examples.flink.descriptions other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.scheme)) {
        this.scheme = data().deepCopy(fields()[0].schema(), other.scheme);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.text)) {
        this.text = data().deepCopy(fields()[1].schema(), other.text);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'scheme' field.
      * @return The value.
      */
    public java.lang.String getScheme() {
      return scheme;
    }

    /**
      * Sets the value of the 'scheme' field.
      * @param value The value of 'scheme'.
      * @return This builder.
      */
    public io.hops.examples.flink.descriptions.Builder setScheme(java.lang.String value) {
      validate(fields()[0], value);
      this.scheme = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'scheme' field has been set.
      * @return True if the 'scheme' field has been set, false otherwise.
      */
    public boolean hasScheme() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'scheme' field.
      * @return This builder.
      */
    public io.hops.examples.flink.descriptions.Builder clearScheme() {
      scheme = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'text' field.
      * @return The value.
      */
    public java.lang.String getText() {
      return text;
    }

    /**
      * Sets the value of the 'text' field.
      * @param value The value of 'text'.
      * @return This builder.
      */
    public io.hops.examples.flink.descriptions.Builder setText(java.lang.String value) {
      validate(fields()[1], value);
      this.text = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'text' field has been set.
      * @return True if the 'text' field has been set, false otherwise.
      */
    public boolean hasText() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'text' field.
      * @return This builder.
      */
    public io.hops.examples.flink.descriptions.Builder clearText() {
      text = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public descriptions build() {
      try {
        descriptions record = new descriptions();
        record.scheme = fieldSetFlags()[0] ? this.scheme : (java.lang.String) defaultValue(fields()[0]);
        record.text = fieldSetFlags()[1] ? this.text : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<descriptions>
    WRITER$ = (org.apache.avro.io.DatumWriter<descriptions>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<descriptions>
    READER$ = (org.apache.avro.io.DatumReader<descriptions>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}