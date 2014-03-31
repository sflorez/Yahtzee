package yahtzee.controller;

import java.awt.Color;

import javax.swing.JOptionPane;

import yahtzee.model.CategoryType;
import yahtzee.model.ComputerPlayer;
import yahtzee.model.Player;
import yahtzee.model.ScoreCard;
import yahtzee.model.YahtzeeEngine;
import yahtzee.view.View;

public class Controller {

	private View myView;
	private Player myPlayer;
	private YahtzeeEngine myEngine;
	private ScoreCard myScoreCard;
	private ComputerPlayer myComputerPlayer;
	
	
	
	public Controller()
	{
		
		myEngine = new YahtzeeEngine(2);
		myView = new View(this);
		myComputerPlayer = new ComputerPlayer();
	}
	
	
	
	/**
	 * method that rolls the dice and changes the categories based on the categories that can be filled
	 */
	public void roll()
	{
		
		if( myEngine.getNumberRollsUsed()< 3)
		{
			myEngine.getRoller().roll();
			myEngine.incrementRollsUsed();
			int[] values = myEngine.getRoller().getDiceValues();
			myView.setDice(values);
			myView.setDefaultSelected();
			
			for(int i = 0; i < values.length; i ++)
			{
				System.out.println(values[i]);
			}
			
			for (int i = 0 ; i < myView.getUpperCats().length -3 ; i ++)
			{
				if (myEngine.getPlayerUp().getScoreCard().canFillUp(i, values) == true)
				{
					myView.setUpperCatBackground(i);
				}
				else
				{
					myView.setUpDefaultBackground(i);
				}
			}
			
			for ( int i = 0; i < myView.getLowerCats().length -3 ; i ++)
			{
				if (myEngine.getPlayerUp().getScoreCard().canFillLow(i, values) == true)
				{
					myView.setLowerCatBackground(i);
				}
				else
				{
					
					myView.setLowDefaultBackground(i);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You Have Used All Your Rolls");
		}
		
	}
	
	/**
	 * starts the yahtzee game
	 */
	public void startGame()
	{
		myEngine.startGame();
		this.UpdateTotals();
		myView.setPlayerName();
	}
	
	/**
	 * rolls only the selected dice
	 */
	public void rollSome()
	{
		if( myEngine.getNumberRollsUsed() < 3 )
		{
			boolean[] toRoll = myView.getSelectedDice();
			myEngine.getRoller().rollSome(toRoll);
			myEngine.incrementRollsUsed();
			int[] values = myEngine.getRoller().getDiceValues();
			myView.setDice(values);
			myView.setDefaultSelected();
			
			for (int i = 0 ; i < myView.getUpperCats().length -3 ; i ++)
			{
				if (myEngine.getPlayerUp().getScoreCard().canFillUp(i, values) == true)
				{
					myView.setUpperCatBackground(i);
				}
				else
				{
					myView.setUpDefaultBackground(i);
				}
			}
			
			for ( int i = 0; i < myView.getLowerCats().length ; i ++)
			{
				if (myEngine.getPlayerUp().getScoreCard().canFillLow(i, values) == true)
				{
					myView.setLowerCatBackground(i);
				}
				else
				{
					
					myView.setLowDefaultBackground(i);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You Have Used All Your Rolls");
		}
		
	}
	
	/**
	 * goes to the next turn and lets the computer player take its turn 
	 */
	public void nextTurn()
	{
		myView.incrementTurns();
		myView.setPlayerDefault();
		myView.setComputerName();
		myEngine.resetNumberRollsUsed();
		myEngine.getRoller().roll();
		int[] values = myEngine.getRoller().getDiceValues();
		myComputerPlayer.takeTurn(values);
		myView.setDice(values);
		int value = myComputerPlayer.getScoreCard().getCategory(myComputerPlayer.getJustFilled()).getValue();
		int index = myComputerPlayer.getIndex();
		if( myComputerPlayer.getUpperOrLower() == true)
		{
			myView.setUpperCats2(index, value);
		}
		else
		{
			myView.setLowerCats2(index, value);
		}
		myEngine.resetNumberRollsUsed();
		this.UpdateTotals();
		myView.setPlayerName();
		myView.setComputerDefault();
		myView.incrementTurns();
	}
	
	/**
	 * methods that follow are called depending on which die was selected and sets the image of the view
	 */
	public void firstDieSelected()
	{
		myView.setSelected(0 , myEngine.getRoller().getDiceValues()[0]);
	}
	
	public void secondDieSelected()
	{
		myView.setSelected(1, myEngine.getRoller().getDiceValues()[1]);
	}
	
	public void thirdDieSelected()
	{
		myView.setSelected(2, myEngine.getRoller().getDiceValues()[2]);
	}
	
	public void fourthDieSelected()
	{
		myView.setSelected(3, myEngine.getRoller().getDiceValues()[3]);
	}
	
	public void fifthDieSelected()
	{
		myView.setSelected(4, myEngine.getRoller().getDiceValues()[4]);
	}
	
	/**
	 * updates the totals for upperscore, uppertotal, lowerscore, and grandtotal for both players
	 */
	public void UpdateTotals()
	{
		int upperScore = myEngine.getPlayerUp().getScoreCard().calculateUpperScore();
		int lowerTotal = myEngine.getPlayerUp().getScoreCard().calculateLowerTotal();
		int upperTotal = myEngine.getPlayerUp().getScoreCard().calculateUpperTotal();
		int grandTotal = myEngine.getPlayerUp().getScoreCard().calculateGrandTotal();
		
		myView.setUpperScores(6, upperScore);
		if( upperScore >=63)
		{
			myView.setUpperScores(7, 35);
		}
		else
		{
			myView.setUpperScores(7, 0);
		}
		myView.setUpperScores(8, upperTotal);
		myView.setLowerScores(7, lowerTotal);
		myView.setLowerScores(8, upperTotal);
		myView.setLowerScores(9, grandTotal);
		
		int upperScoreComp = myComputerPlayer.getScoreCard().calculateUpperScore();
		int lowerTotalComp = myComputerPlayer.getScoreCard().calculateLowerTotal();
		int upperTotalComp = myComputerPlayer.getScoreCard().calculateUpperTotal();
		int grandTotalComp = myComputerPlayer.getScoreCard().calculateGrandTotal();
		
		myView.setUpperScoresComp(6, upperScoreComp);
		if( upperScore >=63)
		{
			myView.setUpperScoresComp(7, 35);
		}
		else
		{
			myView.setUpperScoresComp(7, 0);
		}
		myView.setUpperScoresComp(8, upperTotalComp);
		myView.setLowerScoresComp(7, lowerTotalComp);
		myView.setLowerScoresComp(8, upperTotalComp);
		myView.setLowerScoresComp(9, grandTotalComp);
		
	}
	
	/**
	 * methods that follow fill the corresponding values of the category selected by the player
	 */
	public void fillAces()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.ONES, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.ONES).getValue();
		myView.setUpperCats(0, value);
		this.UpdateTotals();
		
	}
	
	public void fillTwos()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.TWOS, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.TWOS).getValue();
		myView.setUpperCats(1, value);
		this.UpdateTotals();
	}
	
	public void fillThrees()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.THREES, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.THREES).getValue();
		myView.setUpperCats(2, value);
		this.UpdateTotals();
	}
	
	public void fillFours()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.FOURS, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.FOURS).getValue();
		myView.setUpperCats(3, value);
		this.UpdateTotals();
	}
	
	public void fillFives()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.FIVES, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.FIVES).getValue();
		myView.setUpperCats(4, value);
		this.UpdateTotals();
	}
	
	public void fillSixes()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.SIXES, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.SIXES).getValue();
		myView.setUpperCats(5, value);
		this.UpdateTotals();
	}
	
	public void fillThreeOfKind()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.THREE_OF_KIND, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.THREE_OF_KIND).getValue();
		myView.setLowerCats(0, value);
		this.UpdateTotals();
	}
	
	public void fillFourOfKind()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.FOUR_OF_KIND, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.FOUR_OF_KIND).getValue();
		myView.setLowerCats(1, value);
		this.UpdateTotals();
	}
	
	public void fillSmStraight()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.SMALL_STRAIGHT, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.SMALL_STRAIGHT).getValue();
		System.out.println("value: " + value);
		myView.setLowerCats(2, value);
		this.UpdateTotals();
	}
	
	public void fillLgStraight()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.LARGE_STRAIGHT, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.LARGE_STRAIGHT).getValue();
		System.out.print("LgStraightValue: " + value);
		myView.setLowerCats(3, value);
		this.UpdateTotals();
	}
	
	public void fillFullHouse()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.FULL_HOUSE, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.FULL_HOUSE).getValue();
		myView.setLowerCats(4, value);
		this.UpdateTotals();
	}
	
	public void fillYahtzee()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.YAHTZEE, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.YAHTZEE).getValue();
		myView.setLowerCats(5, value);
		this.UpdateTotals();
	}
	
	public void fillChance()
	{
		myEngine.getPlayerUp().getScoreCard().fillCategory(CategoryType.CHANCE, myEngine.getRoller().getDiceValues());
		int value = myEngine.getPlayerUp().getScoreCard().getCategory(CategoryType.CHANCE).getValue();
		myView.setLowerCats(6, value);
		this.UpdateTotals();
	}
	
	
	public int getNumberOfRolls()
	{
		return myEngine.getNumberRollsUsed();
	}
	
	
}
