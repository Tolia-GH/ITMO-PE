package Data;

import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Date;

@Data
@ApplicationScoped
@ManagedBean(name="timer")
public class Timer {
    private Date start;
    private Date now;
    private Integer mins;
    private String s;
    public Timer(){
        start = new Date();
        now = new Date();
    }

    public Integer getMins() {
        this.now = new Date();
        mins = (int)(now.getTime()-start.getTime())/1000;
        return mins;
    }
}
