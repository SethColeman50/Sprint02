package Project02;

public class WizardStrategy implements Strategy{
    /**
     * This strategy will run from a warrior from another nation
     * and will attack a wizard from another nation. Will transfer
     * life points to a player from the same nation.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return - Life points used in the encounter
     */
    public int strategy(People me, People otherPerson) {
        int lifePoints = 0;
        if (!me.getNation().equals(otherPerson.getNation()))
        {
            if (otherPerson.getLifePoints() < me.getLifePoints())
            {
                if (otherPerson.getType() == PeopleType.warrior) // run away
                {
                    lifePoints = -me.getLifePoints();
                }
                else // attack a wizard
                {
                    lifePoints = me.getLifePoints()/2;
                }
            }
        }
        else
        {
            if (otherPerson.getLifePoints() < me.getLifePoints()) // heal a friend
            {
                lifePoints = me.getLifePoints() - otherPerson.getLifePoints() / 2;
            }
        }
        return lifePoints;
    }
}
