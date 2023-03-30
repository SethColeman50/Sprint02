package Project02;

public class OwenWizardStrategy implements Strategy {
    //wizards will run away from all battles and heal warriors from their own tribe
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            //if the other person is a wizard nothing happens
            if (otherPerson.getType() == PeopleType.wizard) {
                return 0;
            }
            //take however many hp is required to get back to 100, or if the otherPerson has less than that, all their hp but one
            if (otherPerson.getLifePoints() >= 100 - me.getLifePoints()) {
                return (100 - otherPerson.getLifePoints());
            } else {
                return (100 - me.getLifePoints());
            }
        } else {
            //if the other person is a warrior, run away
            if (otherPerson.getType() == PeopleType.warrior) {
                return 0;
            }
            //if the other person is a wizard, attack
            if (otherPerson.getType() == PeopleType.wizard) {
                return (me.getLifePoints() / 2);
            }
        }
        return 0;
    }
}
