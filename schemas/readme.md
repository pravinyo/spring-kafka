### Download the jar for schema convertion to java
`$ wget https://apachemirror.wuchna.com/avro/avro-1.10.2/java/avro-tools-1.10.2.jar`

### Run below command to compile the schema
`$ java -jar avro-tools-1.10.2.jar compile schema user_schema.avsc ../compiled-schemas`
`$ java -jar avro-tools-1.10.2.jar compile schema product_schema.avsc ../compiled-schemas`