package Project02;
import Project02.World;

/**
 * The main function that actually takes care of playing the game.
 */
public class PlayGame
{
    //private Random generator;

    /**
     * Creates a new world and starts the game by calling 'war' function.
     */
    public PlayGame()
    {
        World earth = new World();
        earth.war();
    }


}
