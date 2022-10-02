package com.assignment.cosmos.response;

import lombok.Data;

@Data
public class ApiResponse {
    private  String message;
    private Boolean error;
}