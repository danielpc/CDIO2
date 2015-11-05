
public class Dice {
	
	// Variable fields
	private int value;
	private int sides;
	
	// Constructor
	public Dice(int sides)
	{
		this.sides = sides;
		roll();
	}

	// Getters
	public int getValue() { return value; }

	// Methods
	public void roll()
	{
		value = (int)(sides * Math.random()) + 1;
	}	
}