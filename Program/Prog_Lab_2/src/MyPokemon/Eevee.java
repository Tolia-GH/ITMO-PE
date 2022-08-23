package MyPokemon;

import Move.*;
import ru.ifmo.se.pokemon.*;

public class Eevee extends Pokemon {
    public Eevee (String name, int level) {
        super(name, level);
        setStats(55, 55, 50, 45, 65, 55);

        setType(Type.NORMAL);
        Confide skill1 = new Confide();
        DoubleTeam skill2 = new DoubleTeam();
        Swagger skill3 = new Swagger();

        setMove(skill1, skill2, skill3);
    }
}
