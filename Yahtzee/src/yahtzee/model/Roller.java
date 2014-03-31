/**
 * Creates the dice from the die class and puts them into a method 
 * and able to roll all or some of them
 * 
 * Katie Porterfield, Melissa Abramson, Sebastian Florez
 */
package yahtzee.model;

import java.util.Vector;

public class Roller
{
    private Vector<Die> myDice = new Vector<Die>();
    private int[] myFaceValuesArray;
    private int myNumberOfDice;

    public Roller(int numDice)
    {
        for (int i = 1; i <= numDice; i++)
        {
            myDice.add(new Die());
        }
        myNumberOfDice = numDice;
    }
/**
 * Gets the Vector Die
 * @return the Dice in a vector
 */
    public Vector<Die> getDice()
    {
        return myDice;
    }
/**
 * gets the dice numbers from the die and puts in arrays
 * @return
 * an Array of the die values
 */
    public int[] getDiceValues()
    {
        myFaceValuesArray = new int[myNumberOfDice];
        int i = 0;
        for(Die dice : myDice)
        {
            myFaceValuesArray[i] = dice.getFaceValue();
            i++;
        }
        return myFaceValuesArray;
    }
/**
 * rolls all the die in the array
 */
    public void roll()
    {
        this.getDice();
        for(int i = 0; i < myNumberOfDice; i++)
        {
            myDice.elementAt(i).roll();
        }
    }
/**
 * roll the dice based off the boolean 
 * @param toRoll
 */
    public void rollSome(boolean[] toRoll)
    {
        this.getDice();
        for(int i = 0; i < myNumberOfDice; i++)
        {
            if(toRoll[i] == true)
                myDice.elementAt(i).roll();
        }
    
    }
/**
 * returns the number of dice
 * @return myNumberOfDice
 */
    public int getNumberOfDice()
    {
       return myNumberOfDice;
    }

    /**
     * toString Method
     */
    public String toString()
    {
    	String rollerStr = "Number Of Dice: " + myNumberOfDice + " FaceValues arrary: " + myFaceValuesArray;
        return null;
    
	}
}
