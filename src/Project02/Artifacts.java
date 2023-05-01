package Project02;

import java.util.ArrayList;

public class Artifacts extends AbstractTribe
{
    public Artifacts(String nationName, String tribeName)
    {
        this.nationName = nationName;
        this.tribeName = tribeName;
        tribeLifePoints = 600;

        members.add(new FountainOfYouth(nationName,tribeName,tribeLifePoints/6));
        members.add(new MysteriousWizard(nationName,tribeName,tribeLifePoints/6));
        members.add(new BottomlessPit(nationName,tribeName,tribeLifePoints/6));
        members.add(new BearTrap(nationName, tribeName, tribeLifePoints / 6));
        members.add(new TreasureChest(nationName, tribeName, tribeLifePoints / 6));
    }

    @Override
    public ArrayList<People> getLivingTribeMembers() {
        livingMembers.clear();

        for (People person:
             members) {
            if (person.uses < 2) {
                livingMembers.add(person);
            }
        }
        return livingMembers;
    }
}
