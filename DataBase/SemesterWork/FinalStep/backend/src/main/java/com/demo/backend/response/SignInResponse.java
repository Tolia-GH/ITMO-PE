package com.demo.backend.response;

import lombok.Data;

@Data
public class SignInResponse {
    private boolean success;
    private String message;
    private Integer id;
}
