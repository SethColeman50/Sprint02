package Project02;

public class BottomlessPit extends People{


    /**
     * Bottomless pit that will kill a person who falls into it.
     * @param nation the nation this artifact belongs to
     * @param tribe the tribe this artifact belongs to
     * @param lifePoints number of life points this artifact has
     */
    BottomlessPit(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.artifact, lifePoints, new NothingStrategy());
        myDescription = "Bottomless Pit";
    }

    /**
     * kills whoever falls into the bottomless pit
     * @param me, the bottomless pit
     * @param otherPerson the person who fell in
     * @return life points, always zero because it doesn't attack
     */
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        if (otherPerson.getType() != PeopleType.artifact)
            otherPerson.setDead();
        uses++;
        return 0;
    }
}
