package Project02;

public class SethWizardStrat2 implements Strategy {
    /**
     * A wizard strategy that attacks really hard
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return life points
     */
    @Override
    public int strategy(People me, People otherPerson) {
        // Heals people a lot less than the original strategy
        if (me.getNation().equals(otherPerson.getNation())) {
            if (me.getTribe().equals(otherPerson.getTribe())) {
                return me.getLifePoints() / 5;
            } else {
                return me.getLifePoints() / 10;
            }
        }
        // Attacks with one fourth of their health or more if the enemy is low
        else {
            if (otherPerson.getLifePoints() <= 50) {
                return me.getLifePoints() / 2;
            } else {
                return me.getLifePoints() / 4;
            }
        }
    }
}

