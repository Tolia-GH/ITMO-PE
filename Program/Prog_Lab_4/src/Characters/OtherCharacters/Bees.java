package Characters.OtherCharacters;

import Environment.Weather;

public class Bees extends OtherCharacter {

    public Bees() {
        this.setName("Bees");
    }

    public void makeHoney(Weather weather) {
        if(weather.isBadWeather()) {
            System.out.print(" can not make all the honey ont this bad weather.\n");
        } else {
            System.out.print(" make all the honey on this weather.\n");
        }
    }

}
