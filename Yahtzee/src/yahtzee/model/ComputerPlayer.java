package yahtzee.model;

import java.util.Vector;


public class ComputerPlayer extends Player
{
//    public static boolean rollAgain(int[] values)
//    {
//        return false;
//    }
//
//    public static boolean[] selectDiceToReroll(int[] values)
//    {
//        return null;
//    }
//
//    public static CategoryType selectCategoryToFill(int[] values)
//    {
//        return null;
//    }
	
	Vector<CategoryType> typesUp =  new Vector<CategoryType>();
	Vector<CategoryType> typesLow =  new Vector<CategoryType>();
	int[] typesUpWeight = {1, 2, 3, 4, 5, 6 };
	int[] typesLowWeight = {8, 9, 10, 11, 12, 13, 7};
	int[] nums;
	int myLowerChosen = 0;
	int myUpperChosen = 0;
	CategoryType chosen;
	boolean upper = false;
	boolean lower = false;
	int index;
	
	
	
	public ComputerPlayer()
	{
		this.setName("ComputerPlayer");
		
		typesUp.add(CategoryType.ONES);
    	typesUp.add(CategoryType.TWOS);
    	typesUp.add(CategoryType.THREES);
    	typesUp.add(CategoryType.FOURS);
    	typesUp.add(CategoryType.FIVES);
    	typesUp.add(CategoryType.SIXES);
    	
    	typesLow.add(CategoryType.THREE_OF_KIND);
    	typesLow.add(CategoryType.FOUR_OF_KIND);
    	typesLow.add(CategoryType.SMALL_STRAIGHT);
    	typesLow.add(CategoryType.LARGE_STRAIGHT);
    	typesLow.add(CategoryType.FULL_HOUSE);
    	typesLow.add(CategoryType.YAHTZEE);
    	typesLow.add(CategoryType.CHANCE);
    	
    	ScoreCard card = new ScoreCard();
    	this.setScoreCard(card);
    	
	}
	
	/**
	 * This method is the logic behind the computer player, it iterates through the categories and determines which it can 
	 * fill. Depending on the categories it can fill it will choose based off the amount of weight the category has. If no
	 * categories are chosen it will find the first available category to fill and fill it with zero.
	 * @param array of values
	 */
	public void takeTurn(int[] values)
	{
		myUpperChosen = 0;
		myLowerChosen = 0;
	
		for(int i = 0 ; i< typesUp.size() ; i ++)
		{
			if(this.getScoreCard().canFillUp(i, values) == true)
			{
				myUpperChosen = typesUpWeight[i];
				
			}
			
		}
		
		System.out.println(myUpperChosen);
		for(int i = 0 ; i < typesLow.size() ; i ++)
		{
			if(this.getScoreCard().canFillLow(i, values) == true)
			{
				myLowerChosen = typesLowWeight[i];
				
			}
			
		}
		System.out.println(myLowerChosen);
		if(myUpperChosen > myLowerChosen)
		{
			for ( int i = 0 ; i < typesUpWeight.length ; i ++)
			{
				if( myUpperChosen == typesUpWeight[i])
				{
				
					System.out.println("blahh");
					this.getScoreCard().fillCategory(typesUp.elementAt(i), values);
					chosen = typesUp.elementAt(i);
					upper = true;
					lower = false;
					index = i;
				}
			}
		}
		else if (myLowerChosen > myUpperChosen)
		{
			for ( int i = 0 ; i < typesLowWeight.length ; i ++)
			{
				if( myLowerChosen == typesLowWeight[i])
				{
//					System.out.println(myLowerChosen);
					this.getScoreCard().fillCategory(typesLow.elementAt(i), values);
					chosen = typesLow.elementAt(i);
					lower = true;
					upper = false;
					index = i;
//					System.out.println(this.getScoreCard().getCategory(typesLow.elementAt(i)).getValue());
				}
			}
		}
		else
		{
			for(int i = 0 ; i< typesUp.size() ; i ++)
			{
				if(this.getScoreCard().getCategory(typesUp.elementAt(i)).getIsFilled() == false)
				{
					this.getScoreCard().fillCategory(typesUp.elementAt(i), values);
					chosen = typesUp.elementAt(i);
					upper = true;
					lower = false;
					index = i;
					break;
				}
				
			}
			
			for(int i = 0 ; i < typesLow.size() ; i ++)
			{
				if(this.getScoreCard().getCategory(typesLow.elementAt(i)).getIsFilled() == false)
				{
					this.getScoreCard().fillCategory(typesLow.elementAt(i), values);
					chosen = typesLow.elementAt(i);
					lower = true;
					upper = false;
					index = i;
					break;
				}
			}
		}
		
		
	}
	
	public CategoryType getJustFilled()
	{
		return chosen;
	}
	
	public boolean getUpperOrLower()
	{
		if (upper == true)
		{
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public static void main(String[] args)
    {
    	int[] values = {1,1,1,1,6};
       ComputerPlayer player = new ComputerPlayer();
       player.takeTurn(values);
       player.takeTurn(values);
       player.takeTurn(values);
       int score = player.getScoreCard().getCategory(CategoryType.ONES).getValue();
//       System.out.println(score);
       int number = player.getScoreCard().getNumberCategoriesFilled();
       boolean filled = player.getScoreCard().getCategory(CategoryType.CHANCE).canFillCat(values);
//       System.out.println(number);
//       System.out.println(filled);
//       int[] values2 = {1,3,5,5,5};
//       player.takeTurn(values2);
       int filled2 = player.getScoreCard().getNumberCategoriesFilled();
//       System.out.println(filled2);
       
       
       
    }
}
