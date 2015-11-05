
public class Account {

	// Variable fields
	private int balance;

	/**
	 * Creates an Account, with a default balance of 3000
	 */
	public Account()
	{
		balance = 1000;
	}
	
	/**
	 * Returns the current balance
	 * @return the balance
	 */
	public int getBalance() { return balance; }

	/**
	 * Returns a boolean, if the player is allowed to withdraw, it will return false he is not 
	 * allowed to withdraw and therefore can't get a negative balance
	 * Will subtract the value from the balance
	 * @param value check if it is allowed
	 * @return a boolean 
	 */
	public boolean withdraw(int value)
	{
		if (balance - value >= 0)
		{
			balance -= value;
			return true;
		}
		else
			balance = 0;
			return false;
	}

	/**
	 * Returns a boolean, will always return. Will add the value to the balance
	 * @param value check if it is allowed
	 * @return a boolean
	 */
	public boolean deposit(int value)
	{
		balance += value;	
		return true;			
	}	
}