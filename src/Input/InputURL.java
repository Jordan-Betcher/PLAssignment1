package Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class InputURL
{
	public static ArrayList<String> getLinesFromURL(URL url) throws Exception
	{
		ArrayList<String> lines = new ArrayList<String>();
		
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("user-Agent"
				, "Mozilla/5.0" +
						" (Windows NT 6.1; WOW64)" +
						" AppleWebKit/537.11" +
						" (KHTML, like Gecko)" +
						" Chrome/23.0.1271.95" +
						" Safari/537.11");
		InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String inputLine = "";
		
		while ((inputLine = bufferedReader.readLine()) != null)
		{
			String line = inputLine + "\n";
			lines.add(line);
		}
		bufferedReader.close();
		
		return lines;
	}
}
