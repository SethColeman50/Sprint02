package Project02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    @Test
    public void testRoll() {
        Die die = Die.getInstance();
        assertTrue(List.of(1, 2, 3).contains(die.roll(3)));
        assertNotEquals(0, die.roll(3));

        assertTrue(List.of(1, 2, 3, 4, 5).contains(die.roll(5)));
    }
}