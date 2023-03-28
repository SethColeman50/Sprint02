package Project02;

/**
 * The declaration of the people type WeebWarrior.
 */
public class WeebWarrior extends People
{
    /**
     * The description for the Weeb Warrior. A somewhat funny reference to the MMORPG Final Fantasy XIV
     * @param nation
     * @param tribe
     * @param lifepoints
     * @param WeebWarriorStart
     */
    WeebWarrior(String nation,String tribe, int lifepoints, Strategy WeebWarriorStart)
    {
        super(nation,tribe,PeopleType.warrior,lifepoints,WeebWarriorStart);
        myDescription= "First time tanking. Currently leveling my Warrior to 90. You pull, you tank.";
    }

    /**
     * Sends back the strategy
     * @param me
     * @param OtherPerson
     * @return
     */
    @Override
    public int encounterLifePoints(People me,People OtherPerson)
    {
        return encounterStrategy.strategy(me, OtherPerson);
    }

}
