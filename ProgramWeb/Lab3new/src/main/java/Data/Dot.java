package Data;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Dot implements Serializable {
    private Double x;
    private String y;
    private Double r;
    private boolean hit = true;
    private UserDate date;


    public Dot(Double x, String y, Double r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = Validator.validateRange(x,Double.parseDouble(y),r);
        this.date = new UserDate();
    }

}
