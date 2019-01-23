package MainMenu.BusByInitialMenu;

import Input.RegexGetList;
import Menu.MenuListOptions;

import java.util.ArrayList;

public class MenuRouteByCity extends MenuListOptions
{
	public MenuRouteByCity(String city)
	{
		String url = "https://www.communitytransit.org/busservice/schedules/";
		String regex = "";
		int group = 1;
		ArrayList<String> routes = RegexGetList.getStringsFromURL(url, regex, group);
	}
	
	@Override
	protected void printIntro()
	{
	
	}
}
