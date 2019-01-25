package MainMenu.MenuCities.MenuRouteFromCity;

import Input.BusRouteBuffer;
import Input.RegexGetList;
import MainMenu.MainMenu;
import Menu.Option;

import java.util.ArrayList;

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
		String routeURL = BusRouteBuffer.getInstance().getLink(route);
		System.out.println("The link for your route is: " + routeURL);
		
		String html = RegexGetList.load(routeURL);
		int group = 2;
		//String regex = "(<label class=\"btn btn-default Trip.*?\">[\\s\\S]*?/>([\\s\\S]*?)</label>)";
		String regex = "(<label class=\"btn btn-default Trip.*?\">[\\s\\S]*?/>([\\s\\S]*?)</label>)";
		ArrayList<String> destinations = RegexGetList.getStringsFromText(html, regex, group);
		
		for(String destination : destinations)
		{
			System.out.println(destination.trim());
		}
	}
	
	public static void main(String[] args)
	{
		OptionRoute routeOption = new OptionRoute("109");
		routeOption.run();
	}
}
