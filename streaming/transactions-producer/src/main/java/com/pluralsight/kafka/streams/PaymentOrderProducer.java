package com.pluralsight.kafka.streams;

import com.pluralsight.kafka.streams.model.Order;
import com.pluralsight.kafka.streams.model.Pair;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class PaymentOrderProducer implements Runnable{
    private final String topic;
    private Producer<String, Order> producer;
    private List<Pair<String, Order>> orders;

    public PaymentOrderProducer(List<Pair<String, Order>> orderList, Properties properties, String topic) {
        producer = new KafkaProducer<>(properties);
        this.orders = orderList;
        this.topic = topic;
    }

    @Override
    public void run() {


        for (Pair<String, Order> order: orders) {
            try {
                produceMessage(producer, order.key(), order.value());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }

    private void produceMessage(Producer<String, Order> producer, String key, Order value) throws InterruptedException {
        ProducerRecord<String, Order> producerRecord = new ProducerRecord<>(topic, key, value);
        producer.send(producerRecord);
        sleep(100);
    }
}
