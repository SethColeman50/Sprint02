package Project02;

public class FountainOfYouth extends People {


    /**
     * the fountain of youth, heals someone to full when they find it
     * @param nation the nation this artifact belongs to
     * @param tribe the tribe this artifact belongs to
     * @param lifePoints number of life points this artifact has
     */
    FountainOfYouth(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "Fountain of Youth";
    }

    /**
     * heals to full whoever finds the fountain of youth
     * @param me, the fountain of youth
     * @param otherPerson the person who found it
     * @return life points, always zero because it doesn't attack
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        if (otherPerson.getType() != PeopleType.artifact)
            otherPerson.modifyLifePoints((100-otherPerson.getLifePoints()));
        uses++;
        return encounterStrategy.strategy(me,otherPerson);
    }
}
