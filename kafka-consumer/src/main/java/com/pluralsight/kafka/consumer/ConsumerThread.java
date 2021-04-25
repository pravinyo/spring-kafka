package com.pluralsight.kafka.consumer;

import com.example.kafka.model.Product;
import com.example.kafka.model.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerThread implements Runnable{

    KafkaConsumer<User, Product> consumer;
    SuggestionEngine suggestionEngine;

    public ConsumerThread(Properties properties, SuggestionEngine suggestionEngine){
        this.consumer =  new KafkaConsumer<>(properties);
        this.suggestionEngine = suggestionEngine;
    }

    @Override
    public void run() {
        consumer.subscribe(Collections.singletonList("user-tracking"));

        while (true) {
            ConsumerRecords<User, Product> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<User, Product> record : records) {
                suggestionEngine.processSuggestions(record.key(), record.value());
            }
        }
    }
}
