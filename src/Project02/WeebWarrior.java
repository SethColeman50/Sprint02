package Project02;

/**
 * The declaration of the people type WeebWarrior.
 */
public class WeebWarrior extends People
{
    /**The constructor. Gets passed a nation, tribe, number of lifepoints and strategy to be used and allocates them accordingly.
     * The description for the Weeb Warrior gets stored in myDescription.
     * The description is simply a somewhat funny reference to the MMORPG Final Fantasy XIV
     * @param nation , contains the nations it is initialized with
     * @param tribe , contains the tribe it is initialized with
     * @param lifepoints , the life points it is initialized with
     * @param WeebWarriorStart , the strat it is initialized with
     */
    WeebWarrior(String nation,String tribe, int lifepoints, Strategy WeebWarriorStart)
    {
        super(nation,tribe,PeopleType.warrior,lifepoints,WeebWarriorStart);
        myDescription= "\tOrlando Warrior"; //"First time tanking. Currently leveling my Warrior to 90. You pull, you tank.";
    }

    /**
     * Function called with two individuals which uses this individual's strategy to decide what happens when encountering
     * another person. Returns how many lifepoints are to get added or subtracted.
     * @param me ,the individual calling the method
     * @param OtherPerson ,the opponent
     * @return the life points commited
     */
    @Override
    public int encounterLifePoints(People me,People OtherPerson)
    {
        return encounterStrategy.strategy(me, OtherPerson);
    }

}
