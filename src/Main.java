import Input.RegexGetList;
import MainMenu.MainMenu;

public class Main
{
	
	public static void main(String[] args) throws Exception
	{
		RegexGetList.load("https://www.communitytransit.org/busservice/schedules/");
		
		new MainMenu().run();
	}
}
