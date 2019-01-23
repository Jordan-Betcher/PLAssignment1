package Menu;

public class OptionQuit extends Option
{
	private MenuListOptions menu;
	
	public OptionQuit(String description, MenuListOptions menu)
	{
		super(description);
		this.menu = menu;
	}
	
	@Override
	public void run()
	{
		menu.stop();
	}
	
}
