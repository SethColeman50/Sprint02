package Project02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SethStrategyTest {
    @Test
    public void testWarriorStrategy() {
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

        // Same Tribe Case
        People TribePerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);
        assertEquals(10, MainPerson.encounterLifePoints(MainPerson, TribePerson));
    }

    @Test
    public void testWarriorStrat2() {
        Strategy strategy = new SethWarriorStrat2();
        int maxLifePoints = 100;

        People MainPerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);

        // Friendly Case
        People FriendlyPerson = new testPerson("testNation", "otherTribe", maxLifePoints, strategy);
        assertEquals(0, MainPerson.encounterLifePoints(MainPerson, FriendlyPerson));

        // Enemy Case if at full health
        People FullHealthEnemyPerson = new testPerson("otherNation", "otherTribe", maxLifePoints, strategy);
        assertEquals(5, MainPerson.encounterLifePoints(MainPerson, FullHealthEnemyPerson));

        // Enemy Case if at 1/6 health
        People HalfHealthEnemyPerson = new testPerson("otherNation", "otherTribe", maxLifePoints / 4, strategy);
        assertEquals(5, MainPerson.encounterLifePoints(MainPerson, HalfHealthEnemyPerson));

        // Same Tribe Case
        People TribePerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);
        assertEquals(5, MainPerson.encounterLifePoints(MainPerson, TribePerson));
    }

    @Test
    public void testWizardStrategy() {
        Strategy strategy = new SethWizardStrategy();
        int maxLifePoints = 100;

        People MainPerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);

        // Friendly Case if warrior
        People FriendlyWarrior = new testPerson("testNation", "otherTribe", maxLifePoints, new SethWarriorStrategy());
        assertEquals(25, MainPerson.encounterLifePoints(MainPerson, FriendlyWarrior));

        // Friendly Case if wizard
        People FriendlyWizard = new testPerson("testNation", "otherTribe", maxLifePoints, strategy);
        assertEquals(0, MainPerson.encounterLifePoints(MainPerson, FriendlyWizard));

        // Enemy Case if at 1/10 health
        People tenPercentEnemyPerson = new testPerson("otherNation", "otherTribe", maxLifePoints / 10, strategy);
        assertEquals(10, MainPerson.encounterLifePoints(MainPerson, tenPercentEnemyPerson));

        // Enemy Case if not at 1/10 health
        People RegularEnemyPerson = new testPerson("otherNation", "otherTribe", maxLifePoints, strategy);
        assertEquals(0, MainPerson.encounterLifePoints(MainPerson, RegularEnemyPerson));

        // Same Tribe Case
        People TribePerson = new testPerson("testNation", "testTribe", maxLifePoints, strategy);
        assertEquals(50, MainPerson.encounterLifePoints(MainPerson, TribePerson));
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