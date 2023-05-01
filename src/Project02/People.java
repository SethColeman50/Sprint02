package Project02;

import Project02.PeopleType;

/**
 * Class for the people which populate a tribe which make up the nations.
 */
public abstract class People
{
    /**
     * A string containing what Nation the person is a part of.
     */
    private final String myNation;
    /**
     * A string containing what tribe a person is a part of.
     */
    private final String myTribe;
    /**
     * Variable of type PeopleType containing what 'type' a person is. Either Wizard or Warrior.
     */
    private final PeopleType me;
    /**
     * Has the description for the person within a string.
     */
    protected String myDescription;
    /**
     * An int variable containing the amount of life points a person has.
     */
    private int myLifePoints;
    /**
     * A boolean variable to mark if a person is alive or dead.
     */
    private boolean dead;
    /**
     * A Strategy type variable with the encounter strategy to be used.
     */
    protected final Strategy encounterStrategy;


    /**
     * number of battles a person has been in
     */
    public int uses;


    /**
     * The People constructor. Requires two strings, one for the nation and one for the tribe. It also gets passed
     * how many life points the person has and what strategy will be used for encounters. It stores each in its
     * respective variables.
     * @param nation the nation this person is a part of
     * @param tribe the tribe this person is a part of
     * @param person the type of the person
     * @param lifePoints the total life points of the person
     * @param strategy the persons strategy
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
     * @return true if the person is dead, false if otherwise
     */
    public boolean getDead()
    {
        return dead;
    }

    /**
     * Returns what type a person is. Aka if a wizard or warrior.
     * @return the persons type as an enum value
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     * Returns what tribe a person is a part of.
     * @return a string that is the name of the persons tribe
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Returns what nation a person is a part of.
     * @return the person's nation as a string
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     * Checks and returns if a person is alive, aka if their life points are above 0.
     * @return true if person is alive
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0 && uses < 2);
    }

    /**
     * Returns how many life points the person has.
     * @return the persons current life points as an int
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * Modifies the life points a person has by adding the passed value, an int, into the myLifePoints int.
     * Negative life points subtract, positive life points add to it.
     * @param points the points that are added or subtracted from your health
     */
    public void modifyLifePoints(int points)
    {
        if (myLifePoints + points >= 100) {
            myLifePoints = 100;
        } else {
            myLifePoints += points;
        }
    }

    /**
     * The abstract for how much life points a person got or lost from an encounter.
     * @param me
     * @param otherPerson
     * @return
     */
    public abstract int encounterLifePoints(People me, People otherPerson);

    /**
     * Returns a string with the details of a person. What nation, tribe, who the person is, their description and
     * their life points.
     * @return
     */
    public String toString()
    {
        return myNation + "\t" + myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints;
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

