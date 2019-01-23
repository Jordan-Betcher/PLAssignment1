package MainMenu;

import Input.InputConsole;
import MainMenu.BusByInitialMenu.BusByInitialMenu;
import Menu.Option;

public class OptionSearchByCityInitial extends Option
{
	public OptionSearchByCityInitial()
	{
		super("Search by City Initial");
	}
	
	@Override
	public void run()
	{
		System.out.print("Please enter a city's initial: ");
		String input = InputConsole.getInput();
		input = input.substring(0,1).toLowerCase();
		new BusByInitialMenu(input).run();
	}
}
