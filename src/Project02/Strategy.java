package Project02;

public interface Strategy
{
    /**
     * Generic strategy for a game player
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return - number of life points to use in an encounter
     */
    public int strategy(People me, People otherPerson);
}
