package Project02;

/**
 * Declaration of people type Weeb Wizard.
 */
public class WeebWizard extends People
{
    /**
     * The constructor, gets passed the nation, number of lifepoints and strategy to be used.
     * Allocates them appropriately.
     * The description gets saved to myDescription.
     * The description is simply a rather cute reference to a character from a relatively well-known comedy
     * TV series from Japan, with the joke is that the name can't be said because of copyright.
     * @param nation , contains the nation it is initialized with
     * @param tribe , contains the tribe it is initialized with
     * @param lifePoints , contains the lifepoints it is initialized with
     * @param WeebWizardStrat , contains the strategy it is initialized with
     */
    WeebWizard(String nation, String tribe, int lifePoints, Strategy WeebWizardStrat)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints, WeebWizardStrat);
        myDescription = "\tOrlando Wizard"; //"The Wizard of darkness, child of Chaos, chosen of the chosen, my name is--[Redacted]";

    }

    /**
     * Returns the WeebWizard strategy. Change strategies to the 2nd when facing a healer. Face all other enemies
     * on strategy 1.
     * @param me , the individual calling the method
     * @param otherPerson , the opponent
     * @return an int of life points
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson)
    {
        if (otherPerson.getType().equals(PeopleType.healer))
        {
            me.changeStrategy(new WeebWizardStrat2());
        }
        else
        {
            me.changeStrategy(new WeebWizardStrat());
        }
        return encounterStrategy.strategy(me, otherPerson);
    }

}
