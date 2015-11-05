
public class Account {

	// Variable fields
	private int balance;

	// Constructor
	public Account()
	{
		balance = 1000;
	}
	
	// Getters
	public int getBalance() { return balance; }

	// Methods
	public boolean withdraw(int value)
	{
		if (balance - value >= 0)
		{
			balance -= value;
			return true;
		}
		else
			return false;
	}

	public boolean deposit(int value)
	{
		balance += value;	
		return true;			
	}	
}