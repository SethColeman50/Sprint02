package Project02;

/**
 * Class which defines the Schaper warrior. It could be considered the most basic of warriors.
 * Stores the nation, tribe, the fact that they are a warrior, lifepoints and the strategy.
 */

public class SchaperWarrior extends People
{
    /**
     * The constructor for SchaperWarrior. Gets passed the nation, tribe, lifepoints and strategy.
     * It then stores a description in myDescription.
     * @param nation
     * @param tribe
     * @param lifePoints
     * @param warriorStrategy
     */
    SchaperWarrior(String nation, String tribe, int lifePoints, Strategy warriorStrategy) {
        super(nation, tribe, PeopleType.warrior, lifePoints, warriorStrategy);
        myDescription = "\tSchaper Warrior";
    }

    /**
     * Requires a person and another person to be passed. This function uses the encounter strategy of this
     * specific individual to decide what happens. Returns the number of lifepoints to be added or taken.
     * @param me - This specific individual, the one who starts the encounter.
     * @param otherPerson - The other part in the encounter.
     * @return
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        return encounterStrategy.strategy(me, otherPerson);
    }

}