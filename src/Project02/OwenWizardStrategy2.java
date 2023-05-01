package Project02;

public class OwenWizardStrategy2 implements Strategy {
    //wizards will run away from all battles and heal warriors from their own tribe
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            return 0;
        } else {
            //try the other person's strategy and respond with the same value
            return otherPerson.encounterStrategy.strategy(otherPerson,me);
        }

    }
}
