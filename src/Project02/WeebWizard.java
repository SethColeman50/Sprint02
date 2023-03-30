package Project02;

/**
 * Declaration of people type Weeb Wizard.
 */
public class WeebWizard extends People
{
    /**
     * The constructor, gets passed the nation, number of lifepoints and strategy to be used.
     * Allocates them appropriately.
     *
     *
     * The description gets saved to myDescription.
     * The description is simply a rather cute reference to a character from a relatively well-known comedy
     * TV series from Japan, with the joke is that the name can't be said because of copyright.
     * @param nation
     * @param tribe
     * @param lifePoints
     * @param WeebWizardStrat
     */
    WeebWizard(String nation, String tribe, int lifePoints, Strategy WeebWizardStrat)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints, WeebWizardStrat);
        myDescription = "Hello desu-da"; //"The Wizard of darkness, child of Chaos, chosen of the chosen, my name is--[Redacted]";

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
