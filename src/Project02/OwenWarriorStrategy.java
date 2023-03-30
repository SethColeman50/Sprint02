package Project02;

public class OwenWarriorStrategy implements  Strategy {
    //warriors are hyper aggressive and will attack anyone that is not part of their own tribe
    /**
     * Warrior strategy is hyper aggressive and returns maximum amount of life
     * points if players are from different nations. If from the same nation then
     * player will transfer life points.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return - Life points to use in the encounter
     */
    @Override
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            return 0;
        } else {
            return Math.min(otherPerson.getLifePoints(), me.getLifePoints());
        }
    }


}
