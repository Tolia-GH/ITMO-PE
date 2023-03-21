package Data;

import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.HashSet;

@Data
@ManagedBean(name="number")
@ApplicationScoped
public class NumberDot implements Serializable {
    private int number = 1;
    private HashSet<Integer> hashSet = new HashSet<>();
    private String result = "";
    public void onClick(){
        int a = 0;
        while (a<10){
            if(number==1||number==2||number==3){
                a++;
                hashSet.add(number);
                number++;
            }else {
                boolean add = true;
                for(int i = 2; i < number;i++){
                    if(number%i == 0){
                        add = false;
                    }
                }
                if(add){
                    a++;
                    hashSet.add(number);
                    number++;
                }
            }
        }
        result = toString();
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Integer i: hashSet){
            s.append(" ").append(i);
        }
        return s.toString();
    }
}
