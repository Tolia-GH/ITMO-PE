package Data;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@ManagedBean(name = "UserDate",eager = true)
@ApplicationScoped
public class UserDate implements Serializable {
    public UserDate(){
        this.date = new Date();
        this.dateString = getDateString();
    }
    private Date date;
    private String dateString;

    public String getDateString() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        setDateString(ft.format(this.date));
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Date getDate() {
        this.date = renewDate();
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date renewDate(){
        Date newDate = new Date();
        this.date = newDate;
        return  newDate;
    }

    public String toString(){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return ft.format(this.date);
    }
}
