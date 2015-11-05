
public class Field {

	// Variable fields
	private String name;
	private String description;
	private int reward;
	private boolean extraTurn;
	
	// Constructor
	public Field(String name, String description, int reward, boolean extraTurn)
	{
		this.name = name;
		this.description = description;
		this.reward = reward;
		this.extraTurn = extraTurn;
	}	
	
	// getters
	public boolean isExtraTurn() { return extraTurn; }
	public String getDescription() { return description; }

	// Methods
	public boolean land(Player p)
	{
		return p.changeBalance(this.reward);		
	}
}
