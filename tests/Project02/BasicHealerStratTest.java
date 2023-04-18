package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicHealerStratTest
{
    @Test
    public void testHealerCombat()
    {
        BasicHealer Vin = new BasicHealer("Old Man","Healer Plebs",100,new BasicHealerStrat());
        SchaperWarrior Para= new SchaperWarrior("Old Man","Healer Plebs",50,new WarriorStrategy());
        SchaperWizard Tony= new SchaperWizard("Old Man","bums",20,new WizardStrategy());
        SchaperWarrior Pedro2 = new SchaperWarrior("child","child2",100,new WarriorStrategy());

        assertEquals(-100,Vin.encounterLifePoints(Vin,Para));
        assertEquals(-10,Vin.encounterLifePoints(Vin,Tony));
        Vin.changeStrategy(new WarriorStrategy());
        assertEquals(0,Vin.encounterLifePoints(Vin,Pedro2));
    }

}