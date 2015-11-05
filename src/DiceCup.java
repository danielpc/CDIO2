import java.util.Arrays;

public class DiceCup {

	// Variable fields
	private Dice[] dices;
	

	/**
	 * Creates a dicecup containing 2 dices, which are 6-sided
	 */
	public DiceCup()
	{
		dices = new Dice[]{new Dice(6), new Dice(6)};
	}
	
	/**
	 * Foreach dice it will add the value together and return the sum
	 * @return the sum of all the dices in the dicecup
	 */
	public int getDiceSum()
	{
		int result = 0;
		for(Dice d: dices)
		{
			result += d.getValue();
		}		
		
		return result;
	}
	
	/**
	 * Foreach dice, it will add the dice value to an array
	 * @return an array with each dice value 
	 */
	public int[] getDiceValues()
	{
		int[] result = new int[dices.length];
		for(int i = 0; i < dices.length; i++)
		{
			result[i] = dices[i].getValue();
		}
		return result;
	}
	
	/**
	 * Foreach dice in the dicecup, it will assign a new random value
	 */
	public void roll()
	{
		for(Dice d: dices)
		{
			d.roll();
		}
	}		
}