/**
 * Yahtzee Engine class Starts the games, switches between players and allows the game to play
 * @author Katie Porterfield, Melissa Abramson, Sebastian Florez
 */
package yahtzee.model;
import java.util.Vector;

public class YahtzeeEngine
{
    public static final int MAX_ROLLS = 3;

    private Vector<Player> myPlayers = new Vector<Player>();
    private Player myPlayerUp;

    private int numberOfPlayers;
    private Roller myRoller;
    private int myNumberRollsUsed;

    /**
     * YahtzeeEngine constructor
     * @param numPlayers
     */
    public YahtzeeEngine(int numPlayers)
    {
        if(numPlayers == 0)
        {
            numberOfPlayers = 2;
        }
        else if(numPlayers > 6)
        {
            numberOfPlayers = 2;
        }
        else 
        {
            numberOfPlayers = numPlayers;
        }
         
        for(int i = 1; i <= numberOfPlayers; i++)
        {
            myPlayers.add(new Player("Player"));
        }
    }

    /**
     * startGame Method: creates a new player and initially creates a roller with 5 dice.
     */
    public void startGame()
    {

        Player player = this.getPlayers().get(0);
        this.selectPlayerUp(player);
        myRoller = new Roller(5);

    }

    /**
     * method that gets the playerUp
     * @param player
     */
    public void selectPlayerUp(Player player)
    {

        myPlayerUp = player;
        
    }

    /**
     * Method that gets the current player and increments through the vector of players in order
     * to switch which player is up
     */
    public void switchPlayerUp()
    {
       
      int i = this.getPlayers().indexOf(this.getPlayerUp());
        if(myPlayerUp == this.getPlayers().get(i))
        {
            i ++;
            if(i >= this.getPlayers().size())
            {
                i = 0;
            }
            myPlayerUp = this.getPlayers().get(i);
        }     
    }
       
    /**
     * Method to increment how many rolls have been used up to three rolls per player per turn
     * @return
     */

    public boolean incrementRollsUsed()
    {
        if(myNumberRollsUsed < 3)
        {
            myNumberRollsUsed++;
            return true;
        }
        else
            return false;
    }

    /**
     * method to reset the number of rolls used back to zero
     */
    public void resetNumberRollsUsed()
    {
        myNumberRollsUsed = 0;
    }
    
    /**
     * method to get the Roller
     * @return myRoller
     */

    public Roller getRoller()
    {
        return myRoller;
    }

    /**
     * Method to get which player is up
     * @return myPlayerUp
     */
    public Player getPlayerUp()
    {
        return myPlayerUp;
    }

    /**
     * method to return the vector of players
     * @return myPlayers
     */
    public Vector<Player> getPlayers()
    {
        return myPlayers;
    }

    /**
     * method to get the NumberOfRollsUsed
     * @return
     */
    public int getNumberRollsUsed()
    {
        return myNumberRollsUsed;
    }

    /**
     * toString method
     */
    public String toString()
    {
        return null;
    }
      
    
}
