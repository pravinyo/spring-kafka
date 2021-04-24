package com.example.kafka;

import com.example.kafka.domain.InternalEvent;
import com.example.kafka.model.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Properties;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class KafkaApplication implements CommandLineRunner {
	static Logger log = LoggerFactory.getLogger(KafkaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}


	private static User extractKey(InternalEvent event) {
		return User.newBuilder()
				.setUserId(event.getUser().getUserId().toString())
				.setUsername(event.getUser().getUsername())
				.setDateOfBirth((int)event.getUser()
						.getDateOfBirth()
						.toInstant()
						.atZone(ZoneId.systemDefault())
						.getLong(ChronoField.EPOCH_DAY))
				.build();
	}

	private static Product extractValue(InternalEvent event) {
		return Product.newBuilder()
				.setProductType(ProductType.valueOf(event.getProduct().getType().name()))
				.setColor(Color.valueOf(event.getProduct().getColor().name()))
				.setDesignType(DesignType.valueOf(event.getProduct().getDesignType().name()))
				.build();
	}

	@Override
	public void run(String... args) throws Exception {
		EventGenerator eventGenerator = new EventGenerator();

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9091");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", "http://localhost:8081");

		Producer<User, Product> producer = new KafkaProducer<>(props);

		for(int i = 1; i <= 10; i++) {
			log.info("Generating event #" + i);

			InternalEvent event = eventGenerator.generateEvent();

			User key = extractKey(event);
			Product value = extractValue(event);

			ProducerRecord<User, Product> producerRecord = new ProducerRecord<>("user-tracking", key, value);

			log.info("Producing to Kafka the record: " + key + ":" + value);
			producer.send(producerRecord);

			sleep(1000);
		}

		producer.close();
	}
}
