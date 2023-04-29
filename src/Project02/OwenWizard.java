package Project02;


public class OwenWizard extends People {
    Strategy strat1;
    Strategy strat2;
    OwenWizard(String nation, String tribe, int lifePoints, Strategy strat1, Strategy strat2) {
        super(nation, tribe, PeopleType.wizard, lifePoints, strat1);
        this.strat1 = strat1;
        this.strat2 = strat2;
        myDescription = "\tOwen Wizard";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        //if above 75 health use encounterStrategy 1;
        if (getLifePoints() > 75)
            encounterStrategy = this.strat1;
        else
            encounterStrategy = this.strat2;
        return encounterStrategy.strategy(me, otherPerson);
    }

}