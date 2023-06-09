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
public class address extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5144517533547372759L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"address\",\"namespace\":\"io.hops.examples.flink\",\"fields\":[{\"name\":\"city\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"country\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"postcode\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<address> ENCODER =
      new BinaryMessageEncoder<address>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<address> DECODER =
      new BinaryMessageDecoder<address>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<address> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<address> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<address>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this address to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a address from a ByteBuffer. */
  public static address fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String city;
  @Deprecated public java.lang.String country;
  @Deprecated public java.lang.String postcode;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public address() {}

  /**
   * All-args constructor.
   * @param city The new value for city
   * @param country The new value for country
   * @param postcode The new value for postcode
   */
  public address(java.lang.String city, java.lang.String country, java.lang.String postcode) {
    this.city = city;
    this.country = country;
    this.postcode = postcode;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return city;
    case 1: return country;
    case 2: return postcode;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: city = (java.lang.String)value$; break;
    case 1: country = (java.lang.String)value$; break;
    case 2: postcode = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'city' field.
   * @return The value of the 'city' field.
   */
  public java.lang.String getCity() {
    return city;
  }

  /**
   * Sets the value of the 'city' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.String value) {
    this.city = value;
  }

  /**
   * Gets the value of the 'country' field.
   * @return The value of the 'country' field.
   */
  public java.lang.String getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.String value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'postcode' field.
   * @return The value of the 'postcode' field.
   */
  public java.lang.String getPostcode() {
    return postcode;
  }

  /**
   * Sets the value of the 'postcode' field.
   * @param value the value to set.
   */
  public void setPostcode(java.lang.String value) {
    this.postcode = value;
  }

  /**
   * Creates a new address RecordBuilder.
   * @return A new address RecordBuilder
   */
  public static io.hops.examples.flink.address.Builder newBuilder() {
    return new io.hops.examples.flink.address.Builder();
  }

  /**
   * Creates a new address RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new address RecordBuilder
   */
  public static io.hops.examples.flink.address.Builder newBuilder(io.hops.examples.flink.address.Builder other) {
    return new io.hops.examples.flink.address.Builder(other);
  }

  /**
   * Creates a new address RecordBuilder by copying an existing address instance.
   * @param other The existing instance to copy.
   * @return A new address RecordBuilder
   */
  public static io.hops.examples.flink.address.Builder newBuilder(io.hops.examples.flink.address other) {
    return new io.hops.examples.flink.address.Builder(other);
  }

  /**
   * RecordBuilder for address instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<address>
    implements org.apache.avro.data.RecordBuilder<address> {

    private java.lang.String city;
    private java.lang.String country;
    private java.lang.String postcode;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.hops.examples.flink.address.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.country)) {
        this.country = data().deepCopy(fields()[1].schema(), other.country);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.postcode)) {
        this.postcode = data().deepCopy(fields()[2].schema(), other.postcode);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing address instance
     * @param other The existing instance to copy.
     */
    private Builder(io.hops.examples.flink.address other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.country)) {
        this.country = data().deepCopy(fields()[1].schema(), other.country);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.postcode)) {
        this.postcode = data().deepCopy(fields()[2].schema(), other.postcode);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'city' field.
      * @return The value.
      */
    public java.lang.String getCity() {
      return city;
    }

    /**
      * Sets the value of the 'city' field.
      * @param value The value of 'city'.
      * @return This builder.
      */
    public io.hops.examples.flink.address.Builder setCity(java.lang.String value) {
      validate(fields()[0], value);
      this.city = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'city' field has been set.
      * @return True if the 'city' field has been set, false otherwise.
      */
    public boolean hasCity() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'city' field.
      * @return This builder.
      */
    public io.hops.examples.flink.address.Builder clearCity() {
      city = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'country' field.
      * @return The value.
      */
    public java.lang.String getCountry() {
      return country;
    }

    /**
      * Sets the value of the 'country' field.
      * @param value The value of 'country'.
      * @return This builder.
      */
    public io.hops.examples.flink.address.Builder setCountry(java.lang.String value) {
      validate(fields()[1], value);
      this.country = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'country' field has been set.
      * @return True if the 'country' field has been set, false otherwise.
      */
    public boolean hasCountry() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'country' field.
      * @return This builder.
      */
    public io.hops.examples.flink.address.Builder clearCountry() {
      country = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'postcode' field.
      * @return The value.
      */
    public java.lang.String getPostcode() {
      return postcode;
    }

    /**
      * Sets the value of the 'postcode' field.
      * @param value The value of 'postcode'.
      * @return This builder.
      */
    public io.hops.examples.flink.address.Builder setPostcode(java.lang.String value) {
      validate(fields()[2], value);
      this.postcode = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'postcode' field has been set.
      * @return True if the 'postcode' field has been set, false otherwise.
      */
    public boolean hasPostcode() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'postcode' field.
      * @return This builder.
      */
    public io.hops.examples.flink.address.Builder clearPostcode() {
      postcode = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public address build() {
      try {
        address record = new address();
        record.city = fieldSetFlags()[0] ? this.city : (java.lang.String) defaultValue(fields()[0]);
        record.country = fieldSetFlags()[1] ? this.country : (java.lang.String) defaultValue(fields()[1]);
        record.postcode = fieldSetFlags()[2] ? this.postcode : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<address>
    WRITER$ = (org.apache.avro.io.DatumWriter<address>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<address>
    READER$ = (org.apache.avro.io.DatumReader<address>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
