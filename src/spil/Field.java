package spil;

public class Field {

	// Variable fields
	private String name;
	private String description;
	private int reward;
	private boolean extraTurn;
	
	/**
	 * Creates a Field object
	 * @param name the name of the field
	 * @param description the description of the field
	 * @param reward how many points should the field reward, you can add negative values
	 * @param extraTurn if the field should give an extra turn
	 */
	public Field(String name, String description, int reward, boolean extraTurn)
	{
		this.name = name;
		this.description = description;
		this.reward = reward;
		this.extraTurn = extraTurn;
	}	
	
	/**
	 * Returns a boolean if the Field is having an extra turn
	 * @return a boolean for extra turn
	 */
	public boolean isExtraTurn() { return extraTurn; }
	
	/**
	 * Returns a String, a description of the current Field object
	 * @return a String 
	 */
	public String getDescription() { return description; }

	/**
	 * Returns a boolean, if the player is landing on a legal field. 
	 * It will return false if he can't withdraw or deposit on the current Field.
	 * @param p a Player object. 
	 * @return a boolean, if the player landed on a valid Field and is allowed to withdraw or deposit
	 */
	public boolean land(Player p)
	{
		return p.changeBalance(this.reward);		
	}
}
