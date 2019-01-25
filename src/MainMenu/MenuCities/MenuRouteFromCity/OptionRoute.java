package MainMenu.MenuCities.MenuRouteFromCity;

import MainMenu.MainMenu;
import Menu.Option;

public class OptionRoute extends Option
{
	String route;
	public OptionRoute(String route)
	{
		super(route);
		this.route = route;
	}
	
	@Override
	public void run()
	{
		System.out.println("Route: " + route + " ran");
	}
}
