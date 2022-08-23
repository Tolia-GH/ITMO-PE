package Move;

import ru.ifmo.se.pokemon.*;

public class AerialAce extends PhysicalMove {

    public AerialAce() {
        super(Type.FLYING, 60, 100);
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
