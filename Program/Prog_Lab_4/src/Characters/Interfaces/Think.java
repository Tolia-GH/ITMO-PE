package Characters.Interfaces;

import Characters.OtherCharacters.Bees;
import Characters.OtherCharacters.People;
import Environment.Weather;

public interface Think {
    void think(boolean is, Bees bees, Weather weather);
    void think(boolean is, People people, Weather weather);
}
