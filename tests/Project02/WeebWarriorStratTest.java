package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeebWarriorStratTest
{
    @Test
    public void testWeebWarriorCombat()
    {
        WeebWarrior Paradox=new WeebWarrior("Old Man","oldest men",100,new WeebWarriorStrat());
        SchaperWarrior StrikingDummy=new SchaperWarrior("Eorzea","FC",100,new WarriorStrategy());
        SchaperWizard StrikingDrone=new SchaperWizard("Eorzea","FC",100,new WizardStrategy());

        assertEquals(200,Paradox.encounterLifePoints(Paradox,StrikingDummy));
        assertEquals(200,Paradox.encounterLifePoints(Paradox,StrikingDrone));

        Paradox.modifyLifePoints(-31);
        assertEquals(6,Paradox.encounterLifePoints(Paradox,StrikingDummy));
        assertEquals(6,Paradox.encounterLifePoints(Paradox,StrikingDrone));

    }

    @Test
    public void testWeebWarriorFriend()
    {
        WeebWarrior Paradox=new WeebWarrior("Old Man","oldest men",100,new WeebWarriorStrat());
        SchaperWizard Vin=new SchaperWizard("old man","oldest men",50,new WeebWizardStrat());

        //Tests the big heal.
        assertEquals(200,Paradox.encounterLifePoints(Paradox,Vin));

        Vin.modifyLifePoints(100);
        Paradox.modifyLifePoints(-90);

        //Tests no heal.
        assertEquals(1,Paradox.encounterLifePoints(Paradox,Vin));

    }

}