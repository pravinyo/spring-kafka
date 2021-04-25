package com.pluralsight.kafka.streams;

import com.pluralsight.kafka.streams.model.Order;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ValidPaymentConsumer implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(ValidPaymentConsumer.class);
    private final KafkaConsumer<String, Order> consumer;
    private final String topic;

    public ValidPaymentConsumer(Properties properties, String topic) {
        consumer = new KafkaConsumer<>(properties);
        this.topic = topic;
    }

    @Override
    public void run() {
        consumer.subscribe(Collections.singletonList(topic));
        while (true) {
            ConsumerRecords<String, Order> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Order> record : records) {
                printOnEnter(record.key(), record.value());
            }
        }
    }

    private void printOnEnter(String transactionId, Order order) {
        LOG.info("\n*******************************************");
        LOG.info("ENTERING stream transaction with ID < " + transactionId + " >, " +
                "of user < " + order.getUserId() + " >, total amount < " + order.getTotalAmount() +
                " > and nb of items < " + order.getNbOfItems() + " >");
    }
}
