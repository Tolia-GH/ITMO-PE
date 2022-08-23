package Environment.Places;

import Characters.MainCharacters.MainCharacter;
import Characters.Subject;

public abstract class Place {
    public String placeName;
    MainCharacter[] member = new MainCharacter[3];
    int numMember = 0;

    public Place() {
    }

    public Place(String placeName) {
        this.placeName = placeName;
    }

    public void setMember(MainCharacter character) {
        member[numMember] = character;
        numMember++;
    }
    public void arriveMember(MainCharacter character) {
        System.out.println(character.getName() + " arrives at " + character.destination.toString());
        member[numMember] = character;
        numMember++;
        character.location = character.destination;
        character.destination = null;
    }

    public void showMember() {
        System.out.print("In the " + this.placeName + " ");
        for(Subject sub : member) {
            if(sub == null) {
                continue;
            }
            System.out.print(sub.getName() + " ");
        }
        System.out.print(".\n");
    }

    public String getPlaceName() {
        return placeName;
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

        Place sub = (Place) obj;
        return this.placeName.equals(sub.placeName);
    }

    public int hashCode() {
        int result = 31;
        result = result * 31 + placeName.hashCode();

        return  result;
    }

    public String toString() {
        return this.getPlaceName();
    }

}
