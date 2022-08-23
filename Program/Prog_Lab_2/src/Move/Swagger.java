package Move;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon pok) {
        if(Math.random() < 0.15) {
            Effect effect = new Effect().stat(Stat.ATTACK, 2);
            pok.addEffect(effect);
            Effect.confuse(pok);
        }
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
