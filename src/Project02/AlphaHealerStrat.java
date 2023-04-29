package Project02;

/**
 * A healer which focuses on their tribe and heals nobody else.
 */

public class AlphaHealerStrat implements Strategy
{
    /**
     * They heal people of their own tribe. When high on health they heal a lot but lose more health each heal.
     * If they are below 80 health and run into a wizard they refund from healing as they pool their magic together.
     * If neither apply they do a standard heal. If they encounter an enemy they run away and do nothing if the other
     * is from a different type.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return
     */
    public int strategy(People me, People otherPerson)
    {
        int lifepoints = 0;
        if (otherPerson.getNation().equals(me.getNation()))
        {
            if(me.getTribe().equals(otherPerson.getTribe()))
            {
                if (me.getLifePoints() > 80)
                {
                    lifepoints = -(me.getLifePoints() * 2);
                    me.modifyLifePoints(-((lifepoints / 2)%2+7)); //Lose health after healing.
                    return lifepoints;
                }
                else if (otherPerson.getType().equals(PeopleType.wizard))
                {
                    lifepoints = (-((me.getLifePoints() % 2 + 5) * (otherPerson.getLifePoints() % 2 +5)));
                    me.modifyLifePoints((-1*lifepoints)); //Refund the health
                    return lifepoints;
                }
                else
                {
                    lifepoints = -(me.getLifePoints()/2);
                }
            }
        }
        else
        {
            lifepoints = -((me.getLifePoints()/2)%2); //If encountering an enemy, run away.
        }
        return lifepoints;
    }
}
