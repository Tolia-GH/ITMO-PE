package Environment.Places;

import Characters.MainCharacters.MainCharacter;

public class Forest extends Place {
    public Forest() {
        this.placeName = "forest";
    }

    public class Road extends Place{

        public Road() {
            this.placeName = "Road";
            System.out.println("There's a " + this.placeName + " in the forest.");
        }

        public void getNarrow() {
            System.out.println(this.placeName + " gets narrow.");
        }

        public class BarbedWall {
            public BarbedWall() {
                System.out.println("Barbed wall shows up at two sides of road.");
            }
        }
    }

    public static class EmptyGround {
        public EmptyGround() {
            System.out.println("There's an empty ground on the road.");
        }
    }

    public static class Jungle {
        String name;

        public Jungle() {
            this.name = "jungle";
        }

        public void getCrowdIn(MainCharacter[] mainCharacters) {
            for (MainCharacter mainChar: mainCharacters) {
                System.out.print(mainChar.getName() + " ");
            }
            System.out.print("are huddled in the jungles\n");
        }

        public void listen(MainCharacter[] mainCharacters) {
            for (MainCharacter mainChar: mainCharacters) {
                System.out.print(mainChar.getName() + " ");
            }
            System.out.print("are listening\n");
        }
    }

    public static void isQuiet() {
        System.out.println("It is very quiet here, nothing can be here, nothing can be seen.");
    }
}
