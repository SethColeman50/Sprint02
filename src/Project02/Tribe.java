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
public class Tribe
{
    /**
     * A string containing the nation's name. Specifically, the nation a tribe belongs to.
     */
    private String nationName;
    /**
     * A string containing the tribe's nam.e
     */
    private String tribeName;
    /**
     * The amount of a lifepoints a tribe is to be created with and how many it has to allocate for people.
     */
    private int tribeLifePoints;
    /**
     * An Array List with the members of a tribe in it.
     */
    private ArrayList<People> members = new ArrayList<>();
    /**
     * An Array List with the living members of a tribe in it.
     */
    private ArrayList<People> livingMembers = new ArrayList<>();

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
                    members.add(new OwenWarrior(nationName, tribeName, tribeLifePoints / 6, new OwenWarriorStrategy(), new OwenWarriorStrategy2()));
                } else if (nation.equals("Orlandos")) {
                    members.add(new WeebWarrior(nationName,tribeName,tribeLifePoints/ 6, new WeebWarriorStrat()));
                }
            } else if (i % 3 == 1) { //idk if evens?
                if (nation.equals("Schapers")) {
                    members.add(new SchaperWizard(nationName, tribeName, tribeLifePoints / 6, new WizardStrategy()));
                } else if (nation.equals("Seths")) {
                    members.add(new SethWizard(nationName, tribeName, tribeLifePoints / 6, new SethWizardStrategy()));
                } else if (nation.equals("Owens")) {
                    members.add(new OwenWizard(nationName, tribeName, tribeLifePoints / 6, new OwenWizardStrategy(), new OwenWizardStrategy2()));
                } else if (nation.equals("Orlandos")) {
                    members.add(new WeebWizard(nationName, tribeName, tribeLifePoints / 6, new WeebWizardStrat()));
                }
            } else {
                if (nation.equals("Schapers")){
                    members.add(new BasicHealer(nationName, tribeName, tribeLifePoints / 6, new BasicHealerStrat()));
                }
                else if (nation.equals("Seths")){
                    members.add(new SethHealer(nationName, tribeName, tribeLifePoints / 6, new BasicHealerStrat()));
                }
                else if (nation.equals("Owens")){
                    members.add(new OwenHealer(nationName, tribeName, tribeLifePoints / 6, new OwenHealerStrategy(), new OwenHealerStrategy2()));
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
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
            else
            {
                if(!(members.get(person).getDead()))
                {
                    members.get(person).setDead();
                    System.out.println("\t\t" + members.get(person) + " is dead!");
                }
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/

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
     * Returns the amount of lifepoints that a tribe has left.
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
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
