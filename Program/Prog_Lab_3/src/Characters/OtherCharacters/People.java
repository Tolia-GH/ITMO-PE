package Characters.OtherCharacters;

import Characters.MainCharacters.Mood;
import Characters.Subject;
import Environment.Places.Forest;
import Environment.Weather;

public class People extends Subject {

    @Override
    public void showMood() {
        System.out.print(" feels " + this.mood.toString().replace('_', ' ').toLowerCase() + ".\n");
    }

    public People() {
        this.name = "people";
        this.setMood(Mood.UNKNOWN);
        this.location = new Forest();
    }

    public void getLose(Weather weather) {
        if(weather.isBadWeather()) {
            this.setMood(Mood.COLD_AND_SAD);
            System.out.print(" who are lost in the " + this.location.toString());
            this.showMood();
        } else {
            System.out.print(".\n");
        }
    }

}
