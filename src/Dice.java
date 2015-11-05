
public class Dice {
	
	// Variable fields
	private int value;
	private int sides;
	
	/**
	 * Creates a x-sided dice
	 * @param sides how many sides the dice should have
	 */
	public Dice(int sides)
	{
		this.sides = sides;
		roll();
	}

	/**
	 * Returns the current value of the dice
	 * @return the value of the dice
	 */
	public int getValue() { return value; }

	/**
	 * Assigns a random value to the dice variable - value
	 */
	public void roll()
	{
		value = (int)(sides * Math.random()) + 1;
	}	
}