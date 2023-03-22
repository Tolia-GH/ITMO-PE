package Data;

import DataBase.DataBaseStorage;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="dots")
@Data
@SessionScoped
public class Dots implements Serializable {
    private static final long serialVersionUID = 1L;

    private Dot dot = new Dot();
    private List<Dot> dotsList = new ArrayList<>();
    private List<DotsTable> table = new ArrayList<>();
    private DataBaseStorage storage = new DataBaseStorage();

    public Dots(){ }

    public void addDot(){
        if (Validator.validateValues(dot)) {
            dot = new Dot(dotsList.size() + 1, dot.getX(),dot.getY(), dot.getR());
            dotsList.add(dot);
            DotsTable dotToTable = new DotsTable(dot.getX(), dot.getY(), dot.getR(), dot.getDate());
            try {
                storage.addNewDot(dotToTable);
            } catch (Exception e){
                e.printStackTrace();
            }
            table.add(dotToTable);
            dot = new Dot();
        }
    }

    public List<Dot> getDotsList() {
        return dotsList;
    }
}