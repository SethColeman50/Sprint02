package Project02;

import Project02.People;
import Project02.PeopleType;

/**
 * The class for the SchaperWizard. It could be called simply a Wizard.
 */

public class SchaperWizard extends People
{
    /**
     * The constructor. Gets passed the nation, tribe, life points and strategy of the individual.
     * The constructor then saves a basic description to myDescription.
     * @param nation
     * @param tribe
     * @param lifePoints
     * @param strategy
     */
    SchaperWizard(String nation, String tribe, int lifePoints, Strategy strategy)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints, strategy);
        myDescription = "\tSchaper Wizard";

    }

    /**
     * The function, taking two individuals being passed, which uses this specific individual's strategy to
     * decide what happens and returns how many lifepoints are added or taken.
     * @param me - This specific individual, the one who starts the encounter
     * @param otherPerson - The other party.
     * @return
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson)
    {
        return encounterStrategy.strategy(me, otherPerson);
    }

}
