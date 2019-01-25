package MainMenu;

import MainMenu.MenuCities.MenuCities;
import Menu.MenuListOptions;
import Menu.Option;

public class OptionChooseCityMenu extends Option
{
	public OptionChooseCityMenu()
	{
		super("Search by City");
	}
	
	@Override
	public void run()
	{
		MenuListOptions cityMenu = new MenuCities();
		cityMenu.run();
	}
}
