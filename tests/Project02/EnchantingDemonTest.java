package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnchantingDemonTest
{
    @Test
    public void testthesuccubi()
    {
        EnchantingDemon succubi = new EnchantingDemon("demon","demons",100);
        SchaperWarrior test = new SchaperWarrior("e","a",100,new WarriorStrategy());
        succubi.encounterLifePoints(succubi,test);

        assertEquals(31,test.getLifePoints());
    }

}