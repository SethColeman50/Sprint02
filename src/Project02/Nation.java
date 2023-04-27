package Project02;

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
    private final String nationName;
    /**
     * An Array List with all the tribes a nation has.
     */
    private final ArrayList<Tribe> tribes = new ArrayList<>();
    /**
     * An Array List with the people total in the Nation.
     */
    private final ArrayList<People> population = new ArrayList<>();
    /**
     * An Array List with the people still alive.
     */
    private final ArrayList<People> livingPopulation = new ArrayList<>();


    /**
     * The constructor. Takes a string for the name and the number of life points to initiate it with.
     * It saves the name of the nation into nationName and the amount of life points into nationLifePoints.
     * It then creates 5 tribes and adds the population and copies that same population into livingPopulation.
     * @param name the name of the nation
     * @param lifePoints the total life points of the nation
     */
    public Nation(String name, int lifePoints)
    {
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 5; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 5));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }


    /**
     * Gets the living population of the nation.
     * @return a list of the current people that are living
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for (Tribe value : this.tribes) {
            if (value.isTribeAlive()) {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(value.getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += value.getTribeLifePoints();
            }
        }
        return livingPopulation;
    }


    /**
     * Returns a string with all the tribes in a nation.
     * @return a string with all the data on the nation
     */
    public String toString()
    {
        StringBuilder result = new StringBuilder(nationName);
        for (Tribe tribe : tribes) {
            result.append('\n').append(tribe.toString());

        }
        result.append('\n');
        return result.toString();
    }
}
