package Main;

import MyPokemon.*;
import ru.ifmo.se.pokemon.*;

public class Fight {
    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.addAlly(new Cryogonal("Snow", 50));
        battle.addAlly(new Eevee("Small Squirrel", 70));
        battle.addAlly(new Flareon("Big Squirrel", 100));
        battle.addFoe(new Torchic("Small Bird", 50));
        battle.addFoe(new Combusken("Middle Bird", 70));
        battle.addFoe(new Blaziken("Big Bird", 100));
        battle.go();
    }
}
