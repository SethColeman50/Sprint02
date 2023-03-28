package Project02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SethStrategyTest {
    @Test
    public void testStrategy() {
        Strategy strategy = new SethWarriorStrategy();
        int maxLifePoints = 100;

        People MainPerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);

        // Friendly Case
        People FriendlyPerson = new testPerson("testNation", "otherTribe", maxLifePoints, strategy);
        assertEquals(5, MainPerson.encounterLifePoints(MainPerson, FriendlyPerson));

        // Enemy Case if at full health
        People FullHealthEnemyPerson = new testPerson("otherNation", "otherTribe", maxLifePoints, strategy);
        assertEquals(0, MainPerson.encounterLifePoints(MainPerson, FullHealthEnemyPerson));

        // Enemy Case if at 1/4 health
        People HalfHealthEnemyPerson = new testPerson("otherNation", "otherTribe", maxLifePoints / 4, strategy);
        assertEquals(25, MainPerson.encounterLifePoints(MainPerson, HalfHealthEnemyPerson));

        // Friendly Case
        People TribePerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);
        assertEquals(10, MainPerson.encounterLifePoints(MainPerson, TribePerson));

    }

    static class testPerson extends People{

        testPerson(String nation, String tribe, int lifePoints, Strategy strategy) {
            super(nation, tribe, PeopleType.wizard, lifePoints, strategy);
            myDescription = "\tTest Person";
        }

        @Override
        public int encounterLifePoints(People me, People otherPerson) {
            return encounterStrategy.strategy(me, otherPerson);
        }
    }
}