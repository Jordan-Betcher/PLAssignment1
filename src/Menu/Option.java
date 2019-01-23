package Menu;

public abstract class Option
{
	protected String description;
	
	public Option(String description)
	{
		this.description = description;
	}
	
	public abstract void run();
	
	public String getDescription()
	{
		return description;
	}
}
