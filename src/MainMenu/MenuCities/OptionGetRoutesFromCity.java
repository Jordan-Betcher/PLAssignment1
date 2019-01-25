package MainMenu.MenuCities;

import MainMenu.MenuCities.MenuRouteFromCity.MenuRouteFromCity;
import Menu.MenuListOptions;
import Menu.Option;

public class OptionGetRoutesFromCity extends Option
{
	String city;
	
	public OptionGetRoutesFromCity(String city)
	{
		super(city);
		this.city = city;
	}
	
	@Override
	public void run()
	{
		MenuListOptions routeMenu = new MenuRouteFromCity(city);
		routeMenu.run();
	}
}
