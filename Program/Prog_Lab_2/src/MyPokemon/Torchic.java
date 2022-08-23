package MyPokemon;

import Move.*;
import ru.ifmo.se.pokemon.*;

public class Torchic extends Pokemon {
    public Torchic (String name, int level) {
        super(name, level);
        setStats(45, 60, 40, 70, 50, 45);
        setType(Type.FIRE);

        StoneEdge skill1 = new StoneEdge();
        AerialAce skill2 = new AerialAce();

        setMove(skill1, skill2);
    }
}
