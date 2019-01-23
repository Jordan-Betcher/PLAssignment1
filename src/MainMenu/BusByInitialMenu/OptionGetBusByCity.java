package MainMenu.BusByInitialMenu;

import Menu.Option;

public class OptionGetBusByCity extends Option
{
	String city;
	
	public OptionGetBusByCity(String city)
	{
		super(city);
		this.city = city;
	}
	
	@Override
	public void run()
	{
		new MenuRouteByCity(city).run();
		
		
	}
}
