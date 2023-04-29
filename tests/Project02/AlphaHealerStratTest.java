package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphaHealerStratTest
{
    @Test
    public void testAlphaHealer()
    {
        AlphaHealer Vin = new AlphaHealer("bois", "gamers", 100, new AlphaHealerStrat());
        SchaperWarrior test = new SchaperWarrior("bois", "gamers", 10, new WarriorStrategy());
        SchaperWizard test2 = new SchaperWizard("bois", "gamers", 50, new WizardStrategy());
        SchaperWarrior test3 = new SchaperWarrior("e", "e3", 100, new WizardStrategy());

        assertEquals(-200,Vin.encounterLifePoints(Vin, test));
        assertEquals(93,Vin.getLifePoints());

        Vin.modifyLifePoints(-23);
        assertEquals(-25,Vin.encounterLifePoints(Vin, test2));
        assertEquals(95,Vin.getLifePoints());

        assertEquals(-1,Vin.encounterLifePoints(Vin,test3));

        Vin.modifyLifePoints(-70); //Test going into berserk strat
        assertEquals(-50,Vin.encounterLifePoints(Vin,test3));
    }
}