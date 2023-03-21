package Data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class Dot implements Serializable {
    private Double x;
    private Double y;
    private Double r;
    private boolean hit = true;
    private UserDate date;


    public Dot(Double x, Double y, Double r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = Validator.validateRange(x,y,r);
        this.date = new UserDate();
    }

}
