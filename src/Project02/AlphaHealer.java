package Project02;

/**
 * A healer class with two strategies. The first is a regular strategy where they heal people they are allied to.
 * If they drop to low enough health they go berserk and start healing the enemies for 2 times their current health.
 */
public class AlphaHealer extends People
{
    /**
     * The constructor for the class
     * @param nation what nation the person belongs to
     * @param tribe the tribe they belong to
     * @param lifePoints the ammount of lifepoints they have
     * @param healerStrat the strategy to be used
     */
    AlphaHealer(String nation, String tribe, int lifePoints, Strategy healerStrat)
    {
        super(nation, tribe, PeopleType.healer, lifePoints, healerStrat);
        myDescription = "\t A.Healer";
    }

    /**
     * Change the strategies accordingly and return the lifepoints from running encounterstrategy
     * @param me The person calling the method
     * @param otherPerson The opponent/other party
     * @return
     */
    public int encounterLifePoints(People me, People otherPerson)
    {
        if (me.getLifePoints()>30)
        {
            me.changeStrategy(new AlphaHealerStrat());
        }
        else
        {
            me.changeStrategy(new AlphaHealerStrat2());
        }

        int lp = encounterStrategy.strategy(me,otherPerson);
        if (lp > 0)
        {
            lp = 0;
        }
        return lp;
    }
}
