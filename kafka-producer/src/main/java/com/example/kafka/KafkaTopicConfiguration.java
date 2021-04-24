package com.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic topicExample() {
        return TopicBuilder.name("user-tracking")
                .partitions(2)
                .replicas(2)
                .build();
    }
}
