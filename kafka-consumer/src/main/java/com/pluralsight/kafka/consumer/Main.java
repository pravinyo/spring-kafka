package com.pluralsight.kafka.consumer;


import com.example.kafka.model.Product;
import com.example.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public class Main {

    public static void main(String[] args) {

        SuggestionEngine suggestionEngine = new SuggestionEngine();

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "user-tracking-consumer");
        props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("specific.avro.reader", "true");
        props.put("schema.registry.url", "http://localhost:8081");

        KafkaConsumer<User, Product> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList("user-tracking"));

        while (true) {
            ConsumerRecords<User, Product> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<User, Product> record : records) {
                suggestionEngine.processSuggestions(record.key(), record.value());
            }
        }
    }
}
