package Move;

import ru.ifmo.se.pokemon.*;

public class RockThrow extends PhysicalMove {
    public RockThrow() {
        super(Type.ROCK, 50, 90);
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
