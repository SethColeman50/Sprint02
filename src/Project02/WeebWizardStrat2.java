package Project02;

/**
 * Only activated when facing a Healer. The wizard uses magic to disturb the healer, weakening them (aka doing damage).
 * You take a small fraction of half of the healer's energy for yourself, but you can only do that when you are actually
 * stronger than the healer (as the wizard is a massive glass canon)
 * If they are not weaker than you, their resistance is higher so you do a basic, rather weak attack.
 */
public class WeebWizardStrat2 implements Strategy
{
    /**
     * Runs an encounter with a healer, returning how many lifepoints the healer is to lose.
     * @param me - person to get life points for.
     * @param otherPerson - the opponent of the encounter
     * @return
     */
    public int strategy(People me, People otherPerson)
    {
        int lifepoints = 0;
        if(me.getLifePoints() >= otherPerson.getLifePoints())
        {
            lifepoints = (otherPerson.getLifePoints()/2); //Cast a curse and weaken them, taking a fraction of it for yourself.
            me.modifyLifePoints(otherPerson.getLifePoints()/4); //This is additional to the innate damage heal.
        }
        else
        {
            lifepoints = ((me.getLifePoints()/4)*2); //Cast a regular damaging spell.
        }
        return lifepoints;
    }
}
