package Characters.Interfaces;

import Characters.MainCharacters.MainCharacter;
import Characters.MyCharacter;
import Environment.Places.Place;

public interface Move {

    void setOff(boolean isTimeWasted);
    void move(Place destination);
    void move(MyCharacter myCharacter);
    void run(String how);

    static void setOff(){
        System.out.println("They set off.");
    }

    static void walkOneByOne(MainCharacter[] mainCharacters) {
        for (MainCharacter mainChar: mainCharacters) {
            System.out.print(mainChar.getName() + " ");
        }
        System.out.print("walk one by one.\n");
    }

    static void walkSideBySide(MainCharacter[] mainCharacters) {
        for (MainCharacter mainChar: mainCharacters) {
            System.out.print(mainChar.getName() + " ");
        }
        System.out.print("walk side by side.\n");
    }

    static void chaseUp(MainCharacter[] mainCharacters) {
        for (MainCharacter mainChar: mainCharacters) {
            System.out.print(mainChar.getName() + " ");
        }
        System.out.print("chase up.\n");
    }
}
