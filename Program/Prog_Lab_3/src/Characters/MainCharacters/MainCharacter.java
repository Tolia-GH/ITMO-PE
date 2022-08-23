package Characters.MainCharacters;

import Characters.*;
import Environment.Places.Place;

public class MainCharacter extends Subject {

    public MainCharacter() {
        super();
        System.out.println("There is a character we know nothing.");
    }
    public MainCharacter(String name) {
        super(name);
        System.out.println("There is a character called " + this.getName() + ".");
    }
    public MainCharacter(Gender gender) {
        super(gender);
        System.out.println("There is a " + this.showGender() + " character.");
    }
    public MainCharacter(String name, Gender gender) {
        super(name, gender);
        System.out.println("There is a " + this.showGender() + " character called " + this.getName() + ".");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Place location) {
        super.setLocation(location);
        this.location.setMember(this);
    }
}
