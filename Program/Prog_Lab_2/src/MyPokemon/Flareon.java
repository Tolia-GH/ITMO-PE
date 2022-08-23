package MyPokemon;

import Move.*;
import ru.ifmo.se.pokemon.*;

public class Flareon extends Eevee {
    public Flareon (String name, int level) {
        super(name, level);
        setStats(65, 130, 60, 95, 110, 65);
        setType(Type.FIRE);

        RockThrow skill4 = new RockThrow();

        addMove(skill4);
    }
}
