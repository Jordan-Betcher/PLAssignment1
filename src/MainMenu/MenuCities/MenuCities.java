package MainMenu.MenuCities;

import Input.BusRouteBuffer;
import Menu.MenuListOptions;
import Menu.OptionQuit;

import java.util.ArrayList;

public class MenuCities extends MenuListOptions
{
	public MenuCities()
	{
		ArrayList<String> cities = BusRouteBuffer.getInstance().getCities();
		for(String city : cities)
		{
			this.addOption(new OptionGetRoutesFromCity(city));
		}
		this.addOption(new OptionQuit("Return to Main Menu", this));
		
	}
	
	@Override
	protected void printIntro()
	{
		System.out.println("Please choose a city");
	}
}
