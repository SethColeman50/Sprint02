package Project02;

public class OwenHealerStrategy2 implements  Strategy{
    @Override
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            if (otherPerson.getType() == PeopleType.warrior) {
                return -(100 - Math.max(otherPerson.getLifePoints(), me.getLifePoints()));
            } else if (otherPerson.getType() == PeopleType.healer) {
                //healers don't heal other healers
                return 0;
            } else {
                //heal wizards less than warriors because warriors do more damage
                return -(100 - Math.max(otherPerson.getLifePoints(), me.getLifePoints()) / 5);
            }

        } else {
            return 0;
        }
    }
}
