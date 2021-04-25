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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static Properties properties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "user-tracking-consumer");
        props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("specific.avro.reader", "true");
        props.put("schema.registry.url", "http://localhost:8081");
        return props;
    }

    private static Properties properties2(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "user-tracking-consumer-process");
        props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("specific.avro.reader", "true");
        props.put("schema.registry.url", "http://localhost:8081");
        return props;
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // Partition will be divided among below 2 consumer as they belong to same group id
        // max active consumer = no. of partition and rest will be idle
        executorService.execute(new ConsumerThread(properties(), new SuggestionEngine()));
        executorService.execute(new ConsumerThread(properties(), new SuggestionEngine()));

        // this consumer is using different group id and there is only one consumer under this id,
        // so it will consume from all the partition.
        executorService.execute(new ConsumerThread(properties2(), new SuggestionEngine()));

        // Wait until all threads are finish
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
