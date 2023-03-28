package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeebWizardStratTest
{
    @Test
    public void testWeebWizardFight()
    {
        WeebWizard Vin= new WeebWizard("old man","oldest men",100,new WeebWizardStrat());
        SchaperWarrior Para=new SchaperWarrior("Fathers","Old dad",70,new WarriorStrategy());
        SchaperWizard Pedro=new SchaperWizard("Fathers","old dad",10,new WizardStrategy());

        assertEquals(-200,Vin.encounterLifePoints(Vin,Para)); //Test vs Warrior. Expected to be dealt double the held lifepoints.

        assertEquals(100,Vin.encounterLifePoints(Vin,Pedro)); //Test vs Wizard. Expected to deal the same exact lifepoints.

    }

    @Test
    public void testWeebWizardFreind()
    {
        WeebWizard Vin= new WeebWizard("old man","oldest men",100,new WeebWizardStrat());
        WeebWarrior Para=new WeebWarrior("old man","oldest men",50,new WarriorStrategy());
        SchaperWizard Pedro2=new SchaperWizard("old man","oldest men",100,new WizardStrategy());

        assertEquals(100,Vin.encounterLifePoints(Vin,Para)); //Test heal for same amount as health.
        assertEquals(-1,Vin.encounterLifePoints(Vin,Pedro2)); //Test to beat up other wizards.
        Vin.modifyLifePoints(-59);
        assertEquals(0,Vin.encounterLifePoints(Vin,Pedro2));
        assertEquals(41,Vin.encounterLifePoints(Vin,Para));


    }

}