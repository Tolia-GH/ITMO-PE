package Move;

import ru.ifmo.se.pokemon.*;

public class Thunder extends SpecialMove {
    public Thunder() {
        super(Type.ELECTRIC, 110, 70);
    }

    @Override
    protected void applyOppEffects(Pokemon pok) {
        if(Math.random() < 0.3) {
            Effect.paralyze(pok);
        }
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
