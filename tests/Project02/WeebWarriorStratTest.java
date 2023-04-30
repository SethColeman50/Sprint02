package Project02;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WeebWarriorStratTest
{
    @Test
    public void testWeebWarriorCombat1()
    {
        WeebWarrior Paradox=new WeebWarrior("Old Man","oldest men",100,new WeebWarriorStrat());
        SchaperWizard StrikingDrone=new SchaperWizard("Eorzea","FC",100,new WizardStrategy());

        assertEquals(100,Paradox.encounterLifePoints(Paradox,StrikingDrone));

        Paradox.modifyLifePoints(-31);
        assertEquals(6,Paradox.encounterLifePoints(Paradox,StrikingDrone));

    }

    @Test
    public void testWeebWarriorFriend()
    {
        WeebWarrior Paradox=new WeebWarrior("Old Man","oldest men",100,new WeebWarriorStrat());
        SchaperWizard Vin=new SchaperWizard("Old Man","oldest men",50,new WeebWizardStrat());

        //Tests the big heal.
        assertEquals(-100,Paradox.encounterLifePoints(Paradox,Vin));

        Vin.modifyLifePoints(100);
        Paradox.modifyLifePoints(-90);

        //Tests smallest.
        assertEquals(1,Paradox.encounterLifePoints(Paradox,Vin));

    }

    @Test
    public void testWeebWarriorChange()
    {
        SchaperWarrior StrikingDummy = new SchaperWarrior("Eorzea","FC",100,new WarriorStrategy());
        WeebWarrior Paradox = new WeebWarrior("Old Man","Oldest Men",100,new WeebWarriorStrat());

        assertEquals(120,Paradox.encounterLifePoints(Paradox,StrikingDummy));
        assertEquals(1,Paradox.getLifePoints());

        Paradox.modifyLifePoints(50);
        StrikingDummy.modifyLifePoints(50);
        assertEquals(25,Paradox.encounterLifePoints(Paradox,StrikingDummy));
        assertEquals(40,Paradox.getLifePoints());
    }

}