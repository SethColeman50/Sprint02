package Project02;

import java.util.ArrayList;

public abstract class AbstractTribe {
    /**
     * A string containing the nation's name. Specifically, the nation a tribe belongs to.
     */
    protected String nationName;
    /**
     * A string containing the tribe's nam.e
     */
    protected String tribeName;
    /**
     * The amount of a lifepoints a tribe is to be created with and how many it has to allocate for people.
     */
    protected int tribeLifePoints;
    /**
     * An Array List with the members of a tribe in it.
     */
    protected ArrayList<People> members = new ArrayList<>();
    /**
     * An Array List with the living members of a tribe in it.
     */
    protected ArrayList<People> livingMembers = new ArrayList<>();

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
