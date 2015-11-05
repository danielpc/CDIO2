
public class Player {

	// Variable fields
	private String name;
	private Account account;
	
	// Constructor
	public Player(String name)
	{
		this.name = name;
		account = new Account();
	}
	
	// getters
	public String getName(){ return name; }
	public int getBalance() {return account.getBalance(); }
	
	// method
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
	
	public boolean isWinner()
	{
		return this.getBalance() >= 3000;
	}
}