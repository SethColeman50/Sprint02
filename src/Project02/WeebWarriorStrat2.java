package Project02;

/**
 * The second strategy for the weeb warrior which is only triggered when they encounter another warrior type enemy.
 * They engage in a heated grudge match as fellow warriors. On the rare off chance that they are equal in life points
 * it results in a KO but also puts the warrior which initiated it to 1hp. Otherwise the warrior attacks recklessly
 * resulting in health being lost each turn.
 */

public class WeebWarriorStrat2 implements Strategy
{
    /**
     * If the warriors are equal in LifePoints, it is a decisive battle. Otherwise, it can end up doing a lot or little.
     * Returns the lifepoints as an int in a variable.
     * @param me - person to get life points for.
     * @param otherperson - the opponent of the encounter
     * @return
     */
    public int strategy(People me,People otherperson)
    {
        int lifepoints = 0;
        if (otherperson.getLifePoints() == me.getLifePoints())
        {
            lifepoints = (me.getLifePoints()+20); //Tense grudge match between two warriors. Do lots of damage if you are of equal health.
            me.modifyLifePoints(-(me.getLifePoints()-1)); //'Mutual kill' deal where you get left so close to death that you likely die.
        }
        else
        {
            lifepoints = (me.getLifePoints()/2); //If the lifepoints aren't equal, it is a less tense grduge match where your HP is cut every attack.
            me.modifyLifePoints(-((me.getLifePoints()%2))-10);
        }

        return lifepoints;
    }
}
