package spil;
import desktop_resources.GUI;

import java.util.Map;
import java.util.HashMap;


public class Game {

	// Variable fields
	private  Player[] player;
	private  DiceCup diceCup;
	private  Field[] field;
	private final static Map<String, String> LANGUAGE = new HashMap<String, String>(); 
	
	/**
	 * Sets up the text for each text field. Makes it easier to change the text. 
	 */
	private static void setUpStrings()
	{
		LANGUAGE.put("Tower", "Du er nu oven på et tårn, og selvdom det ikke giver mening, får du nu 250. Ses.");
		LANGUAGE.put("Crater", "Du faldt ned i et krater. Oobs? -100 faggot.");
		LANGUAGE.put("PalaceGates", "Du står foran palads-porten og tigger. Du tjener 100 dit fucking tigger-svin.");
		LANGUAGE.put("ColdDesert", "Det er meget koldt, og 20 af dine hårdt-tjente penge fryser til is og knækker over på midten.");
		LANGUAGE.put("WalledCity", "Du er nu tryg i den bemurede by, og du sælger dit tøj for 180");
		LANGUAGE.put("Monastery", "Velkommen til stilhedens zone. Intet sker.");
		LANGUAGE.put("BlackCave", "Den sorte grotte er meget mørk. Du taber 70 og kan ikke finde dem igen.");
		LANGUAGE.put("HutsMT", "Clegane 'The Mountain' er sød ved dig, du får 60.");
		LANGUAGE.put("Werewall", "Varulvene flækker dig midt over. Du mister 80.");
		LANGUAGE.put("Pit", "Du er faldet i 'The Pit' og får banket 50 ud af dig. Svans.");
		LANGUAGE.put("Goldmine", "Du har fundet guld i bjergene og sælger det for 650, du er rig!");
		LANGUAGE.put("AskPlayerName", "Spiller %d oplys dit navn");
		LANGUAGE.put("AskForRoll", "%s" + ", din tur");
		LANGUAGE.put("HasRolledAndLAnded", "%s slog %d: %s");
		LANGUAGE.put("InvalidTurn", "%s det slag er vist ikke muligt");
		LANGUAGE.put("InvalidNumber", "%s slog %d og det må du ikke");
		LANGUAGE.put("Draw", "Det blev uafgjort");
		LANGUAGE.put("Wins", "%s er den store vinder. Tillykke!");	
		LANGUAGE.put("Roll", "Slå");
	}
	
	/**
	 * Creates the Game, with the corresponding fields and sets up 2 players. 
	 */
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
	
	/**
	 * Handles the game logic (switching turns, checking for a winner, etc.).
     * Keeps running until a winner of the game has been found.
	 */
	private void run()
	{
		// Game logic
		while(true)
		{
			for(Player p: player)
			{								
				GUI.getUserButtonPressed(String.format(LANGUAGE.get("AskForRoll"), p.getName()), LANGUAGE.get("Roll"));
				
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
	

	/**
	 * Runs the game. 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		setUpStrings();
		
		Game game = new Game(); 	
		game.run();
		
		GUI.close();
	}
}

