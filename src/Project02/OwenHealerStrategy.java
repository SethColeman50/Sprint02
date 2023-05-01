package Project02;

public class OwenHealerStrategy implements  Strategy{
    @Override
    public int strategy(People me, People otherPerson) {
        if (me.getNation().equals(otherPerson.getNation())) {
            return -(100 - Math.max(otherPerson.getLifePoints(), me.getLifePoints()));
        } else {
            return 0;
        }
    }
}
