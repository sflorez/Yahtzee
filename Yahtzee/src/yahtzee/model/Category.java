/**
 * Category class that creates the individual Yahtzee categpries
 * @author Katie Porterfield, Melissa Abramson, Sebastian Florez
 */
package yahtzee.model;

import java.util.Arrays;


public class Category
{
    public static final int NO_VALUE = -1;

    private CategoryType myType;
    private String myName;
    private int myValue;
    private boolean myIsFilled;
    private boolean myIsOkay;
    private int myFoursCounter;
    private int myThreesCounter;
    private int myTwosCounter;
    private boolean mySmallStraightCounter;
    private boolean myLargeStraightCounter;
    private boolean myFullHouseCounter;
    private int[] catValues;

    /**
     * This is the constructor for the Category class.
     * @param CategoryType
     */
    public Category(CategoryType type)
    {
        myType = type;
        myName = myType.getName();
    }

    /**
     * This method goes through the list of categories and checks which category it is and returns true or false based
     * on if it could be filled or not
     * @param an int array with the values of the dice
     * @return a boolean for can be filled
     */
    public boolean canFillCat(int[] nums)
    {
    	if(myType.getName() == "Ones")
        {
            if( this.getIsFilled() == false)
            {
            	for(int i = 0 ; i < nums.length ; i ++ )
                {
                     if(nums[i] == 1)
                     {
                    	 return true;
                     }
                }
            }
            else 
            {
                return false;
            }
            return false;
        }
        else if(myType.getName() == "Twos")
        {
        	if( this.getIsFilled() == false)
            {
            	for(int i = 0 ; i < nums.length ; i ++ )
                {
                     if(nums[i] == 2)
                     {
                    	 return true;
                     }
                }
            }
            else 
            {
                return false;
            }
            return false;
            
        }
        else if(myType.getName() == "Threes")
        {
        	if( this.getIsFilled() == false)
            {
            	for(int i = 0 ; i < nums.length ; i ++ )
                {
                     if(nums[i] == 3)
                     {
                    	 return true;
                     }
                }
            }
            else 
            {
                return false;
            }
            return false;
            
        } 
        else if(myType.getName() == "Fours")
        {
        	if( this.getIsFilled() == false)
            {
            	for(int i = 0 ; i < nums.length ; i ++ )
                {
                     if(nums[i] == 4)
                     {
                    	 return true;
                     }
                }
            }
            else 
            {
                return false;
            }
            return false;
            
        }
        else if(myType.getName() == "Fives")
        {
        	if( this.getIsFilled() == false)
            {
            	for(int i = 0 ; i < nums.length ; i ++ )
                {
                     if(nums[i] == 5)
                     {
                    	 return true;
                     }
                }
            }
            else 
            {
                return false;
            }
            return false;
            
        }
        else if(myType.getName() == "Sixes")
        {
        	if( this.getIsFilled() == false)
            {
            	for(int i = 0 ; i < nums.length ; i ++ )
                {
                     if(nums[i] == 6)
                     {
                    	 return true;
                     }
                }
            }
            else 
            {
                return false;
            }
            return false;
           
        }
        else if(myType.getName() == "Three of a kind")
        {
        	this.threesCounter(nums);
            if(this.getIsFilled() == false)
            {
            	if(this.threesCounter(nums) == true)
            	{
            		return true;
            	}
            	else
            	{
            		return false;
            	}
            	
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Four of a kind")
        {
        	this.foursCounter(nums);
            if(this.getIsFilled() == false)
            {
            	if(this.foursCounter(nums) == true)
            	{
            		return true;
            	}
            	else
            	{
            		return false;
            	}
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Small Straight")
        {
        	this.smallStraightCounter(nums);
            if(this.getIsFilled() == false)
            {
            	if(this.smallStraightCounter(nums) == true)
            	{
            		return true;
            	}
            	else
            	{
            		return false;
            	}
                
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Large Straight")
        {
        	this.largeStraightCounter(nums);
            if(this.getIsFilled() == false)
            {
            	if(this.largeStraightCounter(nums) == true)
            	{
            		return true;
            	}
            	else 
            	{
            		return false;
            	}
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Full House")
        {
        	this.fullHouseCounter(nums);
            if(this.getIsFilled() == false)
            {
            	if( myFullHouseCounter == true)
            	{
            		 return true;
            	}
            	else
            	{
            		return false;
            	}
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Yahtzee")
        {
        	
            if(this.getIsFilled() == false)
            {
            	if(this.isYahtzee(nums) == true)
            {
                return true;
            }
            else
            {
                return false;
            }
            }
            else
            {
            	return false;
            }
            
        }
        else if(myType.getName() == "Chance")
        {
            if(this.getIsFilled() == false)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else
        {
        return false;
        }
    }
    
    
    /**
     * This method goes through the list of categories and checks which category it is and calls the
     * corresponding method for filling that category and sets is filled to true.
     * @param an int array with the values of the dice
     * @return a boolean for being filled
     */
    public boolean fillCategoryValue(int[] nums)
    {
        catValues = nums;
        if(myType.getName() == "Ones")
        {
            if( this.getIsFilled() == false)
            {
                this.fillOnes(nums);
                myIsFilled = true;
                return true;
            }
            else 
            {
                return false;
            }
        }
        else if(myType.getName() == "Twos")
        {
            if(this.getIsFilled() == false)
            {
                this.fillTwos(nums);
                myIsFilled = true;
                return true;
            }
            else 
            {
               return false; 
            }
            
        }
        else if(myType.getName() == "Threes")
        {
            if(this.getIsFilled() == false)
            {
                this.fillThrees(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        } 
        else if(myType.getName() == "Fours")
        {
            if(this.getIsFilled() == false)
            {
                this.fillFours(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Fives")
        {
            if(this.getIsFilled() == false)
            {
                this.fillFives(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Sixes")
        {
            if(this.getIsFilled() == false)
            {
                this.fillSixes(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Three of a kind")
        {
            if(this.getIsFilled() == false)
            {
                this.fillThreeOfKind(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Four of a kind")
        {
            if(this.getIsFilled() == false)
            {
                this.fillFourOfKind(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Small Straight")
        {
            if(this.getIsFilled() == false)
            {
                this.fillSmallStraight(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Large Straight")
        {
            if(this.getIsFilled() == false)
            {
                this.fillLargeStright(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Full House")
        {
            if(this.getIsFilled() == false)
            {
                this.fillFullHouse(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
           
        }
        else if(myType.getName() == "Yahtzee")
        {
            if(this.getIsFilled() == false)
            {
                this.fillYahtzee(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else if(myType.getName() == "Chance")
        {
            if(this.getIsFilled() == false)
            {
                this.fillChance(nums);
                myIsFilled = true;
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else
        {
        return false;
        }
        
    }

    /**
     * @pre make sure that the category is not currently filled 
     * @post if it is not filled return false 
     * if it is filled return true
     * @return boolean for being filled
     */
    public boolean getIsFilled()
    {
        if(myIsFilled == false)
        {
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * This method returns myValue
     * @return myValue 
     */
    public int getValue()
    { 
        
            return myValue;
       
    }
    
    /**
     * This method returns the name of the category
     * @return String
     */
    public String getName()
    {
        return myName;
    }
    
    /**
     * This method returns the type of the category
     * @return CategoryType
     */
    public CategoryType getType()
    {
        return myType;
    }
    
    /**
     * This method returns a String with the class information 
     */
    public String toString()
    {
        String string;
        string = "Category Type: " + this.getType() + " \nCategory Name: " + this.getName() +
                " \nIts value: " + this.getValue() + "\nIs it filled: " + this.getIsFilled();
        return string;
    }

    /**
     * This method returns a clone of the class
     * @return Object
     * 
     */
    public Object clone()
    {
        Category cat = new Category(myType);
        cat.fillCategoryValue(catValues);
        
        return cat;
        
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid
     * 
     * @post method that fills in the "Ones" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillOnes(int[] nums)
    {
        this.testValues(nums);
        if( myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                 if(nums[i] == 1)
                 {
                     myValue += nums[i];
                 }
            }
        
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid
     * 
     * @post method that fills in the "Twos" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillTwos(int[] nums)
    {
        this.testValues(nums);
        if( myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                 if(nums[i] == 2)
                 {
                     myValue += nums[i];
                 }
            }
        
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid
     * 
     * @post method that fills in the "Threes" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillThrees(int[] nums)
    {
        this.testValues(nums);
        if( myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                 if(nums[i] == 3)
                 {
                     myValue += nums[i];
                 }
            }
        
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid
     * 
     * @post method that fills in the "Fours" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillFours(int[] nums)
    {
        this.testValues(nums);
        if( myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                 if(nums[i] == 4)
                 {
                     myValue += nums[i];
                 }
            }
        
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid
     * 
     * @post method that fills in the "Fives" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillFives(int[] nums)
    {
        this.testValues(nums);
        if( myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                 if(nums[i] == 5)
                 {
                     myValue += nums[i];
                 }
            }
        
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid
     * 
     * @post method that fills in the "Sixes" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillSixes(int[] nums)
    {
        this.testValues(nums);
        if( myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                 if(nums[i] == 6)
                 {
                     myValue += nums[i];
                 }
            }
        
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid, also calls threesCounter to make
     * sure there is a three of a kind.
     * 
     * @post method that fills in the "Three of a kind " category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillThreeOfKind(int[] nums)
    {
        this.testValues(nums);
        this.threesCounter(nums);
        if(this.threesCounter(nums) == true)
        {
            if( myIsOkay != false)
            {
                for(int i = 0 ; i < nums.length ; i ++ )
                {
                    myValue += nums[i];
                }
            }
            else 
            {
                myValue = 0;
            }
            
        }
        else
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid, also calls foursCounter to make
     * sure there is a four of a kind.
     * 
     * @post method that fills in the "Four of a kind " category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillFourOfKind(int[] nums)
    {
        this.testValues(nums);
        this.foursCounter(nums);
        if(this.foursCounter(nums) == true)
            if( myIsOkay != false)
        
            {
                for(int i = 0 ; i < nums.length ; i ++ )
                {
                    myValue += nums[i];
                }
            }
            else 
            {
                myValue = 0;
            }
        else
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid, also calls smallStraightCounter to make
     * sure there is a small straight.
     * 
     * @post method that fills in the "Small Straight" category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillSmallStraight(int[] nums)
    {
        this.testValues(nums);
        
        
        if(this.smallStraightCounter(nums) == true )
            if(myIsOkay != false)
            {
                myValue = 30;
            }
            else
            {
                myValue = 0;
            }
        else
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid, also calls largeStraightCounter to
     * make sure there is a large straight.
     * 
     * @post method that fills in the " Large Straight " category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillLargeStright(int[] nums)
    {
        this.testValues(nums);
        
        if( this.largeStraightCounter(nums) == true)
        
            if(myIsOkay != false)
            {
                myValue = 40;
            }
            else
            {
                myValue = 0;
            }
       
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid, also calls fullHouseCounter to make
     * sure there is a full house.
     * 
     * @post method that fills in the "Full House " category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillFullHouse(int[] nums)
    {
        this.testValues(nums);
        
        if(this.fullHouseCounter(nums) == true)
        {
            if(myIsOkay != false)
            {
                myValue = 25;
            }
            else
            {
                myValue = 0;
            }
        }
        else
        {
            myValue = 0;
        }
       
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid.
     * 
     * @post method that fills in the " Yahtzee " category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillYahtzee(int[] nums)
    {
        this.testValues(nums);
        if(myIsOkay != false)
        {
        	if(this.isYahtzee(nums) == true)
        {
            myValue = 50;
        }
        else
        {
            myValue = 0;
        }
    }
    else
    {
    	myValue = 0;
    }
    }
    
    /**
     * @pre calls testValues and makes sure the values are valid.
     * 
     * @post method that fills in the " Chance " category with the correct values from the int array 
     * and sets my value to that value otherwise if the values are not valid it sets myValue to 0. 
     * @param int array of dice values 
     */
    private void fillChance(int[] nums)
    {
        this.testValues(nums);
        if(myIsOkay != false)
        {
            for(int i = 0 ; i < nums.length ; i ++ )
            {
                myValue += nums[i];
            }
        }
        else 
        {
            myValue = 0;
        }
    }
    
    /**
     * 
     * This method loops through the array of dice values and returns a boolean depending on
     * whether the dice values are valid.
     * 
     * @param int array of dice values 
     * @return boolean myIsOkay
     */
    private boolean testValues(int[] nums)
    {
        int badCounter = 0;
        for( int i = 0 ; i < nums.length ; i ++)
        {
            if(nums[i] <= 0 || nums[i] >=7 )
            {
                badCounter ++;
            }
        }
        if(badCounter > 0)
        {
            myIsOkay = false;
        }
        else
        {
            myIsOkay = true;
        }
        return myIsOkay;
    }
    
    /**
     * 
     * This method loops through the array of dice values and returns a counter for the number of
     * fours within the array if there is a four of a kind
     * 
     * 
     * @param int array of dice values 
     * @return int myFoursCounter
     */
    private boolean foursCounter(int[] nums)
    {
    	for (int i = 0; i < nums.length; i++) 
        {
          int counter = 0;
            for (int j = 0; j < nums.length; j++) 
            {
                if (nums[i] == nums[j]) 
                {
                   counter++;
                }
                
            }
            
            if(counter ==4)
            {
            	return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * This method loops through the array of dice values and returns a counter for the number of
     * threes within the array if there is a three of a kind
     * 
     * 
     * @param int array of dice values 
     * @return int myThreesCounter
     */
    private boolean threesCounter(int[] nums)
    {
    	for (int i = 0; i < nums.length; i++) 
        {
          int counter = 0;
            for (int j = 0; j < nums.length; j++) 
            {
                if (nums[i] == nums[j]) 
                {
                   counter++;
                }
                
            }
            
            if(counter ==3)
            {
            	return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * This method loops through the array of dice values and returns a counter for the number of
     * twos within the array if there is a two of a kind (used for finding a full house).
     * 
     * 
     * @param int array of dice values 
     * @return int myTwosCounter
     */
    private boolean twosCounter(int[] nums)
    {
    	for (int i = 0; i < nums.length; i++) 
        {
          int counter = 0;
            for (int j = 0; j < nums.length; j++) 
            {
                if (nums[i] == nums[j]) 
                {
                   counter++;
                }
                
            }
            
            if(counter ==2)
            {
            	return true;
            }
        }
        
        return false;
            
    }
    
    public boolean fiveOfKind(int[] nums)
    {
    	for (int i = 0; i < nums.length; i++) 
        {
          int counter = 0;
            for (int j = 0; j < nums.length; j++) 
            {
                if (nums[i] == nums[j]) 
                {
                   counter++;
                }
                
            }
            
            if(counter ==5)
            {
            	return true;
            }
        }
        
        return false;
    }
    /**
     * 
     * This method calls threesCounter and twosCounter and returns true or false depending if there 
     * is a full house
     * 
     * @param int array of dice values 
     * @return boolean myFullHouseCounter
     */
    private boolean fullHouseCounter(int[] nums)
    {
    	if(this.fiveOfKind(nums) == true)
    	{
    		return true;
    	}
       if( this.threesCounter(nums) == true && this.twosCounter(nums) == true)
       {
           myFullHouseCounter = true; 
           
       }
       else
       {
           myFullHouseCounter = false;
         
       }
       
       return myFullHouseCounter;
    }
    
    /**
     * 
     * This method calls this method loops through the array of dice and determines if there is a
     * small straight
     * 
     * @param int array of dice values 
     * @return boolean mySmallStraightCounter
     */
    private boolean smallStraightCounter(int[] nums)
    {
    	int count = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            if((nums[i] + 1) == nums[i+1])
            {
                count++;
               
            }
            
            if(count > 2)
            {
               
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * This method calls this method loops through the array of dice and determines if there is a
     * large straight
     * 
     * @param int array of dice values 
     * @return boolean myLargeStraightCounter
     */
    private boolean largeStraightCounter(int[] nums)
    {
    	Arrays.sort(nums);
        int counter =0;
        
        for (int i = 0 ; i < nums.length -1 ; i ++)
        { 

           if((nums[i]+1) == nums[i+1])
           {
               counter++;
              
           }
           if(counter == 4)
           {
        	   return true;
           }
        }
       return false;
    }
    
    /**
     * 
     * This method calls this method loops through the array of dice and determines if there is a
     * Yahtzee
     * 
     * @param int array of dice values 
     * @return boolean
     */
    private boolean isYahtzee(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) 
        {
          int counter = 0;
            for (int j = 0; j < nums.length; j++) 
            {
                if (nums[i] == nums[j]) 
                {
                   counter++;
                }
                
                if (counter > 4) 
                {
                  return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args)
    {
    	int [] good = { 1, 2, 3, 4, 6};
       Category cat = new Category(CategoryType.SMALL_STRAIGHT);
       cat.fillSmallStraight(good);
       boolean can =  cat.smallStraightCounter(good);
       int[] yahtzee = {5,5,5,5,5};
       int score = cat.getValue();
       
       System.out.println(can);
       System.out.println(score);
       
    }
    
   
}
