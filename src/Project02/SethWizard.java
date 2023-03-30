package Project02;

public class SethWizard extends People {
    SethWizard(String nation, String tribe, int lifePoints, Strategy warriorStrategy) {
        super(nation, tribe, PeopleType.wizard, lifePoints, warriorStrategy);
        myDescription = "\tSeth Wizard";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        return encounterStrategy.strategy(me, otherPerson);
    }

}
