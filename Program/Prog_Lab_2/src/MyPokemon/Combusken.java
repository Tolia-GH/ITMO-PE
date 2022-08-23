package MyPokemon;

import Move.*;
import ru.ifmo.se.pokemon.*;

public class Combusken extends Torchic {
    public Combusken (String name, int level) {
        super(name, level);
        setStats(60,85,60,85,60,55);
        addType(Type.FIGHTING);

        BoneClub skill3 = new BoneClub();

        addMove(skill3);
    }
}
