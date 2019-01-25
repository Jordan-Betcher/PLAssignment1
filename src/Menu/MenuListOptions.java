package Menu;

import Input.InputConsole;

import java.util.ArrayList;

public abstract class MenuListOptions
{
	protected abstract void printIntro();
	
	boolean running = true;
	private ArrayList<Option> options = new ArrayList<Option>();
	
	public void addOption(Option option)
	{
		options.add(option);
	}
	
	public void run()
	{
		running = true;
		
		while (running)
		{
			printIntro();
			printOptions();
			Option option = askForOption();
			
			System.out.println(FormatFirstLetterCapitilizedRestLowerCase(option.getDescription()));
			option.run();
		}
	}
	
	private void printOptions()
	{
		for (int index = 0; index < options.size(); index++)
		{
			Option option = options.get(index);
			
			System.out.print(index + 1);
			System.out.print(". ");
			
			System.out.print(FormatFirstLetterCapitilizedRestLowerCase(option.getDescription()));
			
			System.out.println();
		}
	}
	
	private Option askForOption()
	{
		boolean askingAgain = false;
		int optionNumber = 0;
		Option optionReturn;
		
		do
		{
			askingAgain = false;
			System.out.print("Please enter an option number: ");
			String input = InputConsole.getInput();
			
			try
			{
				optionNumber = Integer.parseInt(input);
				if (optionNumber - 1 < 0 || optionNumber > options.size())
				{
					askingAgain = true;
				}
				else
				{
					return options.get(optionNumber - 1);
				}
			}
			catch (Exception exception)
			{
				askingAgain = true;
			}
			
			ArrayList<Option> optionOptions = new ArrayList<>();
			for(Option option : options)
			{
				String description = option.getDescription().toLowerCase();
				if(description.contains(input.toLowerCase().trim()))
				{
					optionOptions.add(option);
				}
			}
			
			if(optionOptions.size() == 1)
			{
				return optionOptions.get(0);
			}
			
		} while (true);
		
	}
	
	public static String FormatFirstLetterCapitilizedRestLowerCase(String sentance)
	{
		if(sentance == null)
		{
			return "";
		}
		
		if(sentance.length() < 1)
		{
			return "";
		}
		
		String finalSentance = "";
		String[] words = sentance.split(" ");
		for(String word : words)
		{
			String firstLetterCaptilized = word.substring(0, 1).toUpperCase();
			String restOfWordLowerCase = word.substring(1, word.length()).toLowerCase();
			String newWord = firstLetterCaptilized + restOfWordLowerCase;
			finalSentance += newWord + " ";
		}
		
		finalSentance.trim();
		
		return finalSentance;
	}
	
	public void stop()
	{
		running = false;
	}
	
}
