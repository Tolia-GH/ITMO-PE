package Collection;

import Collection.Exceptions.NullValueException;
import Collection.Exceptions.ValueOutOfRangeException;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -295, Поле не может быть null
    private double y; //Максимальное значение поля: 500

    public Coordinates(Float x,Double y) throws NullValueException,ValueOutOfRangeException {
        setX(x);
        setY(y);
    }

    public void setX(Float x) throws NullValueException,ValueOutOfRangeException {
        if(x==null) {
            throw new NullValueException("x can't be null");
        }
        else if(x<=-295) {
            throw new ValueOutOfRangeException("x should be bigger than -295");
        }
        else {
            this.x = x;
        }
    }

    public void setY(Double y) throws ValueOutOfRangeException {
        if(y>500) {
            throw new ValueOutOfRangeException("y shouldn't be bigger than 500");
        }
        else {
            this.y = y;
        }
    }

    public Float getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    public String toString() {
        return "Coordinates=" + "(" + this.x + "," + this.y + ")";
    }
}
