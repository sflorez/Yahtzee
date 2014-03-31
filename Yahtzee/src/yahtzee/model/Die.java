/**
 * Yahtzee Die class: creates and manages each individual die.
 * @author Katie Porterfield, Melissa Abramson, Sebastian Florez
 */
package yahtzee.model;
public class Die
{
    public static final int NO_VALUE = -1;

    private int myFaceValue;
    private boolean myIsRolled;
    private boolean getIsChosen;
    private int myMin = 1;
    private int myMax = 7;

    /**
     * Die Constructor, sets myFaceValue to NO_VALUE
     */
    public Die()
    {
    	myFaceValue = NO_VALUE;
    }
    /**
     * Second Die constructor for the sake of the clone method. 
     * takes in the myFaceValue that is in the original die, the getIsChosen boolean of the original die, 
     * and the myIsRolled boolean of the original die.
     * @param int faceVal
     * @param boolean isChosen
     * @param boolean isRolled
     */
    public Die(int faceVal, boolean isChosen, boolean isRolled)
    {
    	myFaceValue = faceVal;
    	myIsRolled = isRolled;
    	getIsChosen = isChosen;
    }

    /**
     * Roll Method:
     * rolls the die and randomly sets the face value to an integer between 1 and 6.
     * @return myFaceValue
     */
    public int roll()
    {
    	
    	myFaceValue = (int) (myMin + Math.random() * (myMax -myMin));
    	myIsRolled = true;
        return myFaceValue;
    }
    
    /**
     * toggleIsChosen Method: 
     * determines if the die is chosen or not, and sets the boolean opposite what it is when the method is called,
     * thus toggling whether or not the die is chosen.
     */

    public void toggleIsChosen()
    {
    	if (getIsChosen == true)
    	{
    		getIsChosen = false;
    	}
    	else if (getIsChosen == false)
    	{
    		getIsChosen = true;
    	}
    }

    /**
     * getIsRolled Method:
     * @return  a boolean stating whether or not the die has been rolled.
     */
    public boolean getIsRolled()
    {
    	if (myIsRolled == false)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    /**
     * getIsChosen Method:
     * returns whether or not the die is chosen
     * @return getIsChosen
     */
    public boolean getIsChosen() 
    {
		return getIsChosen;
	}
    
    /**
     * getFaceValue Method: gets the Face Value of the die
     * @return myFaceValue
     */
    public int getFaceValue()
    {
        return myFaceValue;
    }

    /**
     * setNotRolled Method:
     * sets the die to not rolled by returning a 'false' boolean
     */
    public void setNotRolled()
    {
    	myIsRolled = false;
    }

    /**
     * To String Method
     */
    public String toString()
    {
    	String dieStr = "IsRolled: " + myIsRolled + " GetIsChosen: " + getIsChosen + " myFaceValue: " + myFaceValue;
        return dieStr;
    }

    /**
     * clone Method:
     * makes a clone of the die
     * @return clone
     */
    public Object clone()
    {
    	Die clone = new Die(myFaceValue, getIsChosen, myIsRolled);
        return clone;
    }

	
}
