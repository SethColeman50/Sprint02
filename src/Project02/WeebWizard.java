package Project02;

/**
 * Declaration of people type Weeb Wizard.
 */
public class WeebWizard extends People
{
    /**
     * A rather cute description referencing a character from a relatively well-known comedy TV series from Japan.
     * @param nation
     * @param tribe
     * @param lifePoints
     * @param WeebWizardStrat
     */
    WeebWizard(String nation, String tribe, int lifePoints, Strategy WeebWizardStrat)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints, WeebWizardStrat);
        myDescription = "The Wizard of darkness, child of Chaos, chosen of the chosen, my name is--[Redacted]";

    }

    /**
     * Returns the WeebWizard strategy.
     * @param me
     * @param otherPerson
     * @return
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson)
    {
        return encounterStrategy.strategy(me, otherPerson);
    }

}
