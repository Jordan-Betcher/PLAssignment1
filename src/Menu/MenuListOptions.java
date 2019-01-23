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
			int optionNumber = askForOptionNumber();
			Option option = options.get(optionNumber - 1);
			
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
	
	private int askForOptionNumber()
	{
		boolean askingAgain = false;
		int optionNumber = 0;
		
		do
		{
			askingAgain = false;
			System.out.print("Please enter an option number: ");
			
			try
			{
				optionNumber = Integer.parseInt(InputConsole.getInput());
			}
			catch (Exception exception)
			{
				askingAgain = true;
			}
			
			if (optionNumber - 1 < 0 || optionNumber > options.size())
			{
				askingAgain = true;
			}
		} while (askingAgain);
		
		return optionNumber;
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
