package MyPokemon;

import Move.*;
import ru.ifmo.se.pokemon.*;

public class Cryogonal extends Pokemon {
    public Cryogonal (String name, int level) {
        super(name, level);
        setStats(80,50,50,95,135,105);
        setType(Type.ICE);
        AerialAce skill1 = new AerialAce();
        Swagger skill2 = new Swagger();
        Thunder skill3 = new Thunder();
        RockSlide skill4 = new RockSlide();
        setMove(skill1, skill2, skill3, skill4);
    }
}
