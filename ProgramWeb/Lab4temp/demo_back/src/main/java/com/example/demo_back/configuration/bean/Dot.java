package com.example.demo_back.configuration.bean;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Dot implements Serializable {
    private Double x;
    private Double y;
    private Integer r;
    private Boolean hit;
    private String date;
    public Dot(Double X,Double Y, Integer R){
        this.x = X;
        this.y = Y;
        this.r = R;
        checkHit();
        toDateString();
    }

    public void checkHit() {
        if((x*x+y*y<=r*r) && x>=0 && y>=0){
            this.hit = true;
        }else if((x>=0&&y<=0) && x<=r && y>=-r){
            this.hit = true;
        }else {
            this.hit = (x<=0&&y<=0) && x>=-r/2 && y>=-2*x-r;
        }
    }
    private void toDateString(){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = ft.format(new Date());
    }
}