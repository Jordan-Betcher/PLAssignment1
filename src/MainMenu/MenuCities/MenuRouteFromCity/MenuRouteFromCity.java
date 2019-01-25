package MainMenu.MenuCities.MenuRouteFromCity;

import Input.BusRouteBuffer;
import Menu.MenuListOptions;

import java.util.ArrayList;

public class MenuRouteFromCity extends MenuListOptions
{
	String city;
	public MenuRouteFromCity(String city)
	{
		super();
		this.city = city;
		ArrayList<String> routes = BusRouteBuffer.getInstance().getRoutes(city);
		for(String route : routes)
		{
			this.addOption(new OptionRoute(route));
		}
	}
	
	@Override
	protected void printIntro()
	{
		System.out.println("Please choose a route from " + city);
	}
}
