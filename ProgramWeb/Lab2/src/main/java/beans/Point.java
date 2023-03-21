package beans;

import java.io.Serializable;

public class Point implements Serializable {
    private double x;
    private double y;
    private double R;
    private boolean res;
    private long timeUsage;

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

    public void setTimeUsage(long timeUsage) {
        this.timeUsage = timeUsage;
    }

    public long getTimeUsage() {
        return timeUsage;
    }

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.R = r;
    }

    public Point(double x,double y,double R,boolean res) {
        this.x = x;
        this.y = y;
        this.R = R;
        this.res = res;
    }
}
