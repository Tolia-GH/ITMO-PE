package Model;

import lombok.Data;

import javax.faces.bean.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ManagedBean(name="points", eager = true)
@SessionScoped

public class Points implements Serializable {
    private static final long serialVersionUID = 1L;

    private Point point;
    private List<Point> pointList = new ArrayList<>();

    public void addPoint() {
        System.out.println(point.getX() + point.getY() + point.getR());
        pointList.add(point);
        point = new Point();
    }
}