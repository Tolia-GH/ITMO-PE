package Environment.Places;

import Characters.*;
import Characters.MainCharacters.*;


public class House extends Place {

    private MainCharacter owner;
    private MainCharacter[] neighbors = new MainCharacter[10];
    private int numNeighbors = 0;

    public House() {
        this.owner = null;
        this.placeName = "a House";
    }

    public House(MainCharacter owner) {
        this.owner = owner;
        this.placeName = this.owner.getName() + "'s House";
    }

    public void setNeighbors(MainCharacter[] neighbors) {
        this.neighbors = neighbors;
        this.numNeighbors += neighbors.length;
        for(MainCharacter mainChar : neighbors) {
            mainChar.getHouse().addNeighbor(this.owner);
        }
    }

    public void addNeighbor(MainCharacter neighbor) {
        this.neighbors[numNeighbors] = neighbor;
        this.numNeighbors ++;
        if(neighbor.equals(this.neighbors[numNeighbors])) {
            neighbor.getHouse().addNeighbor(this.owner);
        }
    }

    public void showNeighbors() {
        String neighborsList = "";
        for(MainCharacter mainChar : this.neighbors) {
            if(mainChar != null) {
                neighborsList += mainChar.getName() + " ";
            }
        }
        System.out.println(this.owner.getName() + " lives nearby " + neighborsList);
    }

    public MainCharacter getOwner() {
        return this.owner;
    }

    public MainCharacter[] getNeighbors() {
        return this.neighbors;
    }

}
