package com.example.ipassignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private int errorCode;
    private String error;
    private List<String> fieldErrors = new ArrayList<>();
}
