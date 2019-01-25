package Input;

import java.util.ArrayList;
import java.util.HashMap;

public class BusRouteBuffer
{
	HashMap<String, ArrayList<String>> cityToBusRoutes;
	static BusRouteBuffer busRouteBuffer;
	private String busScheduleURL = "https://www.communitytransit.org/busservice/schedules/";
	
	public static BusRouteBuffer getInstance()
	{
		if(busRouteBuffer == null)
		{
			busRouteBuffer = new BusRouteBuffer();
		}
		
		return busRouteBuffer;
	}
	
	public BusRouteBuffer()
	{
		cityToBusRoutes = getCityToBusRoutesFromURL(busScheduleURL);
	}
	
	private HashMap<String,ArrayList<String>> getCityToBusRoutesFromURL(String scheduleURL)
	{
		HashMap<String, ArrayList<String>> cityBusRoutes = new HashMap<>();
		
		int group = 1;
		String regex = "(<h3>.*?</h3>[\\s\\S]*?)(<hr|<p)";
		ArrayList<String> cityRoutesHTMLChunks = RegexGetList.getStringsFromURL(scheduleURL, regex, group);
		
		for(String chunk : cityRoutesHTMLChunks)
		{
			group = 1;
			regex = "<h3>(.*?)</h3>";
			String city = RegexGetList.getStringsFromText(chunk, regex, group).get(0);
			
			group = 1;
			regex = "<a href=.*?>(\\d*).*?</a>";
			ArrayList<String> routes = RegexGetList.getStringsFromText(chunk, regex, group);
			
			cityBusRoutes.put(city, routes);
		}
		
		return cityBusRoutes;
	}
	
	public static void main(String[] args) throws Exception
	{
		new BusRouteBuffer();
		//String html = RegexGetList.load("https://www.communitytransit.org/busservice/schedules/");
		//System.out.println(html);
	}
	
	public void printHashMap(HashMap<String, ArrayList<String>> cityRoutes)
	{
		for(String key : cityRoutes.keySet())
		{
			System.out.println(key);
			
			for(String route : cityRoutes.get(key))
			{
				System.out.println("\t" + route);
			}
		}
	}
	
	public ArrayList<String> getCities()
	{
		ArrayList<String> cities = new ArrayList<>();
		cities.addAll(cityToBusRoutes.keySet());
		return cities;
	}
	
	public ArrayList<String> getRoutes(String city)
	{
		return cityToBusRoutes.get(city);
	}
	
	public String getLink(String route)
	{
		return busScheduleURL + "route/" + route;
	}
}
