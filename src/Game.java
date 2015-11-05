import desktop_resources.GUI;

import java.util.Map;
import java.util.HashMap;


public class Game {

	// Variable fields
	private  Player[] player;
	private  DiceCup diceCup;
	private  Field[] field;
	private final static Map<String, String> LANGUAGE = new HashMap<String, String>(); 
	
	private static void setUpStrings()
	{
		LANGUAGE.put("Tower", "Tower and got 250 points");
		LANGUAGE.put("Crater", "Crater and lost 100 points");
		LANGUAGE.put("PalaceGates", "Palace gates and got 100 points");
		LANGUAGE.put("ColdDesert", "Cold Desert and lost 20 points");
		LANGUAGE.put("WalledCity", "Walled city and got 180 points");
		LANGUAGE.put("Monastery", "Monastery and gained nothing");
		LANGUAGE.put("BlackCave", "Black cave and lost 70 points");
		LANGUAGE.put("HutsMT", "Huts in the mountain and got 60 points");
		LANGUAGE.put("Werewall", "The werewall and lost 80 points, but gained an extra turn");
		LANGUAGE.put("Pit", "The pit and lost 50 points");
		LANGUAGE.put("Goldmine", "Goldmine and got 650 points");
		LANGUAGE.put("AskPlayerName", "Player %d write your name");
		LANGUAGE.put("AskForRoll", "%s has to roll");
		LANGUAGE.put("HasRolledAndLAnded", "%s has rolled %d and landed on %s");
		LANGUAGE.put("InvalidTurn", "%s got an invalid roll");
		LANGUAGE.put("InvalidNumber", "%s has rolled %d and is an invalid number");
		LANGUAGE.put("Draw", "It's a draw");
		LANGUAGE.put("Wins", "%s wins");	
	}
	
	// Constructor
	public Game()
	{
		field = new Field[11];
		field[0] = new Field("Tower", LANGUAGE.get("Tower"), 250, false); // 2
		field[1] = new Field("Crater", LANGUAGE.get("Crater"), -100, false); // 3
		field[2] = new Field("Palace gates", LANGUAGE.get("PalaceGates"), 100, false); // 4
		field[3] = new Field("Cold Desert", LANGUAGE.get("ColdDesert"), -20, false); // 5
		field[4] = new Field("Walled city", LANGUAGE.get("WalledCity"), 180, false); // 6
		field[5] = new Field("Monastery", LANGUAGE.get("Monastery"), 0, false); // 7
		field[6] = new Field("Black cave", LANGUAGE.get("BlackCave"), -70, false); // 8
		field[7] = new Field("Huts in the mountain", LANGUAGE.get("HutsMT"), 60, false); // 9
		field[8] = new Field("The werewall", LANGUAGE.get("Werewall"), -80, true); // 10
		field[9] = new Field("The pit", LANGUAGE.get("Pit"), -50, false); // 11
		field[10] = new Field("Goldmine", LANGUAGE.get("Goldmine"), 650, false); // 12
		
		diceCup = new DiceCup(); // create the DiceCup, and the first roll
		
		// Create the 2 players
		player = new Player[2];
		
		for (int i = 0; i < player.length; i++)
		{
			String name = GUI.getUserString(String.format(LANGUAGE.get("AskPlayerName"), i + 1));
			player[i] = new Player(name);
			GUI.addPlayer(player[i].getName(), player[i].getBalance());			
		}
	}
	
	private void run()
	{
		// Game logic
		while(true)
		{
			for(Player p: player)
			{								
				String askRoll = GUI.getUserButtonPressed(String.format(LANGUAGE.get("AskForRoll"), p.getName()), "Roll");
				if(askRoll.compareTo("Roll") == 0)
				{
					boolean isExtra = false;
					boolean validTurn = false;
					do 
					{
						diceCup.roll();
						GUI.setDice(diceCup.getDiceValues()[0], diceCup.getDiceValues()[1]);	
						if(field.length+1 >= diceCup.getDiceSum())
						{
							Field currentfield = field[diceCup.getDiceSum() - 2];
							validTurn = currentfield.land(p);
							isExtra = currentfield.isExtraTurn();									
							GUI.setBalance(p.getName(), p.getBalance());
							if(validTurn)
								GUI.displayChanceCard(String.format(LANGUAGE.get("HasRolledAndLAnded"), p.getName(), diceCup.getDiceSum(), currentfield.getDescription()));
							else
								GUI.displayChanceCard(String.format(LANGUAGE.get("InvalidTurn"), p.getName()));
						}
						else
							GUI.displayChanceCard(String.format(LANGUAGE.get("InvalidNumber"), p.getName(), diceCup.getDiceSum()));
					} while (isExtra && validTurn);						
				}					
			}	

			if (player[0].isWinner() && player[1].isWinner())
			{
				GUI.showMessage(LANGUAGE.get("Draw"));
				break;
			}
			else if (player[0].isWinner())
			{
				GUI.showMessage(String.format(LANGUAGE.get("Wins"), player[0].getName()));
				break;
			}
			else if (player[1].isWinner())
			{	
				GUI.showMessage(String.format(LANGUAGE.get("Wins"), player[1].getName()));
				break;
			}
		}
	}
	

	
	public static void main(String[] args) 
	{
		setUpStrings();
		
		Game game = new Game(); 	
		game.run();
		
		GUI.close();
	}
}

