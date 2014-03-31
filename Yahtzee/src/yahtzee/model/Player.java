/**
 * Player class that creates a player with a valid name and places them into a vector
 * Katie Porterfield, Melissa Abramson, Sebastian Florez
 */
package yahtzee.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player
{
    public static String DEFAULT_NAME = "Player";
    
    private String myName;
    private int myNumberOfWins;
    private ScoreCard myScoreCard;

    /**
     * Player default Constructor
     */
    public Player()
    {
        this.setName(DEFAULT_NAME);
        myNumberOfWins = 0;
        ScoreCard card = new ScoreCard();
        this.setScoreCard(card);
    }

    /**
     * Player Constructor with string Name
     * @param name
     */
    public Player(String name)
    {
        myName = name;
        myNumberOfWins = 0;
        ScoreCard card = new ScoreCard();
        this.setScoreCard(card);
    }

    /**
     * Player Constructor for use with the clone method
     * @param name
     * @param numberOfWins
     * @param scorecard
     */
    public Player(String name, int numberOfWins, ScoreCard scorecard)
    {
        myName = name;
        myNumberOfWins = numberOfWins;
        myScoreCard = scorecard;
    }
    /**
     * Boolean to determine enter name is valid
     * @param name
     * @return
     */
    public static boolean validateName(String name)
    {
        String tester = "\\W";
        Pattern pattern = Pattern.compile(tester);
        Matcher matcher = pattern.matcher(name);
        if(matcher.find())
        {
            return false;
        }
        else
        return true;
    }

    /**
     * Method to return increment the number of wins
     */
    public void incrementWins()
    {
        myNumberOfWins++;
    }

    /**
     * method to reset the number of wins 
     */
    public void resetWins()
    {
        myNumberOfWins = 0;
    }

    /**
     * Method to set the name
     * @param name
     */
    public void setName(String name)
    {
        myName = name;
    }

    /**
     * String method to get the Name
     * @return myName
     */
    public String getName()
    {
        return myName;
    }

    /**
     * method to get teh number of wins
     * @return myNumberOfWins
     */
    public int getNumberOfWins()
    {
        return myNumberOfWins;
    }
    
    /**
     * gives the player a scoreCard
     * @param card
     */
    public void setScoreCard(ScoreCard card)
    {
        myScoreCard = card;
    }

    /**
     * Method to get the scorecard
     * @return myScoreCard
     */
    public ScoreCard getScoreCard()
    {
        return myScoreCard;
    }

    /**
     * toString method
     */
    public String toString()
    {
    	String playerStr = "Name: " + myName + " Number of Wins: " + myNumberOfWins;
        return playerStr;
    }

    /**
     * clone method
     */
    public Object clone()
    {
        Player clone = new Player(myName, myNumberOfWins, myScoreCard);
        return clone;
    }
}
