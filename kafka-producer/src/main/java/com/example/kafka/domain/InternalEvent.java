package com.example.kafka.domain;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class InternalEvent {
    private InternalUser user;
    private InternalProduct product;
}
