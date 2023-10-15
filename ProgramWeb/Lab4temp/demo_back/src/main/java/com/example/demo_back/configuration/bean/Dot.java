package com.example.demo_back.configuration.bean;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Dot implements Serializable {
    private String owner;//
    private Double x;
    private Double y;
    private Integer r;
    private Boolean hit;
    private String date;
    public Dot(String owner, Double X,Double Y, Integer R){
        this.owner = owner;
        this.x = X;
        this.y = Y;
        this.r = R;
        checkHit();
        toDateString();
    }

    public void checkHit() {
        if(x >= 0 && y >= 0){
            this.hit = x <= r && y <= r;
        } else if(x < 0 && y > 0) {
            this.hit = (2 * x + r) > y;
        } else if (x < 0 && y < 0) {
            this.hit = 4 * x * x + 4 * y * y <= r * r;
        } else {
            this.hit = false;
        }
    }
    private void toDateString(){
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM HH:mm");
        this.date = ft.format(new Date());
    }
}