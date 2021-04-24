package com.example.kafka.model;

import com.example.kafka.enums.Color;
import com.example.kafka.enums.DesignType;
import com.example.kafka.enums.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InternalProduct {
    private Color color;
    private ProductType type;
    private DesignType designType;
}
