package Project02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OwenStrategyTest {

    @Test
    public void testSameNations() {
        OwenWarrior warrior = new OwenWarrior("Nation", "Tribe",100, new OwenWarriorStrategy(), new OwenWizardStrategy2());
        OwenWizard wizard = new OwenWizard("Nation", "Tribe", 100, new OwenWizardStrategy(), new OwenWizardStrategy2());
        OwenHealer healer = new OwenHealer("Nation","Tribe",100,new OwenHealerStrategy(), new OwenHealerStrategy2());

        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,wizard.encounterLifePoints(wizard,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));


        warrior.modifyLifePoints(-5);
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));
        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));
    }

    @Test
    public void testMultipleStrategies() {
        OwenWarrior warrior = new OwenWarrior("Nation", "Tribe",100, new OwenWarriorStrategy(), new OwenWarriorStrategy2());
        OwenWizard wizard = new OwenWizard("Nation", "Tribe", 100, new OwenWizardStrategy(), new OwenWizardStrategy2());
        OwenHealer healer = new OwenHealer("Nation","Tribe",100,new OwenHealerStrategy(), new OwenHealerStrategy2());

        assertEquals(new OwenWarriorStrategy().getClass(), warrior.encounterStrategy.getClass());
        assertEquals(new OwenWizardStrategy().getClass(), wizard.encounterStrategy.getClass());
        assertEquals(new OwenHealerStrategy().getClass(), healer.encounterStrategy.getClass());

        warrior.modifyLifePoints(-30);
        wizard.modifyLifePoints(-35);
        healer.modifyLifePoints(-25);
        warrior.encounterLifePoints(warrior,wizard);
        wizard.encounterLifePoints(wizard,warrior);
        healer.encounterLifePoints(healer,wizard);

        assertEquals(new OwenWarriorStrategy2().getClass(), warrior.encounterStrategy.getClass());
        assertEquals(new OwenWizardStrategy2().getClass(), wizard.encounterStrategy.getClass());
        assertEquals(new OwenHealerStrategy2().getClass(), healer.encounterStrategy.getClass());
    }

    @Test
    public void testDifferentNationsWarrior() {
        OwenWarrior warrior = new OwenWarrior("Nation", "Tribe",100, new OwenWarriorStrategy(), new OwenWizardStrategy2());
        OwenWizard wizard = new OwenWizard("Nation", "Tribe", 100, new OwenWizardStrategy(), new OwenWizardStrategy2());
        OwenHealer healer = new OwenHealer("Nation","Tribe",100,new OwenHealerStrategy(), new OwenHealerStrategy2());

        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));


        warrior.modifyLifePoints(-5);
        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
        assertEquals(0,warrior.encounterLifePoints(warrior,warrior));

        wizard.modifyLifePoints(-10);
        assertEquals(0,warrior.encounterLifePoints(warrior,wizard));
    }
    @Test
    public void testDifferentNationsWizard() {
        OwenWarrior warrior = new OwenWarrior("Nation", "Tribe",100, new OwenWarriorStrategy(), new OwenWizardStrategy2());
        OwenWizard wizard = new OwenWizard("Nation2", "Tribe", 100, new OwenWizardStrategy(), new OwenWizardStrategy2());
        OwenHealer healer = new OwenHealer("Nation3","Tribe",100,new OwenHealerStrategy(), new OwenHealerStrategy2());


        assertEquals(0,wizard.encounterLifePoints(wizard,wizard));
        assertEquals(0,wizard.encounterLifePoints(wizard,warrior));


        warrior.modifyLifePoints(-5);
        assertEquals(1,wizard.encounterLifePoints(wizard,warrior));
        assertEquals(0,wizard.encounterLifePoints(wizard,wizard));

        wizard.modifyLifePoints(-10);
        assertEquals(1,wizard.encounterLifePoints(wizard,warrior));

    }

}