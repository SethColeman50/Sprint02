package Project02;

/**
 * Gives as much health to the warriors as possible unless they can
 */
public class SethWizardStrategy implements Strategy {
    /**
     * A wizard based on healing
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return the number of life points to use in encounter
     */
    @Override
    public int strategy(People me, People otherPerson) {
        // if friendly and not wizard heal your teammate either half of your health or a quarter of your health
        if (me.getNation().equals(otherPerson.getNation())) {
            if (me.getTribe().equals(otherPerson.getTribe())) {
                return me.getLifePoints() / 2;
            } else {
                if (otherPerson.getType().equals(PeopleType.wizard)) {
                    return 0;
                } else {
                    return me.getLifePoints() / 4;
                }
            }
        }
        // Try to kill the other person if very low, otherwise do nothing.
        else {
            if (otherPerson.getLifePoints() <= 10) {
                return 10;
            } else {
                return 0;
            }
        }
    }
}
