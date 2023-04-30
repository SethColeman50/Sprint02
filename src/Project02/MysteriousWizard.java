package Project02;

/**
 * A mysterious wizard which, when encountered, changes the person encountering them entirely.
 */
public class MysteriousWizard extends People
{
    /**
     * The constructor.
     * @param nation Belongs to no nation
     * @param tribe Part of the ancients talked of in legend, a group of artifacts
     * @param lifePoints the lifepoints... Said to be immortal
     * @param Wiza a wizard strategy as they are a wizard at heart
     */
    MysteriousWizard(String nation, String tribe, int lifePoints, Strategy Wiza)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints, Wiza);
        myDescription = "A Mysterious Lady";
    }


    /**
     * When encountered, change the person's strategy arbitrarily to one they should not normally have. But this also means
     * their type stays the same which can lead to bad situations depending on the opponents they run into after
     * @param merlin the wizard, ye olde one
     * @param otherPerson the person encountering them
     * @return
     */
    public int encounterLifePoints(People merlin, People otherPerson)
    {
        switch (otherPerson.getType())
        {
            case wizard:
                otherPerson.changeStrategy(new BasicHealerStrat());
                break;
            case warrior:
                otherPerson.changeStrategy(new WizardStrategy());
                break;
            case healer:
                otherPerson.changeStrategy(new WarriorStrategy());
                break;
        }
        uses++;
        return 0;
    }

}
