package Project02;

public class OwenWizardStrategy implements Strategy {
    //wizards will run away from all battles and heal warriors from their own tribe
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            //if the other person is a wizard share life points
            if (otherPerson.getType() == PeopleType.wizard) {
                if (otherPerson.getLifePoints() > me.getLifePoints()) {
                    return -(100 - otherPerson.getLifePoints());
                } else {
                    return -(100 - me.getLifePoints());
                }
            }
            return 0;
        } else {
            //if the other person is a warrior, do some damage
            if (otherPerson.getType() == PeopleType.warrior) {
                return (int)((100 - otherPerson.getLifePoints())/5.0);
            }
            //if the other person is a wizard or healer, attack
            if (otherPerson.getType() == PeopleType.wizard || otherPerson.getType() == PeopleType.healer)  {
                return (me.getLifePoints() / 2);
            }
            return 0;
        }

    }
}
