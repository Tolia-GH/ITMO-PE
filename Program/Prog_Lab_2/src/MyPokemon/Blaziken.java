package MyPokemon;

import Move.*;

public class Blaziken extends Combusken {
    public Blaziken (String name, int level) {
        super(name, level);
        setStats(80, 120, 70, 110, 70, 80);

        WillOWisp skill4 = new WillOWisp();

        addMove(skill4);
    }
}
