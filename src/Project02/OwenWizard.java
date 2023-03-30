package Project02;


public class OwenWizard extends People {
    OwenWizard(String nation, String tribe, int lifePoints, Strategy warriorStrategy) {
        super(nation, tribe, PeopleType.wizard, lifePoints, warriorStrategy);
        myDescription = "\tOwen Wizard";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        return encounterStrategy.strategy(me, otherPerson);
    }

}