package Characters.OtherCharacters;

import Characters.Subject;
import Environment.Weather;

public class Tiger extends Subject {

    public Tiger() {
        this.name = "tiger";
    }

    public String jumpForward(Weather weather) {
        if(weather.isBadWeather()) {
            return this.name + " always jump forward.";
        }
        return "";
    }
}
