package Characters.MainCharacters;

public class Rabbit extends MainCharacter {
    public Rabbit() {
        super("Rabbit");
    }
    public Rabbit(String name) {
        super(name);
    }
    public Rabbit(Gender gender) {
        super(gender);
    }
    public Rabbit(String name, Gender gender) {
        super(name, gender);
    }

    public void coverMouth() {
        System.out.print("Covering mouth with claws, ");
    }

    public void turnAroundAndPush(MainCharacter character) {
        System.out.println(this.getName() + " turns around and push " + character.getName());
    }


}
