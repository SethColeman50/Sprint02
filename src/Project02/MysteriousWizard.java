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
     * When encountered, change the person's type arbitrarily and give them a new strategy to match
     * @param merlin the wizard, ye olde one
     * @param otherPerson the person encountering them
     * @return
     */
    public int encounterLifePoints(People merlin, People otherPerson)
    {
        switch (otherPerson.getType())
        {
            case wizard:
                otherPerson.beReborn("healer",new BasicHealerStrat());
                break;
            case warrior:
                otherPerson.beReborn("wizard",new WizardStrategy());
                break;
            case healer:
                otherPerson.beReborn("warrior",new WarriorStrategy());
                break;
        }
        uses++;
        return 0;
    }

}
