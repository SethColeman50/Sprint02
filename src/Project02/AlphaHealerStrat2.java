package Project02;

/**
 * The second strategy for healer where they go berserk and start healing the enemy. Only triggered when dangerously low.
 */
public class AlphaHealerStrat2 implements Strategy
{
    /**
     * The strategy checks if they are from an opposing nation and heals them.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return
     */
    public int strategy(People me, People otherPerson)
    {
        int lifepoints = 0;
        if (otherPerson.getNation() != me.getNation())
        {
            lifepoints = -(me.getLifePoints()*2);
        }
        return lifepoints;
    }
}
