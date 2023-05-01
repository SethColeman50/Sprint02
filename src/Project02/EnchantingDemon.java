package Project02;

/**
 * A dangerous yet beautiful demon. Devastating to encounter.
 */
public class EnchantingDemon extends People
{
    /**
     * The constructor
     * @param nation belongs to no nation
     * @param tribe a part of a special tribe
     * @param lifePoints a life scale expanding that of a human
     */
    EnchantingDemon(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "An enchanting demon..!";
    }

    /**
     * It's supposed to do crippling amounts of damage. So a number that wasn't 100 was picked, but that was still
     * very high
     * @param demon the succubus calling the method
     * @param otherPerson the poor soul
     * @return so the function works
     */
    public int encounterLifePoints(People demon, People otherPerson)
    {
        otherPerson.modifyLifePoints(-69);
        uses++;
        return 0;
    }
}
