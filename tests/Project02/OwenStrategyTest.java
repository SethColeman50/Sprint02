package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwenStrategyTest {

    @Test
    public void testSameNations() {
        OwenWarrior warrior = new OwenWarrior("Nation", "Tribe",100, new OwenWarriorStrategy());
        OwenWizard wizard = new OwenWizard("Nation", "Tribe", 100, new OwenWizardStrategy());

        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,wizard.encounterLifePoints(wizard,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));


        warrior.modifyLifePoints(-5);
        assertEquals(5,wizard.encounterLifePoints(wizard,warrior));
        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));
    }

    @Test
    public void testDifferentNationsWarrior() {
        OwenWarrior warrior = new OwenWarrior("Nation","Tribe",100, new OwenWarriorStrategy());
        OwenWizard wizard = new OwenWizard("Nation2", "Tribe", 100, new OwenWizardStrategy());

        assertEquals(100,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));


        warrior.modifyLifePoints(-5);
        assertEquals(95,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));

        wizard.modifyLifePoints(-10);
        assertEquals(90,warrior.encounterLifePoints(warrior,wizard));
    }
    @Test
    public void testDifferentNationsWizard() {
        OwenWarrior warrior = new OwenWarrior("Nation","Tribe",100, new OwenWarriorStrategy());
        OwenWizard wizard = new OwenWizard("Nation2", "Tribe", 100, new OwenWizardStrategy());

        assertEquals(0,wizard.encounterLifePoints(wizard,wizard));
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));


        warrior.modifyLifePoints(-5);
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));
        assertEquals(0,wizard.encounterLifePoints(wizard,wizard));

        wizard.modifyLifePoints(-10);
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));

    }

}