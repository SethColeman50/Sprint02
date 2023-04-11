package Project02;

/**
 * Gives as much health to the warriors as possible unless they can
 */
public class SethWizardStrategy implements Strategy {
    @Override
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            if (me.getTribe().equals(otherPerson.getTribe())) {
                return 50;
            } else {
                if (otherPerson.encounterStrategy.getClass().toString().contains("Wizard")) {
                    return 0;
                } else {
                    return 25;
                }
            }
        } else {
            if (otherPerson.getLifePoints() <= 10) {
                return 10;
            } else {
                return 0;
            }
        }
    }
}
