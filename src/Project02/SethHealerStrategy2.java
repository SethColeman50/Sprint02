package Project02;

public class SethHealerStrategy2 implements Strategy {

    @Override
    public int strategy(People me, People otherPerson) {
        // If friendly and in tribe heal as much as you can without dying
        if (me.getNation().equals(otherPerson.getNation())) {
            if (me.getTribe().equals(otherPerson.getTribe())) {
                return me.getLifePoints() - 1;
            }
            // Save a bit of healing potential
            else {
                return me.getLifePoints() - 10;
            }
        }
        // If enemy try and do a bit of damage
        else {
            return 5;
        }
    }
}
