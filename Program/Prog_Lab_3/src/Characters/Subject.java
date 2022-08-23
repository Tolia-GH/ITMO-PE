package Characters;

import Characters.Interfaces.*;
import Characters.MainCharacters.Mood;
import Characters.OtherCharacters.Bees;
import Characters.OtherCharacters.People;
import Environment.Places.Place;
import Environment.Places.UnknownPlace;
import Environment.Weather;

public abstract class Subject implements Move,Say,Think {

    protected String name;
    protected Gender gender;
    public Mood mood;
    public Place location;
    public Place destination;

    public Subject() {
        this.name = "Someone";
        this.gender = Gender.UNKNOWN;
        this.location = new UnknownPlace();
    }

    public Subject(String name) {
        this.name = name;
        this.gender = Gender.UNKNOWN;
        this.location = new UnknownPlace();
    }

    public Subject(Gender gender) {
        if(gender.equals(Gender.FEMALE)) {
            this.name = "She";
        }
        else {
            this.name = "He";
        }
        this.gender = gender;
        this.location = new UnknownPlace();
    }

    public Subject(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.location = new UnknownPlace();
    }

    @Override
    public void move() {
        this.destination = new UnknownPlace();
        System.out.println(this.name + " set out.");
    }

    @Override
    public void move(boolean isTimeWasted) {
        this.destination = new UnknownPlace();
        if(isTimeWasted) {
            System.out.println(this.name + " set out.");
        }
        else System.out.println(this.name + " set out without wasting any time.");
    }

    @Override
    public void move(Place destination) {
        this.destination = destination;
        System.out.println(this.name + " moves to " + this.destination.toString() + ".");
    }

    @Override
    public void move(Place destination, boolean isTimeWasted) {
        this.destination = destination;
        if(isTimeWasted) {
            System.out.println(this.name + " moves to " + this.destination.toString() + ".");
        }
        else {
            System.out.println(this.name + " moves to " + this.destination.toString() + "without wasting any time.");
        }
    }

    @Override
    public void move(Subject subject) {
        this.destination = subject.location;
        System.out.println(this.name + " go to place " + subject.name + ".");
    }

    @Override
    public void move(Subject subject, boolean isTimeWasted) {
        this.destination = subject.location;
        if(isTimeWasted) {
            System.out.println(this.name + " go to place " + subject.name + ".");
        }
        else System.out.println(this.name + " go to place " + subject.name + " without wasting any time. ");
    }

    @Override
    public void say() {
        System.out.println(this.name + "talk something to himself");
    }

    @Override
    public void say(String words) {
        System.out.println(this.getName() + " says: " + '"' + words + '"');
    }

    @Override
    public void say(Subject subject) {
        System.out.println(this.name + " tells " + subject.name + " about this." );
    }

    @Override
    public void say(Subject subject, String words) {
        System.out.println(this.name + " tells " + subject.name + ':' + '"' + words + '"');
    }

    @Override
    public void think(boolean is, Bees bees, Weather weather) {
        if(is) {
            System.out.print(this.name + " thinks about " + bees.name);
        } else {
            System.out.print(this.name + " thinks not about " + bees.name);
        }
        bees.makeHoney(weather);
    }

    @Override
    public void think(boolean is, People people, Weather weather) {
        if(is) {
            System.out.print(this.name + " thinks about " + people.name);
        } else {
            System.out.print(this.name + " thinks not about " + people.name);
        }
        people.getLose(weather);
    }

    public String getName() {
        return this.name;
    }

    public String showGender() {
        return this.gender.toString().toLowerCase();
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void showMood() {
        System.out.println(this.name + " feels " + this.mood.toString().replace('_', ' ').toLowerCase());
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    public Place getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        Subject sub = (Subject) obj;
        return this.name.equals(sub.name) && this.gender.equals(sub.gender);
    }

    public int hashCode() {
        int result = 31;
        result = result * 31 + name.hashCode();
        result = result * 31 + gender.hashCode();

        return  result;
    }
}
