package beans;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.Serializable;

public class Point implements Serializable {
    private double x;
    private double y;
    private double R;
    private boolean res;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public boolean getRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }
    public Point() {}

    public Point(double x,double y,double R,boolean res) {
        this.x = x;
        this.y = y;
        this.R = R;
        this.res = res;
    }



}
