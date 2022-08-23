package Move;

import ru.ifmo.se.pokemon.*;

public class StoneEdge extends PhysicalMove {
    public StoneEdge() {
        super(Type.ROCK, 100, 80);
    }

    @Override
    protected double calcCriticalHit(Pokemon pok1, Pokemon pok2) {
        if(Math.random() < 0.8) {
            System.out.println("Критика!");
            return 2;
        }
        else {
            return 1;
        }
    }

    @Override
    protected String describe() {
        return "использует " + this.getClass().getSimpleName();
    }
}
