package com.demo.backend.response;

import lombok.Data;

@Data
public class AccountResponse {
    private boolean success;
    private String message;
    private Integer id;
}
