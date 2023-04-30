package Project02;

import Project02.PeopleType;

/**
 * Class for the people which populate a tribe which make up the nations.
 */
public abstract class People
{
    /**
     * A string containing the person's name.
     */
    private String personName;
    /**
     * A string containing what Nation the person is a part of.
     */
    private String myNation;
    /**
     * A string containing what tribe a person is a part of.
     */
    private String myTribe;
    /**
     * Variable of type PeopleType containing what 'type' a person is. Either Wizard or Warrior.
     */
    private PeopleType me;
    /**
     * Has the description for the person within a string.
     */
    protected String myDescription;
    /**
     * An int variable containing the amount of lifepoints a person has.
     */
    private int myLifePoints;
    /**
     * A boolean variable to mark if a person is alive or dead.
     */
    private boolean dead;
    /**
     * A Strategy type variable with the encounter strategy to be used.
     */
    protected Strategy encounterStrategy;


    /**
     * number of battles a person has been in
     */
    public int uses;


    /**
     * The People constructor. Requires two strings, one for the nation and one for the tribe. It also gets passed
     * how many lifepoints the person has and what strategy will be used for encounters. It stores each in its
     * respective variables.
     * @param nation
     * @param tribe
     * @param person
     * @param lifePoints
     * @param strategy
     */
    public People(String nation, String tribe, PeopleType person, int lifePoints, Strategy strategy)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
        encounterStrategy = strategy;
        uses = 0;
    }

    /**
     * A void function that sets the dead boolean as true, marking the person as dead.
     */
    public void setDead()
    {
        dead = true;
    }

    /**
     * Returns the dead boolean to notify if the person is dead.
     * @return
     */
    public boolean getDead()
    {
        return dead;
    }

    /**
     * Returns what type a person is. Aka if a wizard or warrior.
     * @return
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Returns what tribe a person is a part of.
     * @return
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Returns what nation a person is a part of.
     * @return
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * Checks and returns if a person is alive, aka if their lifepoints are above 0.
     * @return
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * Returns how many lifepoints the person has.
     * @return
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * Modifies the lifepoints a person has by adding the passed value, an int, into the myLifePoints int.
     * Negative lifepoints subtract, positive lifepoints add to it.
     * @param points
     */
    public void modifyLifePoints(int points)
    {
        myLifePoints += points;
    }

    /**
     * Changes what strategy you use. Gets passed a Strategy object and sets it into encounterStrategy varaible.
     * @param s
     */
    public void changeStrategy(Strategy s)
    {
        encounterStrategy = s;
    }

    /**
     * The abstract for how many lifepoints a person got or lost from an encounter.
     * @param me
     * @param otherPerson
     * @return
     */
    public abstract int encounterLifePoints(People me, People otherPerson);

    /**
     * Returns a string with the details of a person. What nation, tribe, who the person is, their description and
     * their lifepoints.
     * @return
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }

    /**
     * Simply returns the encounter strategy
     * @return
     */
    public Strategy getStrat()
    {
        return encounterStrategy;
    }
}

