package Collection;

import Exceptions.NullValueException;
import Exceptions.ValueOutOfRangeException;

import java.io.Serializable;

/**
 * The type Coordinates.
 */
public class Coordinates implements Serializable {
    /**
     * The X.
     */
    private Float x; //Значение поля должно быть больше -295, Поле не может быть null
    /**
     * The Y.
     */
    private double y; //Максимальное значение поля: 500

    /**
     * Instantiates a new Coordinates.
     */
    public Coordinates() {

    }

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     * @throws NullValueException       the null value exception
     * @throws ValueOutOfRangeException the value out of range exception
     */
    public Coordinates(Float x,Double y) throws NullValueException,ValueOutOfRangeException {
        setX(x);
        setY(y);
    }

    /**
     * Sets x.
     *
     * @param x the x
     * @throws NullValueException       the null value exception
     * @throws ValueOutOfRangeException the value out of range exception
     */
    public void setX(Float x) throws NullValueException,ValueOutOfRangeException {
        if (x == null) {
            throw new NullValueException("Error: x can not be empty!\n");
        } else if (x <= -295) {
            throw new ValueOutOfRangeException("Error: Value out of range! The range of x is >-295\n");
        } else {
            this.x = x;
        }
    }

    /**
     * Sets y.
     *
     * @param y the y
     * @throws ValueOutOfRangeException the value out of range exception
     */
    public void setY(Double y) throws ValueOutOfRangeException {
        if (y == null) {
            throw new NullValueException("Error: y can not be empty!\n");
        } else if (y>500) {
            throw new ValueOutOfRangeException("Error: Value out of range! The range of y is <500\n");
        } else {
            this.y = y;
        }
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public Float getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public Double getY() {
        return this.y;
    }

    public String toString() {
        return "Coordinates=" + "(" + this.x + "," + this.y + ")";
    }
}
