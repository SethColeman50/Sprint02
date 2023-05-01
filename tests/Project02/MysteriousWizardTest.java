package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MysteriousWizardTest
{
    @Test
    public void MerlinTest()
    {
        MysteriousWizard merlin = new MysteriousWizard("none","ye oldes",10000);
        SchaperWarrior test = new SchaperWarrior("e","u",100,new WarriorStrategy());
        assertEquals(0,merlin.encounterLifePoints(merlin,test));
        System.out.println(test.getStrat());
        SchaperWizard test2 = new SchaperWizard("e","u",100,new WizardStrategy());
        assertEquals(0,merlin.encounterLifePoints(merlin,test2));
        System.out.println(test2.getStrat());
    }

}