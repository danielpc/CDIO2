package spil;

public class Player {

	// Variable fields
	private String name;
	private Account account;
	
	/**
	 * Creates a new player with a name
	 * @param name the name of the player
	 */
	public Player(String name)
	{
		this.name = name;
		account = new Account();
	}
	
	/**
	 * Returns the name of the Player object
	 * @return the Player's name
	 */
	public String getName(){ return name; }
	/**
	 * Returns the corresponding Account object and the balance
	 * @return the Player's current ballance
	 */
	public int getBalance() {return account.getBalance(); }
	
	/**
	 * Returns a boolean, if the value is negative it will withdraw, and if the value is positive it will deposit. It will return true for zero values.
	 * @param value how many points it should add or subtract to the players account
	 * @return
	 */
	public boolean changeBalance(int value)
	{
		if(value == 0) // equal to zero
			return true;
	    else if (value > 0) // positive
	    { 
	    	return account.deposit(value);
	    }
	    else  // negative
	    { 
	    	return account.withdraw(-value);
	    }
	}	
	
	/**
	 * Returns a boolean if the Player is having more then or equal to 3000 points
	 * @return a boolean
	 */
	public boolean isWinner()
	{
		return this.getBalance() >= 3000;
	}
}