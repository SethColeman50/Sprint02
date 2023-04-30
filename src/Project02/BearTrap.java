package Project02;

public class BearTrap extends People {
    BearTrap(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "Bear trap";
    }

    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        int roll = (Die.getInstance().roll(4) - 1) / 2;
        if (roll == 0) {
            myDescription = "Small bear trap";
            otherPerson.modifyLifePoints(Math.min(0, 20 - otherPerson.getLifePoints()));
        } else {
            myDescription = "Large bear trap";
            otherPerson.modifyLifePoints(Math.min(0, 30 - otherPerson.getLifePoints()));
        }

        uses++;
        return 0;
    }
}
