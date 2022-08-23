package Object;

import Characters.MainCharacters.MainCharacter;
import Characters.MyCharacter;

public class Thing {

    public enum State {
        GOOD,
        BAD,
        UNKNOWN;

        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private String name;
    private String description;
    private State state;
    private MyCharacter[] participants = new MainCharacter[7];
    private int numParticipants = 0;

    public Thing() {
        this.name = "something";
        this.state = State.UNKNOWN;
    }
    public Thing(State state) {
        this.name = "something";
        this.state = state;
    }
    public Thing(String name) {
        this.name = name;
        this.state = State.UNKNOWN;
    }
    public Thing(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void getWorse() {
        this.state = State.BAD;
        System.out.println(this.name + " gets worse.");
    }

    public void know(MainCharacter character) {
        System.out.println(character.getName() + " will know " + this.getName());
        System.out.println("That is: " + this.getDescription());
    }

    public void increaseNumParticipants(int num) {
        this.numParticipants += num;
    }

    public void showParticipants() {
        System.out.print("Now participants of " + this.name + " are: ");
        for(MyCharacter ch : participants) {
            if(ch == null) {
                continue;
            }
            System.out.print(ch.getName() + ", ");
        }
        System.out.print(".\n");
    }

    public boolean checkParticipant(MyCharacter character) {
        for(MyCharacter mainCh : participants) {
            if(mainCh == null) {
                break;
            }
            if(mainCh.equals(character)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public State getState() {
        return this.state;
    }

    public MyCharacter[] getParticipants() {
        return this.participants;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

}
