package Data;

import javax.faces.bean.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import DataBase.DataBaseStorage;
import lombok.Data;

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
        if(Validator.validateValues(dot)){
            dot = new Dot(dot.getX(),dot.getY()+"", dot.getR());
            dotsList.add(dot);
            DotsTable dotToTable = new DotsTable(dot.getX(),Double.parseDouble(dot.getY()), dot.getR(), dot.getDate());
            try{
                storage.addNewDot(dotToTable);
            }catch (Exception e){
                e.getMessage();
            }
            table.add(dotToTable);
            dot = new Dot();
        }
    }

    public void delete(){
        this.dotsList.clear();
        for(DotsTable removed:table){
            storage.deleteDot(removed);
        }
        this.table.clear();
    }

    public void deleteone(Dot dot){
        this.dotsList.remove(dot);
    }

    public List<Dot> getDotsList() {
        return dotsList;
    }
}