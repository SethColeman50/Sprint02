package Project02;

public class SethHealerStrategy1 implements Strategy {
    /**
     * A less extreme healer strategy
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return life points
     */
    @Override
    public int strategy(People me, People otherPerson) {
        // If friendly heal a 10th of health if in tribe heal a fourth
        if (me.getNation().equals(otherPerson.getNation())) {
            if (me.getTribe().equals(otherPerson.getTribe())) {
                return me.getLifePoints() / 4;
            } else {
                return me.getLifePoints() / 10;
            }
        }
        // If enemy do nothing
        else {
            return 0;
        }
    }
}
