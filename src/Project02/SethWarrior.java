package Project02;

/**
 * Warrior that uses SethWarrior Strategy
 */
public class SethWarrior extends People {
    SethWarrior(String nation, String tribe, int lifePoints, Strategy warriorStrategy) {
        super(nation, tribe, PeopleType.warrior, lifePoints, warriorStrategy);
        myDescription = "\tSeth Warrior";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        return encounterStrategy.strategy(me, otherPerson);
    }

}
