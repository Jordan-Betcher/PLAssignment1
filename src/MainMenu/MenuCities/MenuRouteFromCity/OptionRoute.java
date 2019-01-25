package MainMenu.MenuCities.MenuRouteFromCity;

import Input.BusRouteBuffer;
import Input.InputConsole;
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
		String regex = "(<label class=\"btn btn-default Trip.*?\">" +
				"[\\s\\S]*?/>" +
				"([\\s\\S]*?)" +
				"</label>)";
		ArrayList<String> destinations = RegexGetList.getStringsFromText(html, regex, group);
		
		group = 2;
		regex = "(<th class=\"text-center\">" +
				"[\\s\\S]*?" +
				"<strong class=\"fa fa-stack-1x\">" +
				"(\\d*)" +
				"</strong>" +
				"[\\s\\S]" +
				"*?" +
				"<p>([\\s\\S]*?)</p>)";
		ArrayList<String> stops = RegexGetList.getStringsFromText(html, regex, 2);
		ArrayList<String> stopNames = RegexGetList.getStringsFromText(html, regex, 3);
		
		System.out.println("+++++++++++++++++++++++++++++++++++");
		String destination = destinations.get(0).trim();
		String nextDestination = destinations.get(1).trim();
		System.out.println("Destination: " + destination);
		boolean firstRunning = true;
		for(int index = 0; index < stops.size(); index++)
		{
			String stop = stops.get(index).trim();
			String stopName = stopNames.get(index).trim();
			System.out.println("Stop number: " + stop + " is " + stopName);
			
			
			if(stopName.contains(destination.substring(3)) && firstRunning)
			{
				System.out.println("+++++++++++++++++++++++++++++++++++");
				System.out.println("Destination: " + nextDestination);
				firstRunning = false;
			}
			
			if(stopName.contains(nextDestination.substring(3)) && !firstRunning)
			{
				break;
			}
		}
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("Press Enter to Continue...");
		InputConsole.getInput();
	}
	
	public static void main(String[] args)
	{
		OptionRoute routeOption = new OptionRoute("532");
		routeOption.run();
	}
}
