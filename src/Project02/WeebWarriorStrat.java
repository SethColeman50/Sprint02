package Project02;

/**
 * Weeb Warrior, the ultimate warrior which doesn't get healed(outside of 1 consolation lifepoint,
 * but heals others for a large amount.
 * It then also deals a large amount of damage.
 */
public class WeebWarriorStrat implements Strategy
{
    /**
     * Implementation of the above description. It's about as complex as it sounds. Which isn't much. Heal others, don't get healed.
     *
     * Attack hard when near full health. Otherwise, you attack normally.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return
     */
    public int strategy(People me, People otherPerson)
    {
        int lifePoints = 0;
        if(me.getNation() == otherPerson.getNation())
        {
            if(otherPerson.getLifePoints() <= me.getLifePoints()) //Only heal friends lower than self.
            {
                    //System.out.println("High-octane mitosis!!");
                    lifePoints = ((me.getLifePoints() - otherPerson.getLifePoints()))*2;

            }
            else //Get a consolation 1 lifepoint for talking to your friend.
            {
                //System.out.println("Me no heal. Healers are the green DPS.");
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
                //System.out.println("L+Ratio+Skill Issue+Inner Release+Bloodwhetting+Fell Cleave."); //Do a lot of damage.
                lifePoints = me.getLifePoints()*2;
            }
        }
        return lifePoints;
    }
}
