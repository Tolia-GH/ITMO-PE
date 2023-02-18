package beans;

import java.util.LinkedList;
import java.util.List;

public class PointsList {
    private static List<Point> pointList = new LinkedList<>();

    public PointsList() {
        pointList = new LinkedList<>();
    }

    public static List<Point> getPointList() {
        return pointList;
    }
}
