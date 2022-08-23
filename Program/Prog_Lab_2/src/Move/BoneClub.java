package Move;

import ru.ifmo.se.pokemon.*;

public class BoneClub extends PhysicalMove {

    public BoneClub() {
        super(Type.GROUND, 65, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon pok) {
        if(Math.random() <= 0.1) {
            Effect.flinch(pok);
        }
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
