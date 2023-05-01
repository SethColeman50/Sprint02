package Project02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BearTrapTest {
    @Test
    public void testBearTrap() {
        People bearTrap = new BearTrap("Artifacts", "Artifacts", 100);
        People testPerson = new SchaperWarrior("Schapers", "tribe1", 100, new WarriorStrategy());

        bearTrap.encounterLifePoints(bearTrap, testPerson);

        assertTrue(List.of(20, 30).contains(testPerson.getLifePoints()));
    }
}