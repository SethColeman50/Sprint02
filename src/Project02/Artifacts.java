package Project02;

import java.util.ArrayList;

public class Artifacts extends AbstractTribe
{
    public Artifacts()
    {
        nationName = "Artifact";
        tribeName = "Artifact";
        tribeLifePoints = 1000;

//        members.add();
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
