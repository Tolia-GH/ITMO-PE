package MyExeption;

import Characters.MyCharacter;

public class Problem extends RuntimeException{

    private String description;

    public Problem() {
        this.setDescription("no description");
    }

    public Problem(String description) {
        this.setDescription(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void printDescription() {
        System.out.println("There's a problem: " + this.getDescription());
    }

    public void toBeSolve(MyCharacter character) {
        System.out.println("This problem is going to be solved by " + character.getName() + '.');
    }
}
