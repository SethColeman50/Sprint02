package Project02;

import Project02.Nation;
import Project02.People;
import java.util.*;

public class World
{
    private final int worldLifePoints = 4000;
    private final int numberOfRounds = 40;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();

    private Die generator;
    private ArrayList<People> worldCreatedPeople = new ArrayList<>();

    /**
     * the World constructor
     * sets up the random number generator and creates the world
     */
    public World()
    {
        // seed for psuedo-random number generator
        Date seed = new Date();
        generator = Die.getInstance();
        createWorld();
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
    }

    /**
     * simulates all the rounds of the game,
     * all living people will
     */
    public void war()
        {
            ArrayList<Integer> worldSurvivingPeople = new ArrayList<>();

            for(int round = 1; round < numberOfRounds; round++)
            {
                Set<String> survivingNations = new HashSet<>();
                System.out.println("Round number: " + round);
                worldSurvivingPeople.clear();
                worldSurvivingPeople.addAll(getWorldSurvivingPeople());
                survivingNations.addAll(getSurvivingNations());
                if ((worldSurvivingPeople.size() >= 2) && (survivingNations.size() > 1) )
                    playOneRound(worldSurvivingPeople);
                else
                {
                    System.out.print("Game is over! Winning Nation is: ");
                    if (survivingNations.size() == 0)
                    {
                        System.out.println("All Nations Destroyed.");
                    }
                    else
                    {
                        System.out.println(survivingNations);
                        System.out.println("The survivors are:");
                        for (Integer i = 0; i < worldSurvivingPeople.size(); i++)
                        {
                            System.out.println(worldCreatedPeople.get(worldSurvivingPeople.get(i)));
                        }
                    }
                    break;
                }

            }

    }


    /**
     * creates a world with four nations
     */
    public void createWorld()
    {
//        allNations.add(new Nation("Idiots", (worldLifePoints / 2)));
//        allNations.add(new Nation("Minions", (worldLifePoints) / 2));
        allNations.add(new Nation("Seths", (worldLifePoints) / 4));
        allNations.add(new Nation("Schapers", (worldLifePoints) / 4));
        allNations.add(new Nation("Owens", (worldLifePoints) / 4));
        allNations.add(new Nation("Orlandos",(worldLifePoints)/4));
    }

    /**
     * @return the total number of people alive
     */
    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        // add all living people from allNations to livingPeople
        for(int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }

    /**
     * @return the number of people that are alive.
     */
    public ArrayList<Integer> getWorldSurvivingPeople()
    {
        ArrayList<Integer> survivors = new ArrayList<>();
        for (Integer i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivors.add(i);
            }
        }
        return survivors;
    }

    /**
     * @return the nations that have any alive people in them
     */
    public Set<String> getSurvivingNations()
    {
        Set<String> survivingNations = new HashSet<>();

        for (Integer i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivingNations.add(worldCreatedPeople.get(i).getNation());
            }
        }
        return survivingNations;
    }

    /**
     * the
     * @param person1 the first person's damage value
     * @param person2 the second person's damage value
     */
    public void encounter(Integer person1, Integer person2)
    {
        Integer person1LifePointsToUse;
        Integer person2LifePointsToUse;
        System.out.println("Encounter: " + worldCreatedPeople.get(person1) + worldCreatedPeople.get(person2));

        //if lifePointsToUse is negative, then person is either running away in a hostile encounter
        // or person is giving life points to another person from same nation
        person1LifePointsToUse = worldCreatedPeople.get(person1).encounterLifePoints(worldCreatedPeople.get(person2), worldCreatedPeople.get(person1));
        person2LifePointsToUse = worldCreatedPeople.get(person2).encounterLifePoints(worldCreatedPeople.get(person1), worldCreatedPeople.get(person2));

        // amount of life points actually used is subject to a psuedo-random encounter
        Integer p1damage =  (generator.roll(10) / 10) * person1LifePointsToUse;
        Integer p2damage =  (generator.roll(10) / 10) * person2LifePointsToUse;

        if ((p1damage > 0) && (p2damage > 0))  // person 1  and person 2 are fighting and inflicting damage
        {
            p2damage =  (generator.roll(10) / 10) * (worldCreatedPeople.get(person1).getType().ordinal()+1)*p1damage;
            p1damage =  (generator.roll(10) / 10) * (worldCreatedPeople.get(person2).getType().ordinal()+1)*p2damage;
        }
        else if ((p1damage > 0) && (p2damage <= 0)) // person 1 is fighting and person 2 is running
        {
            p2damage =  (generator.roll(10) / 10) * (worldCreatedPeople.get(person1).getType().ordinal()+1)*(p1damage/3);
        }
        else if ((p1damage <= 0) && (p2damage > 0)) // person 2 is fighting and person 1 is running
        {
            p1damage =  (generator.roll(10) / 10) * (worldCreatedPeople.get(person2).getType().ordinal()+1)*(p2damage/3);
        }
        else // freindly encounter, do nothing
        {

        }

        // record the damage: positive damage should be subtracted for persons lifePoint
        // negative damage is added to persons life points
        worldCreatedPeople.get(person1).modifyLifePoints((-p2damage));
        worldCreatedPeople.get(person2).modifyLifePoints((-p1damage ));

        // Both people lose 1 life point per encounter due to aging
        worldCreatedPeople.get(person1).modifyLifePoints((-1));
        worldCreatedPeople.get(person2).modifyLifePoints((-1));

    }

    /**
     *
     * @param combatants a list of people's damage values
     */
    public void playOneRound(ArrayList<Integer> combatants)
    {
        System.out.println(combatants.size());
        ArrayList<Integer> survivors = new ArrayList<>();
        Integer numberOfCombatants;
        Collections.shuffle(combatants);
        numberOfCombatants = combatants.size() - 1;
        Integer combatantIndex = 0;
        while(combatantIndex < numberOfCombatants)
        {
            encounter(combatants.get(combatantIndex), combatants.get(combatantIndex+1));
            combatantIndex = combatantIndex + 2;
        }
    }



}
