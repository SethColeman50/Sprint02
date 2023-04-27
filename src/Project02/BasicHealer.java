package Project02;

/**
 * The class implements a healer type which can be used for a class
 */
public class BasicHealer extends People
{
    /**
     *The healer constructor which assigns the passed parameters appropriately
     * @param nation the healer's nation
     * @param tribe the healer's tribe
     * @param lifePoints the lifepoints it is initialized with
     * @param healerStrat the strategy it is using
     */
    BasicHealer(String nation, String tribe, int lifePoints, Strategy healerStrat)
    {
        super(nation, tribe, PeopleType.healer, lifePoints, healerStrat);
        myDescription = "\tHealer";
    }

    /**
     *The method for encountering others
     * @param me the individual calling the method
     * @param otherPerson the other person in the encounter
     * @return
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson)
    {
        int lp = encounterStrategy.strategy(me,otherPerson);
        if (lp > 0)
        {
            lp = 0;
        }
        return lp;
    }
}
