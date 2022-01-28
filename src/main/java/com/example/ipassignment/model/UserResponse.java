package com.example.ipassignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class UserResponse implements Serializable {
    private String message;
    private UUID randomCode;
    private String city;
}
