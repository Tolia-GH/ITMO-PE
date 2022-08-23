package Move;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {

    public Confide() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon pok) {
        Effect effect = new Effect().stat(Stat.SPECIAL_ATTACK, -1);
        pok.addEffect(effect);
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
