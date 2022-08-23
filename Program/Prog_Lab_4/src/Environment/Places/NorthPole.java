package Environment.Places;

import Characters.MainCharacters.MainCharacter;
import Characters.MyCharacter;

public class NorthPole extends Place{

    public NorthPole() {
        this.placeName = "The North Pole";
    }

    public class Inscription {

        public String getInscription() {
            String inscription = "OPENED BY WINNY THE POOH, THE POOH FOUND IT.";
            return inscription;
        }

        public void viewInscription(MyCharacter myCharacter) {
            System.out.println(myCharacter.getName() + " saw an inscription: " + getInscription());

        }
    }
}
