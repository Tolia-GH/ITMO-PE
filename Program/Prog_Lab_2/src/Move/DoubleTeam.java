package Move;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pok) {
        Effect effect = new Effect().stat(Stat.EVASION, 1);
        pok.addEffect(effect);
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
