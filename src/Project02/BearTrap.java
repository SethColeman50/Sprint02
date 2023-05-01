package Project02;

/**
 * Bear trap artifact that will hurt the player who steps on it
 */
public class BearTrap extends People {
    BearTrap(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "Bear trap";
    }

    /**
     * 50% chance to be a small or big trap, does a lot of damage
     * @param me, the bear trap
     * @param otherPerson the person who stepped in
     * @return life points, always zero because it doesn't attack
     */
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
