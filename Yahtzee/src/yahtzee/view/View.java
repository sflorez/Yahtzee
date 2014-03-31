package yahtzee.view;

import java.awt.*;
import java.lang.reflect.Method;

import javax.swing.*;

import yahtzee.buttonlistener.ButtonListener;
import yahtzee.controller.Controller;




public class View extends JFrame{

	public static Dimension windowSize;
	
	
	private JButton die1, die2, die3, die4, die5, roll , rollSome , startGame, nextTurn;
	private JButton[] dice = { die1, die2, die3, die4, die5};
	private String[] diceImgs = { "Dice1", "Dice2", "Dice3", "Dice4", "Dice5", "Dice6"};
	private String[] categoriesUpper = { "Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "TotalScore" , "Bonus", "TotalUpper"};
	private String[] categoriesLower = { "3 Of Kind", "4 Of Kind", "Sm.Straight", "Lg.Straight", "FullHouse", "Yahtzee", "Chance" , 
			"TotalLower" ,"TotalUpper", "GrandTotal"};
	private JButton aces, twos, threes, fours, fives, sixes, totalScore, bonus, total, threeKind, fourKind, smStaight,
	lgStraight, fullHouse, yahtzee, chance , totalUpper, totalLower, grandTotal;
	private JButton[] categoriesUp = { aces, twos, threes, fours, fives, sixes, totalScore, bonus, total};
	private JButton[] categoriesLow = {threeKind, fourKind, smStaight, lgStraight, fullHouse, yahtzee, chance ,
			totalUpper, totalLower, grandTotal};
	private JTextField field1, field2, field3, field4, field5 , field6, field7, field8, field9, 
			field19 , field20 , field21 , field22, field23, field24, field25, field26, field27 , field28, field29,
			field30, field31, field32, field33, field34, field35;
	private JTextField[] fieldsUp = {field1, field2, field3, field4 ,field5 , field6, field7, field8 , field9 };
	
	private JTextField field10, field11, field12, field13, field14 , field15, field16, field17, field18 , field36, field37, field38;
	private JTextField[] fieldsLow= { field10, field11, field12, field13, field14 , field15, field16, field17, field18, field36,
			};
	private JTextField[] fieldsUp2 = {field19 , 
			field20 , field21 , field22, field23, field24, field25, field26, field27 };
	private JTextField[] fieldsLow2 = {field28, field29,field30, field31, field32, field33, field34, field35 , field37, field38};
	private int boundX = 100 , boundY = -60;
	private int boundY2 = 20, boundY3 = 250 , boundY4 = 20, boundY5 = 250 , boundY6 = 20, boundY7 = 250;
	private JLabel upperCatHeader, LowerCatHeader , playerName, computerName, rollsUsed;
	private Controller myController;
	private ButtonListener myRollListener , myFirstDieListener , mySecondDieListener, myThirdDieListener ,myFourthDieListener
							, myFifthDieListener, myRollSomeListener, myAcesListener, myTwosListener, myThreesListener
							,myFoursListener, myFivesListener, mySixesListener, myThreeOfKindListener, myFourOfKindListener,
							myFullHouseListener, mySmStraightListener, myLgStraightListener, myYahtzeeListener, myChanceListener
							, myStartGameListener, myNextTurnListener;
	private Color myColor;
	private boolean[] dieSelected = {false, false , false , false, false , false}; 
	private int turns = 0;
	
	public View( Controller controller){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		windowSize = toolkit.getScreenSize();
		
		int windowX = windowSize.width/2 ;
		int windowY = windowSize.height -200;
		int windowXloc = windowSize.width/2 - 400;
		int windowYloc = windowSize.height/2 - 250;
		
		this.setSize(windowX, windowY);
		this.setLocation(windowXloc, windowYloc);
		this.setTitle("Yahtzee");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		myController = controller;
		
		this.associateListeners();
		
		roll = new JButton("Roll");
		rollSome = new JButton("Roll Some");
		startGame = new JButton("Start Game");
		nextTurn = new JButton("Next Turn");
		playerName = new JLabel("Sebastian");
		computerName = new JLabel ("Computer");
		rollsUsed = new JLabel("Rolls Used : " + controller.getNumberOfRolls());
		
		myColor = roll.getBackground();
		
		roll.addMouseListener(myRollListener);
		rollSome.addMouseListener(myRollSomeListener);
		startGame.addMouseListener(myStartGameListener);
		nextTurn.addMouseListener(myNextTurnListener);
		
		
		Color color = new Color( 150, 255, 150);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(color);
		contentPane.add(roll);
		contentPane.add(rollSome);
		contentPane.add(startGame);
		contentPane.add(nextTurn);
		contentPane.add(rollsUsed);
		contentPane.add(playerName);
		contentPane.add(computerName);
		
		roll.setBounds(boundX , 400, 70, 30);
		rollSome.setBounds(boundX -15, 430, 100, 30);
		startGame.setBounds(boundX -75, 470, 100, 30 );
		nextTurn.setBounds(boundX + 50, 470, 100, 30);
		playerName.setBounds(boundX + 325, boundY2 - 10, 100, 50);
		computerName.setBounds(boundX + 390, boundY2 -10, 100, 50);
		
		
		

		for( int i = 0; i < dice.length ; i ++)
		{
			dice[i] = new JButton( new ImageIcon(diceImgs[i] + ".png"));
			contentPane.add(dice[i]);
			boundY += 75;
			dice[i].setBounds(boundX, boundY , 75, 75);
		}
		
		dice[0].addMouseListener(myFirstDieListener);
		dice[1].addMouseListener(mySecondDieListener);
		dice[2].addMouseListener(myThirdDieListener);
		dice[3].addMouseListener(myFourthDieListener);
		dice[4].addMouseListener(myFifthDieListener);
		

		for( int i = 0; i < categoriesUpper.length ; i ++)
		{
			categoriesUp[i] = new JButton(categoriesUpper[i] );
			categoriesUp[i].setBorderPainted(false);
			contentPane.add(categoriesUp[i]);
			boundY2 += 25;
			categoriesUp[i].setBounds(boundX +220 , boundY2, 98, 20);
		}
		
		categoriesUp[0].addMouseListener(myAcesListener);
		categoriesUp[1].addMouseListener(myTwosListener);
		categoriesUp[2].addMouseListener(myThreesListener);
		categoriesUp[3].addMouseListener(myFoursListener);
		categoriesUp[4].addMouseListener(myFivesListener);
		categoriesUp[5].addMouseListener(mySixesListener);
				
		
		for( int i = 0; i < categoriesLower.length ; i ++)
		{
			categoriesLow[i] = new JButton(categoriesLower[i] );
			categoriesLow[i].setBorderPainted(false);
			contentPane.add(categoriesLow[i]);
			boundY3 += 25;
			categoriesLow[i].setBounds(boundX +220 , boundY3, 103, 20);
		}
		
		categoriesLow[0].addMouseListener(myThreeOfKindListener);
		categoriesLow[1].addMouseListener(myFourOfKindListener);
		categoriesLow[2].addMouseListener(mySmStraightListener);
		categoriesLow[3].addMouseListener(myLgStraightListener);
		categoriesLow[4].addMouseListener(myFullHouseListener);
		categoriesLow[5].addMouseListener(myYahtzeeListener);
		categoriesLow[6].addMouseListener(myChanceListener);
		
		for( int i = 0; i < categoriesUpper.length ; i ++)
		{
			fieldsUp[i] = new JTextField();
			fieldsUp[i].setEditable(false);
			contentPane.add(fieldsUp[i]);
			boundY4 += 25;
			fieldsUp[i].setBounds(boundX + 335, boundY4, 40, 20);
			
		}
		
		for( int i = 0; i < fieldsLow.length  ; i ++)
		{
			fieldsLow[i] = new JTextField();
			fieldsLow[i].setEditable(false);
			contentPane.add(fieldsLow[i]);
			boundY5 += 25;
			fieldsLow[i].setBounds(boundX + 335, boundY5, 40, 20);
		}
		
		for( int i = 0; i < fieldsUp2.length ; i ++)
		{
			fieldsUp2[i] = new JTextField();
			fieldsUp2[i].setEditable(false);
			contentPane.add(fieldsUp2[i]);
			boundY6 += 25;
			fieldsUp2[i].setBounds(boundX + 400, boundY6, 40, 20);
			
		}
		
		for( int i = 0; i < fieldsLow2.length ; i ++)
		{
			fieldsLow2[i] = new JTextField();
			fieldsLow2[i].setEditable(false);
			contentPane.add(fieldsLow2[i]);
			boundY7 += 25;
			fieldsLow2[i].setBounds(boundX + 400, boundY7, 40, 20);
			
		}
		
		
		this.setVisible(true);
	
	}
	
	public void associateListeners()
	{
		String error;
		Class<? extends Controller> controllerClass;
		Method rollMethod, firstDieMethod, secondDieMethod, thirdDieMethod, fourthDieMethod, fifthDieMethod
				, rollSomeMethod, acesMethod, twosMethod, threesMethod, foursMethod, fivesMethod, sixesMethod
				, smStraightMethod, lgStraightMethod, fourOfKindMethod, threeOfKindMethod, fullHouseMethod, yahtzeeMethod, 
				chanceMethod , startGameMethod, nextTurnMethod;
		
		Class<?>[] classArgs;
		Integer[] args;
		
		controllerClass = myController.getClass();
		
		error = null;
		rollMethod = null;
		firstDieMethod = null;
		secondDieMethod = null;
		thirdDieMethod = null;
		fourthDieMethod = null;
		fifthDieMethod = null;
		rollSomeMethod = null;
		acesMethod = null;
		twosMethod = null;
		threesMethod = null;
		foursMethod = null;
		fivesMethod = null;
		sixesMethod = null;
		threeOfKindMethod = null;
		fourOfKindMethod = null;
		fullHouseMethod = null;
		smStraightMethod = null;
		lgStraightMethod = null;
		yahtzeeMethod = null;
		chanceMethod = null;
		startGameMethod = null;
		nextTurnMethod = null;
		
		
		classArgs = new Class[1];
		args = new Integer[1];
		
		try
		{
			classArgs[0] = Class.forName("java.lang.Integer");
			
		}
		catch(ClassNotFoundException exception)
		{
			error = exception.toString();
			System.out.println(error);
		}
		
		
			try 
			{
				rollMethod = controllerClass.getMethod("roll", (Class<?>[]) null);
				firstDieMethod = controllerClass.getMethod("firstDieSelected", (Class<?>[]) null);
				secondDieMethod = controllerClass.getMethod("secondDieSelected", (Class<?>[]) null);
				thirdDieMethod = controllerClass.getMethod("thirdDieSelected", (Class<?>[]) null);
				fourthDieMethod = controllerClass.getMethod("fourthDieSelected", (Class<?>[]) null);
				fifthDieMethod = controllerClass.getMethod("fifthDieSelected", (Class<?>[]) null);
				rollSomeMethod = controllerClass.getMethod("rollSome", (Class<?>[]) null);
				acesMethod = controllerClass.getMethod("fillAces", (Class<?>[])null);
				twosMethod = controllerClass.getMethod("fillTwos", (Class<?>[])null);
				threesMethod = controllerClass.getMethod("fillThrees", (Class<?>[])null);
				foursMethod = controllerClass.getMethod("fillFours", (Class<?>[])null);
				fivesMethod = controllerClass.getMethod("fillFives", (Class<?>[])null);
				sixesMethod = controllerClass.getMethod("fillSixes", (Class<?>[])null);
				threeOfKindMethod = controllerClass.getMethod("fillThreeOfKind", (Class<?>[])null);
				fourOfKindMethod = controllerClass.getMethod("fillFourOfKind", (Class<?>[])null);
				fullHouseMethod = controllerClass.getMethod("fillFullHouse", (Class<?>[])null);
				smStraightMethod = controllerClass.getMethod("fillSmStraight", (Class<?>[])null);
				lgStraightMethod = controllerClass.getMethod("fillLgStraight", (Class<?>[])null);
				yahtzeeMethod = controllerClass.getMethod("fillYahtzee", (Class<?>[])null);
				chanceMethod = controllerClass.getMethod("fillChance", (Class<?>[])null);
				startGameMethod = controllerClass.getMethod("startGame", (Class<?>[])null);
				nextTurnMethod = controllerClass.getMethod("nextTurn", (Class<?>[])null);
				
			} 
			catch (NoSuchMethodException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (SecurityException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			myRollListener = new ButtonListener(myController, rollMethod, null);
			myFirstDieListener = new ButtonListener(myController, firstDieMethod, null);
			mySecondDieListener= new ButtonListener(myController, secondDieMethod, null);
			myThirdDieListener = new ButtonListener(myController, thirdDieMethod, null);
			myFourthDieListener = new ButtonListener(myController, fourthDieMethod, null);
			myFifthDieListener = new ButtonListener(myController, fifthDieMethod, null);
			myRollSomeListener = new ButtonListener(myController, rollSomeMethod, null);
			myAcesListener = new ButtonListener(myController, acesMethod, null);
			myTwosListener = new ButtonListener(myController, twosMethod, null);
			myThreesListener = new ButtonListener(myController, threesMethod, null);
			myFoursListener = new ButtonListener(myController, foursMethod, null);
			myFivesListener = new ButtonListener(myController, fivesMethod, null);
			mySixesListener = new ButtonListener(myController, sixesMethod, null);
			myThreeOfKindListener = new ButtonListener(myController, threeOfKindMethod, null);
			myFourOfKindListener = new ButtonListener(myController, fourOfKindMethod, null);
			mySmStraightListener = new ButtonListener(myController, smStraightMethod, null);
			myLgStraightListener = new ButtonListener(myController, lgStraightMethod, null);
			myFullHouseListener = new ButtonListener(myController, fullHouseMethod, null);
			myYahtzeeListener = new ButtonListener(myController, yahtzeeMethod, null);
			myChanceListener = new ButtonListener(myController, chanceMethod, null);
			myStartGameListener = new ButtonListener(myController, startGameMethod, null);
			myNextTurnListener = new ButtonListener( myController, nextTurnMethod , null);
					
			
			
	}
	
	public void setDice(int[] values)
	{
		for ( int i = 0 ; i < values.length ; i ++ )
		{
			dice[i].setIcon(new ImageIcon(diceImgs[values[i] -1] + ".png"));
		}
	}
	
	public void setUpperCatBackground( int cat)
	{
		categoriesUp[cat].setBackground(Color.YELLOW);
	}
	
	public void setLowerCatBackground( int cat)
	{
		categoriesLow[cat].setBackground(Color.YELLOW);
	}
	
	public void setUpDefaultBackground( int cat)
	{
		categoriesUp[cat].setBackground(myColor);
	}
	
	public void setLowDefaultBackground ( int cat )
	{
		categoriesLow[cat].setBackground(myColor);
	}
	
	public JButton[] getUpperCats()
	{
		return categoriesUp;
	}
	
	public JButton[] getLowerCats()
	{
		return categoriesLow;
	}
	
	public boolean[] getSelectedDice()
	{
		return dieSelected;
	}
	
	public void setDefaultSelected()
	{
		for ( int i = 0 ; i < dieSelected.length; i ++)
		{
			dieSelected[i] = false;
		}
	}
	
	public void setSelected(int die , int value)
	{
		if( dieSelected[die] == false)
		{
			dice[die].setIcon(new ImageIcon(diceImgs[value -1] + "_Inverted.png"));
			dieSelected[die] = true;
		}
		else
		{
			dice[die].setIcon( new ImageIcon(diceImgs[value -1] + ".png"));
			dieSelected[die] = false;
		}
		
	}
	
	public void setUpperCats( int cat, int value)
	{
		fieldsUp[cat].setText(Integer.toString(value));
		categoriesUp[cat].setEnabled(false);
	}
	
	public void setLowerCats( int cat, int value)
	{
		fieldsLow[cat].setText(Integer.toString(value));
		categoriesLow[cat].setEnabled(false);
	}
	
	public void setUpperCats2( int cat , int value)
	{
		fieldsUp2[cat].setText(Integer.toString(value));
	}
	
	public void setLowerCats2( int cat, int value)
	{
		fieldsLow2[cat].setText(Integer.toString(value));
		
	}
	
	public void setUpperScores( int field, int value)
	{
		fieldsUp[field].setText(Integer.toString(value));
	}
	
	public void setUpperScoresComp( int field , int value)
	{
		fieldsUp2[field].setText(Integer.toString(value));
	}
	
	public void setLowerScores( int field , int value)
	{
		fieldsLow[field].setText(Integer.toString(value));
	}
	
	public void setLowerScoresComp( int field, int value)
	{
		fieldsLow2[field].setText(Integer.toString(value));
	}
	
	public void setPlayerName()
	{
		playerName.setForeground(Color.YELLOW);
	}
	
	public void setPlayerDefault()
	{
		playerName.setForeground(Color.black);
	}
	
	public void setComputerName()
	{
		computerName.setForeground(Color.yellow);
	}
	
	public void setComputerDefault()
	{
		computerName.setForeground(Color.black);
	}
	
	/**
	 * method that increments the number of turns for the game and if the turns are up the winner is decided
	 * 
	 */
	public void incrementTurns()
	{
		if (turns <= 25)
		{
			turns ++;
		}
		else
		{
			int player1 = Integer.parseInt(fieldsLow[9].getText());
			int player2 = Integer.parseInt(fieldsLow2[9].getText());
			if( player1 > player2)
			{
				JOptionPane.showMessageDialog(null, "The Winner is Player1!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The Winner is Player2");
			}
			
		}
	}
	
}
