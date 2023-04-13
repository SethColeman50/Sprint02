package Project02;

import java.time.Instant;
import java.util.Random;

public class Die {
    private static Die onlyDie;
    private final Random rng;
    private int numSides;
    private Die() {
        // Seeds the rng with the current epoch
        this.rng = new Random(Instant.now().toEpochMilli());
        this.numSides = 3;
    }

    public static Die getInstance() {
        if (onlyDie == null) {
            onlyDie = new Die();
        }
        return onlyDie;
    }

    // TODO: maybe a set seed

    public void setSides(int sides) {
        if (sides  < 3) {
            throw new IllegalArgumentException("Sides must be greater than 2");
        }

        this.numSides = sides;
    }

    public int roll() {
        return rng.nextInt(numSides) + 1;
    }
}
