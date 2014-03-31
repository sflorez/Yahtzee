package yahtzee.model;
/**
 * Yahtzee ScoreCard Class, creates and manages a score card
 * @author Katie Porterfield, Melissa Abramson, Sebastian Florez
 */

import java.util.Vector;

public class ScoreCard
{
    public static final int NUMBER_BOTTOM_CATEGORIES = 7;
    public static final int NUMBER_TOP_CATEGORIES = 6;
    public static final int NUMBER_CATEGORIES_TOTAL = 13;
    public static final int UPPER_BONUS = 63;
    public static final int BONUS = 35;
    private int isFilledCounter = 0;

    private Vector<Category> myUpperCategories = new Vector<Category>();
    private Vector<Category> myLowerCategories = new Vector<Category>();

    private int myUpperScore;
    private int myUpperTotal;
    private int myLowerTotal;
    private int myGrandTotal;
    

    private int myNumberCategoriesFilled;

    /**
     * ScoreCard constructor
     * adds the categories from Category into each element of the vector,
     * and sets all other values to a default 0.
     */
    public ScoreCard()
    {
    	myUpperCategories.add(new Category(CategoryType.ONES));
    	myUpperCategories.add(new Category(CategoryType.TWOS));
    	myUpperCategories.add(new Category(CategoryType.THREES));
    	myUpperCategories.add(new Category(CategoryType.FOURS));
    	myUpperCategories.add(new Category(CategoryType.FIVES));
    	myUpperCategories.add(new Category(CategoryType.SIXES));
    	

    	myLowerCategories.add(new Category(CategoryType.THREE_OF_KIND));
    	myLowerCategories.add(new Category(CategoryType.FOUR_OF_KIND));
    	myLowerCategories.add(new Category(CategoryType.SMALL_STRAIGHT));
    	myLowerCategories.add(new Category(CategoryType.LARGE_STRAIGHT));
    	myLowerCategories.add(new Category(CategoryType.FULL_HOUSE));
    	myLowerCategories.add(new Category(CategoryType.YAHTZEE));
    	myLowerCategories.add(new Category(CategoryType.CHANCE));
    	
    	myUpperScore = 0;
    	myUpperTotal = 0;
    	myLowerTotal = 0;
    	myGrandTotal = 0;
    	myNumberCategoriesFilled = 0;

    }
    
    /**
     * resetScoreCard Method: 
     * sets all elements of the vector to new Category elements
     * and resets all default values.
     */
    public void resetScoreCard()
    {
    	myUpperCategories.set(0,new Category(CategoryType.ONES));
    	myUpperCategories.set(1,new Category(CategoryType.TWOS));
    	myUpperCategories.set(2,new Category(CategoryType.THREES));
    	myUpperCategories.set(3,new Category(CategoryType.FOURS));
    	myUpperCategories.set(4,new Category(CategoryType.FIVES));
    	myUpperCategories.set(5,new Category(CategoryType.SIXES));
    	

    	myLowerCategories.set(0,new Category(CategoryType.THREE_OF_KIND));
    	myLowerCategories.set(1,new Category(CategoryType.FOUR_OF_KIND));
    	myLowerCategories.set(2,new Category(CategoryType.SMALL_STRAIGHT));
    	myLowerCategories.set(3,new Category(CategoryType.LARGE_STRAIGHT));
    	myLowerCategories.set(4,new Category(CategoryType.FULL_HOUSE));
    	myLowerCategories.set(5,new Category(CategoryType.YAHTZEE));
    	myLowerCategories.set(6,new Category(CategoryType.CHANCE));
    	myUpperScore = 0;
    	myUpperTotal = 0;
    	myLowerTotal = 0;
    	myGrandTotal = 0;
    	myNumberCategoriesFilled = 0;

    }

    /**
     * fillCategory Method:
     * method to loop through each element of the upper and lower category vectors,
     * and test to see if each element is filled or not and if the element has not been filled
     * if fills the category, and returns true,
     * but if the category is filled lready it returns false.
     * @param type
     * @param values
     * @return boolean of whether the category is filled
     */
    
    public boolean canFillUp(int category, int[] nums)
    {
    	if(myUpperCategories.elementAt(category).canFillCat(nums) == true)
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
    
    public boolean canFillLow( int category, int[] nums)
    {
    	if(myLowerCategories.elementAt(category).canFillCat(nums) == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public boolean fillCategory(CategoryType type, int[] values)
    {
    	
    	Category cat;
    	
    	for(int i = 0; i < myUpperCategories.size(); i++)
    	{
    		cat = myUpperCategories.elementAt(i);
    		if(cat.getType() == type)
    		{
    			cat.fillCategoryValue(values);
    			if(isFilledCounter == 0)
    			{
    				isFilledCounter = isFilledCounter + 1;
    				return true;
    			}
    			else if (isFilledCounter >= 1)
    			{
    				return false;
    			}
    			
    		}
    		
    	}
    	for(int i = 0; i < myLowerCategories.size(); i++)
    	{
    		cat = myLowerCategories.elementAt(i);
    		if(cat.getType() == type)
    		{
    			cat.fillCategoryValue(values);

    			if(isFilledCounter == 0)
    			{
    				isFilledCounter = isFilledCounter + 1;
    				return true;
    			}
    			else if (isFilledCounter >= 1)
    			{
    				return false;
    			}
    		}
    		
    	}
    	return false;
    }

    /**
     * getCategory Method
     * loops through the upper and lower category vectors and checks
     * to see if the vector category type is equal to the entered type, and if it is
     * it returns that category type
     * @param type
     * @return the category
     */
    public Category getCategory(CategoryType type)
    {

    	
    	Category cat = new Category(type);
    	for(int i = 0; i < myUpperCategories.size(); i++)
    	{
    		cat = myUpperCategories.elementAt(i);
    		if(cat.getType() == type)
    		{
    		return cat;
    		}
    		
    	}
    	for(int i = 0; i < myLowerCategories.size(); i++)
    	{
    		cat = myLowerCategories.elementAt(i);
    		if(cat.getType() == type)
    		{
    		return cat;
    		}
    		
    	}
       return cat;
    }

    /**
     * loops through the upper and lower category vectors , and if an element in the vector has a filled category
     * getNumberCategoriesFilled is incremented by 1
     * @return getNumberCategoriesFilled
     */
    public int getNumberCategoriesFilled()
    {
    	myNumberCategoriesFilled = 0;
    	Category cat;
    	for( int i = 0; i < myUpperCategories.size(); i++)
    	{
    		cat = myUpperCategories.elementAt(i);
    		if(cat.getIsFilled() == true)
    		{
    			myNumberCategoriesFilled = myNumberCategoriesFilled + 1;
    		}
    		
    	}
    	for (int i = 0; i < myLowerCategories.size(); i++)
    	{
    		cat = myLowerCategories.elementAt(i);
    		if(cat.getIsFilled() == true)
    		{
    			myNumberCategoriesFilled = myNumberCategoriesFilled + 1;
    		}
    		
    		
    	}
    	
        return myNumberCategoriesFilled;
    }

    /**
     * calculateUpperScore Method:
     * Method to loop through the upper category vector and gets the values
     * of each element, adds them, and returns the score
     * @return myUpperScore
     */
    public int calculateUpperScore()
    {
    	myUpperScore = 0;
    	for(int i = 0; i < myUpperCategories.size(); i++)
    	{
    		myUpperScore = myUpperScore + myUpperCategories.get(i).getValue();
    		
    	}
    	
        return myUpperScore;
    }

    /**
     * calculateUpperTotal Method:
     * method to test whether the upper score is equal or greater than 63, 
     * and if it is gives a 35 point bonus 
     * @return myUpperTotal
     */
    public int calculateUpperTotal()
    {
    	myUpperTotal = 0;
    	
    	if(this.getUpperScore() < UPPER_BONUS)
    	{
    		myUpperTotal = myUpperScore;
    	}
    	else if(this.getUpperScore() >= UPPER_BONUS)
    	{
    		myUpperTotal = myUpperScore + BONUS;
    	}
    	
        return myUpperTotal;
    }

    /**
     * calculateLowerTotal Method:
     * loops through the lower category 
     * @return myLowerTotal
     */
    public int calculateLowerTotal()
    {
    	myLowerTotal = 0;
    	for(int i = 0; i < myLowerCategories.size(); i++)
    	{
    		myLowerTotal = myLowerTotal + myLowerCategories.elementAt(i).getValue();
    	}
        return myLowerTotal;
    }

    /**
     * calculateGrandTotal Method:
     * adds the upper and lower total
     * @return myGrandTotal
     */
    public int calculateGrandTotal()
    {
    	myGrandTotal = this.getLowerTotal() + this.getUpperTotal();
        return myGrandTotal;
    }

    /**
     * getUpperScore Method:
     * @return myUpperScore
     */
    public int getUpperScore()
    {
    	this.calculateUpperScore();
        return myUpperScore;
    }

    /**
     * getUpperTotal Method:
     * @return myUpperTotal
     */
    public int getUpperTotal()
    {
    	this.calculateUpperTotal();
        return myUpperTotal;
    }

    /**
     * getLowerTotal Method:
     * @return myLowerTotal
     */
    public int getLowerTotal()
    {
    	this.calculateLowerTotal();
        return myLowerTotal;
    }

    /**
     * getGrandTotal Method:
     * @return myGrandTotal
     */
    public int getGrandTotal()
    {
    	this.calculateGrandTotal();
        return myGrandTotal;
    }

    /**
     * toString Method
     */
    public String toString()
    {
    	String scoreCardStr = "UpperScore: " + myUpperScore + " UpperTotal: " + myUpperTotal + " LowerTotal: " + myLowerTotal + "GrandTotal: " + myGrandTotal; 
        return null;
    }

    /**
     * ScoreCard clone Method
     * makes a clone of the scoreCard
     * @return clone
     */
    @SuppressWarnings("unchecked")
	public ScoreCard clone()
    {
    	ScoreCard clone = new ScoreCard(); 
 
    	clone.isFilledCounter = isFilledCounter;
    	clone.myLowerCategories = (Vector<Category>) myLowerCategories.clone();
    	clone.myUpperCategories = (Vector<Category>) myUpperCategories.clone();
    
    	return clone;
    }

}
