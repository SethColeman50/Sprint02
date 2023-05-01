package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreasureChestTest {
    @Test
    public void testTreasureChest() {
        People bearTrap = new TreasureChest("Artifacts", "Artifacts", 100);
        People testPerson = new SchaperWarrior("Schapers", "tribe1", 50, new WarriorStrategy());

        bearTrap.encounterLifePoints(bearTrap, testPerson);

        assertTrue(testPerson.getLifePoints() < 60);
        assertTrue(testPerson.getLifePoints() > 40);
    }
}