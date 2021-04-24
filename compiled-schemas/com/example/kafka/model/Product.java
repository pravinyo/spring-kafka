/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.kafka.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Product extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7610759053179978397L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Product\",\"namespace\":\"com.example.kafka.model\",\"fields\":[{\"name\":\"Color\",\"type\":{\"type\":\"enum\",\"name\":\"Color\",\"symbols\":[\"GREEN\",\"BLUE\",\"PURPLE\"]}},{\"name\":\"ProductType\",\"type\":{\"type\":\"enum\",\"name\":\"ProductType\",\"symbols\":[\"TSHIRT\",\"DESIGN\"]}},{\"name\":\"DesignType\",\"type\":{\"type\":\"enum\",\"name\":\"DesignType\",\"symbols\":[\"NONE\",\"SUITCASE\",\"CAR\",\"WARNING\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Product> ENCODER =
      new BinaryMessageEncoder<Product>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Product> DECODER =
      new BinaryMessageDecoder<Product>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Product> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Product> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Product> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Product>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Product to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Product from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Product instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Product fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private com.example.kafka.model.Color Color;
   private com.example.kafka.model.ProductType ProductType;
   private com.example.kafka.model.DesignType DesignType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Product() {}

  /**
   * All-args constructor.
   * @param Color The new value for Color
   * @param ProductType The new value for ProductType
   * @param DesignType The new value for DesignType
   */
  public Product(com.example.kafka.model.Color Color, com.example.kafka.model.ProductType ProductType, com.example.kafka.model.DesignType DesignType) {
    this.Color = Color;
    this.ProductType = ProductType;
    this.DesignType = DesignType;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Color;
    case 1: return ProductType;
    case 2: return DesignType;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Color = (com.example.kafka.model.Color)value$; break;
    case 1: ProductType = (com.example.kafka.model.ProductType)value$; break;
    case 2: DesignType = (com.example.kafka.model.DesignType)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'Color' field.
   * @return The value of the 'Color' field.
   */
  public com.example.kafka.model.Color getColor() {
    return Color;
  }


  /**
   * Sets the value of the 'Color' field.
   * @param value the value to set.
   */
  public void setColor(com.example.kafka.model.Color value) {
    this.Color = value;
  }

  /**
   * Gets the value of the 'ProductType' field.
   * @return The value of the 'ProductType' field.
   */
  public com.example.kafka.model.ProductType getProductType() {
    return ProductType;
  }


  /**
   * Sets the value of the 'ProductType' field.
   * @param value the value to set.
   */
  public void setProductType(com.example.kafka.model.ProductType value) {
    this.ProductType = value;
  }

  /**
   * Gets the value of the 'DesignType' field.
   * @return The value of the 'DesignType' field.
   */
  public com.example.kafka.model.DesignType getDesignType() {
    return DesignType;
  }


  /**
   * Sets the value of the 'DesignType' field.
   * @param value the value to set.
   */
  public void setDesignType(com.example.kafka.model.DesignType value) {
    this.DesignType = value;
  }

  /**
   * Creates a new Product RecordBuilder.
   * @return A new Product RecordBuilder
   */
  public static com.example.kafka.model.Product.Builder newBuilder() {
    return new com.example.kafka.model.Product.Builder();
  }

  /**
   * Creates a new Product RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Product RecordBuilder
   */
  public static com.example.kafka.model.Product.Builder newBuilder(com.example.kafka.model.Product.Builder other) {
    if (other == null) {
      return new com.example.kafka.model.Product.Builder();
    } else {
      return new com.example.kafka.model.Product.Builder(other);
    }
  }

  /**
   * Creates a new Product RecordBuilder by copying an existing Product instance.
   * @param other The existing instance to copy.
   * @return A new Product RecordBuilder
   */
  public static com.example.kafka.model.Product.Builder newBuilder(com.example.kafka.model.Product other) {
    if (other == null) {
      return new com.example.kafka.model.Product.Builder();
    } else {
      return new com.example.kafka.model.Product.Builder(other);
    }
  }

  /**
   * RecordBuilder for Product instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Product>
    implements org.apache.avro.data.RecordBuilder<Product> {

    private com.example.kafka.model.Color Color;
    private com.example.kafka.model.ProductType ProductType;
    private com.example.kafka.model.DesignType DesignType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.kafka.model.Product.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Color)) {
        this.Color = data().deepCopy(fields()[0].schema(), other.Color);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.ProductType)) {
        this.ProductType = data().deepCopy(fields()[1].schema(), other.ProductType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.DesignType)) {
        this.DesignType = data().deepCopy(fields()[2].schema(), other.DesignType);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Product instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.kafka.model.Product other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.Color)) {
        this.Color = data().deepCopy(fields()[0].schema(), other.Color);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.ProductType)) {
        this.ProductType = data().deepCopy(fields()[1].schema(), other.ProductType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.DesignType)) {
        this.DesignType = data().deepCopy(fields()[2].schema(), other.DesignType);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'Color' field.
      * @return The value.
      */
    public com.example.kafka.model.Color getColor() {
      return Color;
    }


    /**
      * Sets the value of the 'Color' field.
      * @param value The value of 'Color'.
      * @return This builder.
      */
    public com.example.kafka.model.Product.Builder setColor(com.example.kafka.model.Color value) {
      validate(fields()[0], value);
      this.Color = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'Color' field has been set.
      * @return True if the 'Color' field has been set, false otherwise.
      */
    public boolean hasColor() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'Color' field.
      * @return This builder.
      */
    public com.example.kafka.model.Product.Builder clearColor() {
      Color = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'ProductType' field.
      * @return The value.
      */
    public com.example.kafka.model.ProductType getProductType() {
      return ProductType;
    }


    /**
      * Sets the value of the 'ProductType' field.
      * @param value The value of 'ProductType'.
      * @return This builder.
      */
    public com.example.kafka.model.Product.Builder setProductType(com.example.kafka.model.ProductType value) {
      validate(fields()[1], value);
      this.ProductType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'ProductType' field has been set.
      * @return True if the 'ProductType' field has been set, false otherwise.
      */
    public boolean hasProductType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'ProductType' field.
      * @return This builder.
      */
    public com.example.kafka.model.Product.Builder clearProductType() {
      ProductType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'DesignType' field.
      * @return The value.
      */
    public com.example.kafka.model.DesignType getDesignType() {
      return DesignType;
    }


    /**
      * Sets the value of the 'DesignType' field.
      * @param value The value of 'DesignType'.
      * @return This builder.
      */
    public com.example.kafka.model.Product.Builder setDesignType(com.example.kafka.model.DesignType value) {
      validate(fields()[2], value);
      this.DesignType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'DesignType' field has been set.
      * @return True if the 'DesignType' field has been set, false otherwise.
      */
    public boolean hasDesignType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'DesignType' field.
      * @return This builder.
      */
    public com.example.kafka.model.Product.Builder clearDesignType() {
      DesignType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Product build() {
      try {
        Product record = new Product();
        record.Color = fieldSetFlags()[0] ? this.Color : (com.example.kafka.model.Color) defaultValue(fields()[0]);
        record.ProductType = fieldSetFlags()[1] ? this.ProductType : (com.example.kafka.model.ProductType) defaultValue(fields()[1]);
        record.DesignType = fieldSetFlags()[2] ? this.DesignType : (com.example.kafka.model.DesignType) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Product>
    WRITER$ = (org.apache.avro.io.DatumWriter<Product>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Product>
    READER$ = (org.apache.avro.io.DatumReader<Product>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeEnum(this.Color.ordinal());

    out.writeEnum(this.ProductType.ordinal());

    out.writeEnum(this.DesignType.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.Color = com.example.kafka.model.Color.values()[in.readEnum()];

      this.ProductType = com.example.kafka.model.ProductType.values()[in.readEnum()];

      this.DesignType = com.example.kafka.model.DesignType.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.Color = com.example.kafka.model.Color.values()[in.readEnum()];
          break;

        case 1:
          this.ProductType = com.example.kafka.model.ProductType.values()[in.readEnum()];
          break;

        case 2:
          this.DesignType = com.example.kafka.model.DesignType.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










