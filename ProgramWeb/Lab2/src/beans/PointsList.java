package beans;

import java.util.LinkedList;
import java.util.List;

public class PointsList {
    private List<Point> pointList;

    public PointsList() {
        pointList = new LinkedList<>();
    }

    public List<Point> getPointList() {
        return pointList;
    }
}
