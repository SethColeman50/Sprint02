package Project02;

/**
 * Warrior that uses SethWarrior Strategy
 */
public class SethWarrior extends People {
    SethWarrior(String nation, String tribe, int lifePoints, Strategy warriorStrategy) {
        super(nation, tribe, PeopleType.warrior, lifePoints, warriorStrategy);
        myDescription = "\tSeth Warrior";
    }
    @Override
    public int encounterLifePoints(People me, People otherPerson) {
        // If the other person is a wizard then attack them harder because they're generally more dangerous
        if (otherPerson.getType() == PeopleType.wizard || otherPerson.getType() == PeopleType.healer) {
            changeStrategy(new SethWizardStrategy());
        // If the other person is a warrior, try to do chip damage instead
        } else {
            changeStrategy(new SethWarriorStrat2());
        }

        return encounterStrategy.strategy(me, otherPerson);
    }

}
