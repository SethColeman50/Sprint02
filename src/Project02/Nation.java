package Project02;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project02.Tribe;
import Project02.People;

/**
 * The class Nation which creates tribes populated by people. There are to be a bare minimum of 2.
 */
public class Nation
{
    /**
     * The int containing the number of life points a nation has.
     */
    private int nationLifePoints;
    /**
     * The string containing the nation's name.
     */
    private String nationName;
    /**
     * An Array List with all the tribes a nation has.
     */
    private ArrayList<AbstractTribe> tribes = new ArrayList<>();
    /**
     * An Array List with the people total in the Nation.
     */
    private ArrayList<People> population = new ArrayList<>();
    /**
     * An Array List with the people still alive.
     */
    private ArrayList<People> livingPopulation = new ArrayList<>();


    /**
     * The constructor. Takes a string for the name and the number of lifepoints to initiate it with.
     * It saves the name of the nation into nationName and the amount of lifepoints into nationLifePoints.
     * It then creates 5 tribes and adds the population and copies that same population into livingPopulation.
     * @param name
     * @param lifePoints
     */
    public Nation(String name, int lifePoints)
    {
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 5; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 5));
        }
        this.tribes.add(new Artifacts());
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }


    /**
     * Gets the living population of the nation.
     * @return
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }


    /**
     * returns the nation name.
     * @return
     */
    public String getNationName()
    {
        return nationName;
    }


    /**
     * Prints to the screen if the tribes within a specific nation are alive or dead. If alive, how many members left.
     */
    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    /**
     * Returns a string with all the tribes in a nation.
     * @return
     */
    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
