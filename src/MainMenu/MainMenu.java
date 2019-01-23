package MainMenu;

import Menu.MenuListOptions;
import Menu.OptionQuit;

public class MainMenu extends MenuListOptions
{
	public MainMenu()
	{
		this.addOption(new OptionSearchByCityInitial());
		this.addOption(new OptionSearchByBus());
		this.addOption(new OptionQuit("Quit", this));
	}
	
	@Override
	protected void printIntro()
	{
		System.out.println("Below are the ways to finding the bus route of your choice");
		System.out.println("                 Please Enjoy");
	}
}
