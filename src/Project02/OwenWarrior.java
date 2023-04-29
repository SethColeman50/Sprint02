package Project02;

import Project02.People;
import Project02.PeopleType;
import Project02.Strategy;

public class OwenWarrior extends People {
    Strategy strat1;
    Strategy strat2;

    OwenWarrior(String nation, String tribe, int lifePoints, Strategy strat1, Strategy strat2) {
        super(nation, tribe, PeopleType.warrior, lifePoints, strat1);
        this.strat1 = strat1;
        this.strat2 = strat2;
        myDescription = "\tOwen Warrior";
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