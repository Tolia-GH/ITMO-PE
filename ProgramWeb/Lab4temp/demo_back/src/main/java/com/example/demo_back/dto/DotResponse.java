package com.example.demo_back.dto;

import lombok.Data;

@Data
public class DotResponse {
    private Double x;
    private Double y;
    private Integer r;
    private Boolean hit;
    private String date;
    private String message;
    private boolean wrong = false;
    public DotResponse(Double X, Double Y, Integer R, Boolean hit, String date, String message, boolean wrong){
        this.x = X;
        this.y = Y;
        this.r = R;
        this.date = date;
        this.hit = hit;
        this.message = message;
        this.wrong = wrong;
    }
    public DotResponse(){
        this.x = 0.0;
        this.y = 0.0;
        this.r = 0;
        this.date= "";
        this.hit = false;
        this.message = "";
        this.wrong = true;
    }
}
