package com.example.demo_back.response;

import com.example.demo_back.JPAdatabase.DotJpa;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DotResponse {
    private List<DotJpa> dotList;
    private String owner;
    private Double x;
    private Double y;
    private Integer r;
    private Boolean hit;
    private String date;
    private String message;
    private boolean wrong = false;
    public DotResponse(List<DotJpa> list, String owner, Double X, Double Y, Integer R, Boolean hit, String date, String message, boolean wrong){
        this.dotList = list;
        this.owner = owner;
        this.x = X;
        this.y = Y;
        this.r = R;
        this.date = date;
        this.hit = hit;
        this.message = message;
        this.wrong = wrong;
    }
    public DotResponse(){
        this.dotList = new ArrayList<>();
        this.owner = "";
        this.x = 0.0;
        this.y = 0.0;
        this.r = 0;
        this.date= "";
        this.hit = false;
        this.message = "";
        this.wrong = true;
    }
}
