package com.example.kafka;

import com.example.kafka.enums.Color;
import com.example.kafka.enums.DesignType;
import com.example.kafka.enums.ProductType;
import com.example.kafka.enums.UserId;
import com.example.kafka.domain.InternalEvent;
import com.example.kafka.domain.InternalProduct;
import com.example.kafka.domain.InternalUser;
import com.github.javafaker.Faker;


public class EventGenerator {

    private Faker faker = new Faker();

    public InternalEvent generateEvent() {
        return InternalEvent.builder()
                .user(generateRandomUser())
                .product(generateRandomObject())
                .build();
    }

    private InternalUser generateRandomUser() {
        return InternalUser.builder()
                .userId(faker.options().option(UserId.class))
                .username(faker.name().lastName())
                .dateOfBirth(faker.date().birthday())
                .build();
    }

    private InternalProduct generateRandomObject() {
        return InternalProduct.builder()
                .color(faker.options().option(Color.class))
                .type(faker.options().option(ProductType.class))
                .designType(faker.options().option(DesignType.class))
                .build();
    }
}
