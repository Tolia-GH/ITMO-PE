package Characters.OtherCharacters;

import Characters.Subject;
import Environment.Weather;

public class Bees extends Subject {

    public Bees() {
        this.name = "Bees";
    }

    public void makeHoney(Weather weather) {
        if(weather.isBadWeather()) {
            System.out.print(" can not make all the honey ont this bad weather.\n");
        } else {
            System.out.print(" make all the honey on this weather.\n");
        }
    }

}
