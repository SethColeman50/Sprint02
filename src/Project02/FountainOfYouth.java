package Project02;

public class FountainOfYouth extends People{

    FountainOfYouth(String nation, String tribe, int lifePoints, Strategy Wiza)
    {
        super(nation, tribe, PeopleType.artifact, lifePoints, Wiza);
        myDescription = "The Fountain of Youth";
    }

    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        otherPerson.modifyLifePoints((100-otherPerson.getLifePoints()));
        uses++;
        return 0;
    }
}
