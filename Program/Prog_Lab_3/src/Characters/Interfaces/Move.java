package Characters.Interfaces;

import Characters.Subject;
import Environment.Places.Place;

public interface Move {
    void move();
    void move(boolean isTimeWasted);
    void move(Place destination);
    void move(Place destination, boolean isTimeWasted);
    void move(Subject subject);
    void move(Subject subject, boolean isTimeWasted);
}
