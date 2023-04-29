package Project02;
import java.util.ArrayList;
import Project02.People;
import Project02.SchaperWarrior;
import Project02.SchaperWizard;

/**
 * The class for tribes, which are made by nations and make people.
 */
public class Tribe
{
    /**
     * A string containing the nation's name. Specifically, the nation a tribe belongs to.
     */
    private final String nationName;
    /**
     * A string containing the tribe's nam.e
     */
    private final String tribeName;
    /**
     * The amount of a life points a tribe is to be created with and how many it has to allocate for people.
     */
    private int tribeLifePoints;
    /**
     * An Array List with the members of a tribe in it.
     */
    private final ArrayList<People> members = new ArrayList<>();
    /**
     * An Array List with the living members of a tribe in it.
     */
    private final ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * The constructor for Tribe. Get passed the nation name and tribe name through a string as well as how many life points
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
                    members.add(new BasicHealer(nationName, tribeName, tribeLifePoints / 6, new BasicHealerStrat()));
                }
            }
        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);

    }

    /**
     * A function which returns an Array List with the living tribe members left. Checks the member of the tribe to see
     * if they are alive or dead and puts them in the Array List if they are alive. If they are dead, it prints to
     * the screen saying the person is dead.
     * @return
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for (People member : members) {
            if (member.isPersonAlive()) {
                livingMembers.add(member);
                tribeLifePoints += member.getLifePoints();
                //System.out.println(members.get(person));
            } else {
                if (!(member.getDead())) {
                    member.setDead();
                    System.out.println("\t\t" + member + " is dead!");
                }
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }

    /**
     * Returns the number of people still alive by returning the size of the livingMembers Array List.
     * @return
     */
    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     * A boolean that returns if a Tribe is still alive.
     * @return
     */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    /**
     * Returns the amount of life points that a tribe has left.
     * @return
     */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * Returns the Tribe's name through a string.
     * @return
     */
    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * Returns the tribe name and members out as a string.
     * @return
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder(tribeName);
        for (People member : members) {
            result.append('\n').append(member.toString());
        }
        result.append('\n');
        return result.toString();
    }

}
