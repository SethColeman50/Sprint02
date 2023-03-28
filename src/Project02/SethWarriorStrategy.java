package Project02;

public class SethWarriorStrategy implements Strategy {
    /**
     * Have warrior attack as hard as he can and take as much as he can from wizards
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return an int that represents the number of life points given to the encounter
     */
    @Override
    public int strategy(People me, People otherPerson) {
        int maxLifePoints = 100;
        // if other person is friendly
            // Give 5% of health (Saving Health for attacks)
        if (me.getNation().equals(otherPerson.getNation())) {
            if (me.getTribe().equals(otherPerson.getTribe())) {
                // if other person is in tribe, give 10% because you like them more :)
                return me.getLifePoints() / 10;
            }

            return me.getLifePoints() / 20;
        }

        // if other person is Enemy
            // if the other person is at 1/4 health or lower give enough to kill
            // them 50% of the time
            // Otherwise don't attack
        else {
            if (otherPerson.getLifePoints() <= maxLifePoints / 4) {
                return otherPerson.getLifePoints();
            }
            return 0;
        }
    }
}
