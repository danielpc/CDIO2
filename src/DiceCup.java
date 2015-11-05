import java.util.Arrays;

public class DiceCup {

	// Variable fields
	private Dice[] dices;
	
	// Constructor
	public DiceCup()
	{
		dices = new Dice[]{new Dice(6), new Dice(6)};
	}
	
	// Getters
	public int getDiceSum()
	{
		int result = 0;
		for(Dice d: dices)
		{
			result += d.getValue();
		}		
		
		return result;
	}

	public int[] getDiceValues()
	{
		int[] result = new int[dices.length];
		for(int i = 0; i < dices.length; i++)
		{
			result[i] = dices[i].getValue();
		}
		return result;
	}
	
	// Methods
	public void roll()
	{
		for(Dice d: dices)
		{
			d.roll();
		}
	}		
}