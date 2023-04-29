package Project02;
import java.util.Collection;
import java.util.Collections;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import Project02.People;
import Project02.PeopleType;
import Project02.SchaperWarrior;
import Project02.SchaperWizard;

/**
 * The class for tribes, which are made by nations and make people.
 */
public class Tribe extends AbstractTribe
{
    /**
     * The constructor for Tribe. Get passed the nation name and tribe name through a string as well as how many lifepoints
     * it will have available to it.
     * @param nation
     * @param tribe
     * @param lifePoints
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;
        for(int i = 0; i < 6; i++)
            if(i % 3 == 0) {
                if (nation.equals("Schapers")) {
                    members.add(new SchaperWarrior(nationName, tribeName, tribeLifePoints / 6, new WarriorStrategy()));
                } else if (nation.equals("Seths")) {
                    members.add(new SethWarrior(nationName, tribeName, tribeLifePoints / 6, new SethWarriorStrategy()));
                } else if (nation.equals("Owens")) {
                    members.add(new OwenWarrior(nationName, tribeName, tribeLifePoints / 6, new OwenWarriorStrategy()));
                } else if (nation.equals("Orlandos")) {
                    members.add(new WeebWarrior(nationName,tribeName,tribeLifePoints/ 6, new WeebWarriorStrat()));
                }
            } else if (i % 3 == 1) { //idk if evens?
                if (nation.equals("Schapers")) {
                    members.add(new SchaperWizard(nationName, tribeName, tribeLifePoints / 6, new WizardStrategy()));
                } else if (nation.equals("Seths")) {
                    members.add(new SethWizard(nationName, tribeName, tribeLifePoints / 6, new SethWizardStrategy()));
                } else if (nation.equals("Owens")) {
                    members.add(new OwenWizard(nationName, tribeName, tribeLifePoints / 6, new OwenWizardStrategy()));
                } else if (nation.equals("Orlandos")) {
                    members.add(new WeebWizard(nationName, tribeName, tribeLifePoints / 6, new WeebWizardStrat()));
                }
            } else {
                if (nation.equals("Schapers")){
                    members.add(new BasicHealer(nationName, tribeName, tribeLifePoints / 6, new BasicHealerStrat()));
                }
                else if (nation.equals("Seths")){
                    members.add(new BasicHealer(nationName, tribeName, tribeLifePoints / 6, new BasicHealerStrat()));
                }
                else if (nation.equals("Owens")){
                    members.add(new BasicHealer(nationName, tribeName, tribeLifePoints / 6, new BasicHealerStrat()));
                }
                else if (nation.equals("Orlandos")){
                    members.add(new BasicHealer(nationName, tribeName, tribeLifePoints / 6, new AlphaHealerStrat()));
                }
            }
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);

    }


}
