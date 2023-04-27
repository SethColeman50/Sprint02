package Project02;

/**
 * Weeb Warrior, the ultimate warrior which doesn't get healed(outside of 1 consolation lifepoint),
 * but heals others for a large amount.
 * It then also deals a large amount of damage.
 */
public class WeebWarriorStrat implements Strategy
{
    /**
     * Implementation of the above description. It's about as complex as it sounds.
     * Which isn't much. Heal others for double the difference of your life points only when lower than you, but
     * don't get healed outside of a singular lifepoint.
     * Attack hard when near full health. Otherwise, you attack normally.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return the life points to be commited
     */
    public int strategy(People me, People otherPerson)
    {
        int lifePoints;
        if(me.getNation().equals(otherPerson.getNation()))
        {
            if(otherPerson.getLifePoints() <= me.getLifePoints()) //Only heal friends lower than self.
            {
                    lifePoints = (-((me.getLifePoints() - otherPerson.getLifePoints()))*2);

            }
            else //Get a consolation 1 lifepoint for talking to your friend.
            {
                lifePoints=1;
            }
        }
        else
        {
            int points;
            points = me.getLifePoints();
            if (points < 80)
            {
                lifePoints = me.getLifePoints()/10; //Deal less damage because you are weaker at the moment.
            }
            else
            {
                lifePoints = (me.getLifePoints()*2)/2;
            }
        }
        return lifePoints;
    }
}
