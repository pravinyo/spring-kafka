package com.example.kafka;

import com.example.kafka.enums.Color;
import com.example.kafka.enums.DesignType;
import com.example.kafka.enums.ProductType;
import com.example.kafka.enums.UserId;
import com.example.kafka.model.Event;
import com.example.kafka.model.Product;
import com.example.kafka.model.User;
import com.github.javafaker.Faker;


public class EventGenerator {

    private Faker faker = new Faker();

    public Event generateEvent() {
        return Event.builder()
                .user(generateRandomUser())
                .product(generateRandomObject())
                .build();
    }

    private User generateRandomUser() {
        return User.builder()
                .userId(faker.options().option(UserId.class))
                .username(faker.name().lastName())
                .dateOfBirth(faker.date().birthday())
                .build();
    }

    private Product generateRandomObject() {
        return Product.builder()
                .color(faker.options().option(Color.class))
                .type(faker.options().option(ProductType.class))
                .designType(faker.options().option(DesignType.class))
                .build();
    }
}
