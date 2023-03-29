package Project02;

/**
 * Implementation of the WeebWizard class. A wizard so obsessed with Japanese media that they try to copy it.
 * It has the potential to deal a lot of damage, but dies very easily due to how many chances
 * there are for it to take a lot of damage too if not outright die.
 */
public class WeebWizardStrat implements Strategy
{
    /**
     * The main implementation of the strategy. When encountering an opponent, it can deal massive damage other Wizards
     * as casting such a strong spell takes a lot of time, so Warriors interrupt the cast by attacking them.
     * But casting the spell, which deals damage equal to total health at that moment, kills them off.
     *
     * When meeting someone from the same nation, they beat up warriors after getting mad at them, get cocky and die
     * when below 50 and can cast a heal when above 50 for their current amount.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return
     */
    public int strategy(People me, People otherPerson)
    {
        int lifePoints = 0;
        if (me.getNation() != otherPerson.getNation())
        {
            if (otherPerson.getLifePoints() < me.getLifePoints())
            {
                if (otherPerson.getType() == PeopleType.warrior) //Get your cast interrupted, take damage equal to half of current life points.
                {
                    //System.out.println("Wait bro, my cast isn't done yet--");
                    lifePoints = -((me.getLifePoints()*2)/2);
                }
                else
                {
                    //System.out.println("EXUPLOSIOOON!!");
                    lifePoints = (me.getLifePoints()); //Deals damage equal to wizard life points, but die.
                    me.setDead();
                }
            }
        }
        else
        {
            if (otherPerson.getType() != PeopleType.warrior && me.getLifePoints()>50) //Beat up a friend
            {
                //System.out.println("Idiot, don't move me out of my Leyline.");
                lifePoints = -((me.getLifePoints() - otherPerson.getLifePoints())+2)/2;
            }
            else if (otherPerson.getType() == PeopleType.wizard && me.getLifePoints()<50) //Get cocky and die to a stray attack when sassing the other Wizards
            {
                //System.out.println("You need to adjust--");
                me.setDead();
            }
            else
            {
                //System.out.println("Fine, I'll cast a heal.");
                lifePoints = (me.getLifePoints());
            }

            }

        return lifePoints;
    }
}
