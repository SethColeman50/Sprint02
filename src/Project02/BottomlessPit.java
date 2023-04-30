package Project02;

public class BottomlessPit extends People{


    BottomlessPit(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "The Fountain of Youth";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        otherPerson.setDead();
        uses++;
        return encounterStrategy.strategy(me,otherPerson);
    }
}
