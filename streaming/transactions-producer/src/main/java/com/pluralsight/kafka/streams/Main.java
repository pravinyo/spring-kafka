package com.pluralsight.kafka.streams;


import com.pluralsight.kafka.streams.model.Order;
import com.pluralsight.kafka.streams.model.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String TOPIC_PAYMENT = "payments";
    private static String TOPIC_VALID_PAYMENT = "validated-payments";

    private static Properties properties(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        props.put("schema.registry.url", "http://localhost:8081");
        return props;
    }

    private static Properties properties2(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("group.id", "payment-processor");
        props.put("specific.avro.reader", "true");
        props.put("schema.registry.url", "http://localhost:8081");
        return props;
    }

    private static List<Pair<String,Order>> orders(){
        List<Pair<String, Order>> orders = new ArrayList<>();
        orders.add(new Pair<>("1", Order.newBuilder()
                .setUserId("")
                .setNbOfItems(5)
                .setTotalAmount(5)
                .build()));

        for(int i = 1; i <= 5; i++) {
            orders.add(new Pair<>("2", Order.newBuilder()
                    .setUserId("123")
                    .setNbOfItems(1001)
                    .setTotalAmount(100)
                    .build()));
        }

        orders.add(new Pair<>("3", Order.newBuilder()
                .setUserId("ghi")
                .setNbOfItems(1)
                .setTotalAmount(10001)
                .build()));

        orders.add(new Pair<>("4", Order.newBuilder()
                .setUserId("abc")
                .setNbOfItems(10)
                .setTotalAmount(100)
                .build()));

        orders.add(new Pair<>("5", Order.newBuilder()
                .setUserId("JKL")
                .setNbOfItems(1)
                .setTotalAmount(1)
                .build()));

        return orders;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new ValidPaymentConsumer(properties2(), TOPIC_VALID_PAYMENT));
        executorService.execute(new PaymentOrderProducer(orders(),properties(), TOPIC_PAYMENT));

        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
