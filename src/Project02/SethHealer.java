package Project02;

/**
 * A healer that
 */
public class SethHealer extends People {
    SethHealer(String nation, String tribe, int lifePoints, Strategy strategy) {
        super(nation, tribe, PeopleType.warrior, lifePoints, strategy);
        myDescription = "\tOwen Healer";
    }

    @Override
    public int encounterLifePoints(People me, People otherPerson) {
//        if (me.getLifePoints() >= 50) {
//            changeStrategy(new SethHealerStrategy1());
//        }

        return encounterStrategy.strategy(me, otherPerson);
    }
}
