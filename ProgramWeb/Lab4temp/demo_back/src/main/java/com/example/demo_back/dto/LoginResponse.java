package com.example.demo_back.dto;
public class LoginResponse {
    private boolean success;
    private String message;
    public LoginResponse(){

    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
