package Characters;

import Characters.Interfaces.*;
import Characters.MainCharacters.MainCharacter;
import Characters.OtherCharacters.*;
import Environment.Places.*;
import Environment.Weather;
import MyExeption.InPutException;

import java.util.Scanner;

public abstract class MyCharacter implements Talk, Think, Move {

    /**
     * All the genders of Characters
     */
    public enum Gender {
        MALE,
        FEMALE,
        UNKNOWN;
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    /**
     * All the moods of Characters
     */
    public enum Mood {
        HAPPY,
        VERY_HAPPY,
        NOT_AFRAID,
        SAD,
        COLD_AND_SAD,
        UNKNOWN;

        private String reason;

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }

        public String toString() {
            return super.toString().replace('_',' ').toLowerCase();
        }
    }

    /** Shows the name of MyCharacter
     */
    private String name;
    /** Shows the gender of MyCharacter
     */
    private final Gender gender;
    /** Shows the mood of character
     */
    protected Mood mood;
    /** Shows the location of character
     */
    public Place location;
    /** Shows where the character is going to
     */
    public Place destination;

    /**
     * Build an unknown object which name is "Someone", gender is {@link Gender}.UNKNOWN, location is {@link UnknownPlace}
     */
    public MyCharacter() {
        this.name = "Someone";
        this.gender = Gender.UNKNOWN;
        this.location = new UnknownPlace();
    }

    /**
     * Build an object which gender is {@link Gender}.UNKNOWN, location is new {@link UnknownPlace} and set its name
     * @param name Set the name of this object
     */
    public MyCharacter(String name) {
        this.name = name;
        this.gender = Gender.UNKNOWN;
        this.location = new UnknownPlace();
    }

    /**
     * Build an object which gender is {@link Gender}.UNKNOWN, location is new {@link UnknownPlace} and set its gender
     * @param gender Set the gender of this object
     */
    public MyCharacter(Gender gender) {
        if(gender.equals(Gender.FEMALE)) {
            this.name = "She";
        }
        else {
            this.name = "He";
        }
        this.gender = gender;
        this.location = new UnknownPlace();
    }

    /**
     * Build an object which gender is {@link Gender}.UNKNOWN, location is new {@link UnknownPlace} and set its name and gender
     * @param name Set the name of this object
     * @param gender Set the gender of this object
     */
    public MyCharacter(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.location = new UnknownPlace();
    }

    /**
     * Walk around and check if time was wasted
     * @param isTimeWasted Judge if the time was wasted
     */
    @Override
    public void setOff(boolean isTimeWasted) {
        if(isTimeWasted) {
            System.out.println(this.getName() + " set off.");
        }
        else System.out.println(this.getName() + " set off without wasting any time.");
    }

    /**
     * Move to the destination
     * @param destination Set the destination of this movement
     */
    @Override
    public void move(Place destination) {
        this.destination = destination;
        System.out.println(this.getName() + " moves to " + this.destination.toString() + ".");
    }

    /**
     * Move to the location of other myCharacter
     * @param myCharacter Set the destination
     */
    @Override
    public void move(MyCharacter myCharacter) {
        this.destination = myCharacter.location;
        System.out.println(this.getName() + " go to place " + myCharacter.getName() + ".");
    }

    @Override
    public void run(String how) {
        System.out.println(this.getName() + " runs " + how);
    }

    /**
     * Say something
     * @param words The words which was said
     */
    @Override
    public void say(String words){
        System.out.println(this.getName() + " says: " + '"' + words + '"');
    }

    /**
     * Talk something to who
     * @param myCharacter The target of this conversation
     * @param words The words which was said
     */
    @Override
    public void say(MyCharacter myCharacter, String words) {
        System.out.println(this.name + " says to " + myCharacter.name + ':' + '"' + words + '"');
    }

    @Override
    public void answer(){
        System.out.println(this.name + " answers that " + new Scanner(System.in).nextLine());
    }

    /**
     * Say to who about something unknown
     * @param myCharacter The target of this conversation
     */
    @Override
    public void tell(MyCharacter myCharacter) {
        System.out.println(this.name + " tells " + myCharacter.name + " about this." );
    }

    /**
     * Ask someone something
     * @param myCharacter The target of this question
     * @param words The words which was asked
     */
    @Override
    public void ask(MyCharacter myCharacter, String words) {
        System.out.println(this.name + " asks " + myCharacter.name + ':' + '"' + words + '"');
    }

    @Override
    public void think(boolean is, Bees bees, Weather weather) {
        if(is) {
            System.out.print(this.name + " thinks about " + bees.getName());
        } else {
            System.out.print(this.name + " thinks not about " + bees.getName());
        }
        bees.makeHoney(weather);
    }

    @Override
    public void think(boolean is, People people, Weather weather) {
        if(is) {
            System.out.print(this.name + " thinks about " + people.getName());
        } else {
            System.out.print(this.name + " thinks not about " + people.getName());
        }
        people.getLose(weather);
    }

    /**
     * Get the name of this object
     * @return The name of this object
     */
    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Mood getMood() {
        return this.mood;
    }

    public Place getLocation() {
        return this.location;
    }

    public Place getDestination() {
        return this.destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
        this.mood.setReason("no reason");
    }

    public void setMood(Mood mood, String reason) {
        this.mood = mood;
        this.mood.setReason(reason);
    }

    public void showMood() {
        if(this.mood.reason.equals("no reason")) {
            System.out.println(this.name + " feels "
                    + this.mood.toString().replace('_', ' ').toLowerCase());
        }
        else {
            System.out.println(this.name + " feels "
                    + this.mood.toString().replace('_', ' ').toLowerCase()
                    + " because " + this.mood.reason);
        }
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
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

        MyCharacter sub = (MyCharacter) obj;
        return this.name.equals(sub.name) && this.gender.equals(sub.gender);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 31 + name.hashCode();
        result = result * 31 + gender.hashCode();

        return  result;
    }
}
