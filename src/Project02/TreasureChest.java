package Project02;

/**
 * A treasure chest that can either hurt or help the player
 */
public class TreasureChest extends People {
    TreasureChest(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "Treasure Chest";
    }

    /**
     * Rolls a D20 and then heals or hurts the player
     * @param me, the treasure chest, not used
     * @param otherPerson, the person who opened the treasure chest
     * @return life points, always 0 because it doesn't attack.
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        int roll = Die.getInstance().roll(20);

        if (roll < 10) {
            myDescription = "Mimic";
            otherPerson.modifyLifePoints(10 - roll);
        } else {
            myDescription = "Treasure Chest";
            otherPerson.modifyLifePoints(roll - 10);
        }

        uses++;
        return 0;
    }
}
