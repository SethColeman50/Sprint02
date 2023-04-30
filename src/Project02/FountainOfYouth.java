package Project02;

public class FountainOfYouth extends People {

    FountainOfYouth(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "The Fountain of Youth";
    }

    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        otherPerson.modifyLifePoints((100-otherPerson.getLifePoints()));
        uses++;
        return 0;
    }
}
