package Input;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGetList
{
	private static HashMap<String, String> urlToHTML = new HashMap<String, String>();
	
	public static String load(String url)
	{
		String text = "";
		
		if(urlToHTML.containsKey(url))
		{
			text = urlToHTML.get(url);
		}
		else
		{
			URL busURL = null;
			try
			{
				busURL = new URL(url);
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			ArrayList<String> htmlLines = null;
			try
			{
				htmlLines = InputURL.getLinesFromURL(busURL);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			for(String line : htmlLines)
			{
				text += line;
				text += "\n";
			}
			
			urlToHTML.put(url, text);
		}
		
		return text;
	}
	
	public static ArrayList<String> getStringsFromURL(String url, String regex, int group)
	{
		ArrayList<String> regexList = new ArrayList<String>();
		
		String text = load(url);
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find())
		{
			regexList.add(matcher.group(group));
		}
		
		return regexList;
	}
}
