package com.example.demo_back.response;

import com.example.demo_back.JPAdatabase.DotJpa;

import java.util.List;

public class LoginResponse {
    List<DotJpa> dotList;
    private boolean success;
    private String message;
    public LoginResponse(){

    }

    public void setDotList(List<DotJpa> fetchedList) {
        this.dotList = fetchedList;
    }

    public List<DotJpa> getDotList() {
        return dotList;
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
