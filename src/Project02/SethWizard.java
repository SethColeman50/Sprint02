package Project02;

/**
 * Wizard that uses the SethWizard Strategy
 */
public class SethWizard extends People {
    SethWizard(String nation, String tribe, int lifePoints, Strategy warriorStrategy) {
        super(nation, tribe, PeopleType.wizard, lifePoints, warriorStrategy);
        myDescription = "\tSeth Wizard";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        // If you are above half health attack super hard
        if (me.getLifePoints() >= 50) {
            changeStrategy(new SethWizardStrat2());
        }
        // If you are below half health heal your teammates
        else {
            changeStrategy(new SethWizardStrat2());
        }

        return encounterStrategy.strategy(me, otherPerson);
    }

}
