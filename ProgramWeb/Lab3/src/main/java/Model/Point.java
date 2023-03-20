package Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Data
@NoArgsConstructor
public class Point implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean hit;
    private double timeUsage;

    public Point(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
