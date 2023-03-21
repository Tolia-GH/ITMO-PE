package Data;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="dotsTable")
@SessionScoped
public class DotsTable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id",unique=true, nullable = false)
    private Long id;
    @Column(nullable = false,name="x")
    private Double x;
    @Column(nullable = false,name="y")
    private Double y;
    @Column(nullable = false,name="r")
    private Double r;
    @Column(nullable = false,name="hit")
    private boolean hit;
    @Column(nullable = false,name = "time")
    private String time;
    DotsTable(Double x,Double y,Double r, UserDate date){
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = date.getDateString();
        this.hit=Validator.validateRange(x,y,r);
    }
}
