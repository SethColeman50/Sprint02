package Project02;

public class OwenWizardStrategy implements Strategy {
    //wizards will run away from all battles and heal warriors from their own tribe
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            //if the other person is a wizard nothing happens
            if (otherPerson.getType() == PeopleType.wizard) {
                return 0;
            }
            if (otherPerson.getLifePoints() > me.getLifePoints()) {
                return -(100 - otherPerson.getLifePoints());
            } else {
                return -(100 - me.getLifePoints());
            }
        } else {
            //if the other person is a warrior, run away, do no damage
            if (otherPerson.getType() == PeopleType.warrior) {
                return 0;
            }
            //if the other person is a wizard, attack
            if (otherPerson.getType() == PeopleType.wizard) {
                return (me.getLifePoints() / 2);
            }
            return 0;
        }

    }
}
