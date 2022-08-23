package Move;

import ru.ifmo.se.pokemon.*;

public class WillOWisp extends StatusMove {
    public WillOWisp() {
        super(Type.FIRE, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon pok) {
        Effect.burn(pok);
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
