package Project02;

public interface Strategy
{
    /**
     * Interface for strategies which get used by each person to dictate how encounters go.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return - number of life points to use in an encounter
     */
    int strategy(People me, People otherPerson);
}
