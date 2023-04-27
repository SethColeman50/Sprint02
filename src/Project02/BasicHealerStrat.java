package Project02;

import java.util.Objects;

/**
 * The healer encounter strategy where it only ever heals allies
 */
public class BasicHealerStrat implements Strategy
{
    /**
     * Checks for the person to be from the same nation, if they are from the same tribe, do a big heal.
     * If they are from a different nation, they perform a smaller heal.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return
     */
    @Override
    public int strategy(People me, People otherPerson)
    {
        int lifePoints = 0;
        if (me.getNation().equals(otherPerson.getNation()))
        {
            if (me.getTribe().equals(otherPerson.getTribe()))
            {
                lifePoints = -(otherPerson.getLifePoints()) * 2;
            }
            else
            {
                lifePoints= -(otherPerson.getLifePoints()/2);
            }
        }

        return lifePoints;
    }
}
