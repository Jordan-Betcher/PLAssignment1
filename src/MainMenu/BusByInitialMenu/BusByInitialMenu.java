package MainMenu.BusByInitialMenu;

import Input.RegexGetList;
import Menu.MenuListOptions;
import Menu.OptionQuit;

import java.util.ArrayList;

public class BusByInitialMenu extends MenuListOptions
{
	String initial;
	
	public BusByInitialMenu(String initial)
	{
		this.initial = initial;
		ArrayList<String> citiesWithInitial = getCitiesWithInitialFromBusSchedule();
		
		for(String city : citiesWithInitial)
		{
			this.addOption(new OptionGetBusByCity(city));
		}
		
		this.addOption(new OptionQuit("Return to Main Menu", this));
	}
	
	private ArrayList<String> getCitiesWithInitialFromBusSchedule()
	{
		ArrayList<String> cities = new ArrayList<String>();
		try
		{
			String url = "https://www.communitytransit.org/busservice/schedules/";
			String regex = "<h3>(" + initial + "|" + initial.toUpperCase() +".*?)</h3>";
			int group = 1;
			cities = RegexGetList.getStringsFromURL(url, regex, group);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return cities;
	}
	
	@Override
	protected void printIntro()
	{
		System.out.println("Below are the list of Cities that start with the letter " + initial);
	}
}
