package Characters.MainCharacters;

import Characters.Interfaces.Believe;
import Characters.Interfaces.Event;
import Characters.Interfaces.Move;
import Characters.Interfaces.Wait;
import Characters.MyCharacter;
import Environment.Places.House;
import Environment.Places.Place;
import Object.Thing;

public class MainCharacter extends MyCharacter implements Believe, Event, Wait {

    private House house;

    public House getHouse() {
        return this.house;
    }

    private MainCharacter closeFriend;

    public static void setCloseFriend(MainCharacter mainCharacter1, MainCharacter mainCharacter2) {
        mainCharacter1.closeFriend = mainCharacter2;
        mainCharacter2.closeFriend = mainCharacter1;
    }

    public MainCharacter getCloseFriend() {
        return this.closeFriend;
    }

    public void showFriendShip() {
        System.out.println(this.getCloseFriend().getName() + " is " + this.getName() + "'s close friend.");
    }

    public MainCharacter() {
        super();
        this.house = new House(this);
        System.out.println("There is a character we know nothing.");
    }
    public MainCharacter(String name) {
        super(name);
        this.house = new House(this);
        System.out.println("There is a character called " + this.getName() + ".");
    }
    public MainCharacter(Gender gender) {
        super(gender);
        this.house = new House(this);
        System.out.println("There is a " + this.getGender().toString() + " character.");
    }
    public MainCharacter(String name, Gender gender) {
        super(name, gender);
        this.house = new House(this);
        System.out.println("There is a " + this.getGender().toString() + " character called " + this.getName() + ".");
    }

    public static void introduce() {
        System.out.println("Introducing characters");
    }

    public void goCamping() {
        System.out.println(this.getName());
    }

    @Override
    public void believe() {
        System.out.print(this.getName() + " believes that: ");
    }

    @Override
    public void doThing(Thing event) {
        event.getParticipants()[event.getNumParticipants()] = this;
        event.increaseNumParticipants(1);
        System.out.print(this.getName() + " did " + event.getName() + " " + event.getState() + ".\n");
    }

    @Override
    public void willTakePartIn(Thing event) {
        event.getParticipants()[event.getNumParticipants()] = this;
        event.increaseNumParticipants(1);
        System.out.println(this.getName() + " will take part in " + event.getName());
    }

    @Override
    public void waiting() {
        System.out.println(this.getName() + " is waiting them");
    }

    @Override
    public void waiting(MainCharacter character) {
        System.out.println(this.getName() + " is waiting " + character.getName());
    }

    public void setLocation(Place location) {
        super.setLocation(location);
        this.location.setMember(this);
    }

    public void sleep() {
        System.out.println(this.getName() + "has a good sleep.");
    }

    public void solveProblem() {

    }


}
