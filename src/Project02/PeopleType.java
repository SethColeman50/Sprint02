package Project02;

/**
 * PeopleType manages which type a person is. If they are either a Warrior or a Wizard.
 */
public enum PeopleType
{
    /**
     * Denotes that a person is a wizard or a warrior.
     */
    wizard  ("wizard"),
    warrior ("warrior");

    /**
     * A string which contains what type is to be used.
     */
    private final String description;

    /**
     * Function which gets passed which type is to be used and stores it into the description string.
     * @param types
     */
    PeopleType (String types)
    {
        description = types;
    }


    /**
     * Returns the string called description containing what type someone is.
     * @return
     */
    public String getDescription()
    {
        return description;
    }
}
