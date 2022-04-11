package Collection;

import Collection.Exceptions.NullValueException;
import Collection.Exceptions.ValueOutOfRangeException;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -295, Поле не может быть null
    private double y; //Максимальное значение поля: 500

    public Coordinates() {

    }
    public Coordinates(Float x,Double y) throws NullValueException,ValueOutOfRangeException {
        setX(x);
        setY(y);
    }

    public void setX(Float x) throws NullValueException,ValueOutOfRangeException {
        if (x == null) {
            throw new NullValueException("Error: x can not be empty!\n");
        } else if (x <= -295) {
            throw new ValueOutOfRangeException("Error: Value out of range! The range of x is >-295\n");
        } else {
            this.x = x;
        }
    }

    public void setY(Double y) throws ValueOutOfRangeException {
        if (y == null) {
            throw new NullValueException("Error: y can not be empty!\n");
        } else if (y>500) {
            throw new ValueOutOfRangeException("Error: Value out of range! The range of y is <500\n");
        } else {
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
