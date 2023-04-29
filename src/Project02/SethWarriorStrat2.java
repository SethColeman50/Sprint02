package Project02;

public class SethWarriorStrat2 implements Strategy {
    /**
     * Have warrior attack as hard as he can and take as much as he can from wizards
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return an int that represents the number of life points given to the encounter
     */
    @Override
    public int strategy(People me, People otherPerson) {
        int maxLifePoints = 100;
        // if other person is friendly give 0 health (Saving Health for attacks)
        if (me.getNation().equals(otherPerson.getNation())) {
            // if other person is in tribe, give 5% because your tribe winning is good
            if (me.getTribe().equals(otherPerson.getTribe())) {

                return me.getLifePoints() / 20;
            }

            return 0;
        }

        // if other person is Enemy
        // if the other person is at 1/6 health or lower give enough to kill them 50% of the time
        // Otherwise do 5% health as chip damage
        else {
            if (otherPerson.getLifePoints() <= maxLifePoints / 6) {
                return otherPerson.getLifePoints();
            }

            return maxLifePoints / 20;
        }
    }
}
