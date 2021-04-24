package com.example.kafka.model;

import com.example.kafka.enums.UserId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private UserId userId;

    private String username;

    private Date dateOfBirth;

}
