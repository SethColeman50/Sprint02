package Project02;

import java.time.Instant;
import java.util.Random;

/**
 * A singleton that controls all RNG in the program, abstracted to a die that can have an arbitrary number of sides
 */
public class Die {
    private static Die onlyDie;
    private final Random rng;
    private Die() {
        // Seeds the rng with the current epoch
        this.rng = new Random(Instant.now().toEpochMilli());
    }

    /**
     * Gets the one die instance so all rng values are on the same seed
     * @return the Die class
     */
    public static Die getInstance() {
        if (onlyDie == null) {
            onlyDie = new Die();
        }
        return onlyDie;
    }

    // TODO: maybe a set seed

    /**
     * Rolls a die with a number of sides
     * @param sides the number of sides the die has
     * @return the number the die rolls
     */
    public int roll(int sides) {
        if (sides  < 3) {
            throw new IllegalArgumentException("Sides must be greater than 2");
        }
        return rng.nextInt(sides) + 1;
    }
}
