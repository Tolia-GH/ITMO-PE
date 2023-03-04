package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PointsList implements Serializable {
    private int no = 0;
    private List<Point> pointList = new ArrayList<>();

    public PointsList() {

    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void addPoint(Point p) {
        ++no;
        pointList.add(p);
    }
}
