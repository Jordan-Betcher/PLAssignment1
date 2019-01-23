package Input;

import java.io.IOException;

public class InputConsole
{
	
	public static String getInput()
	{
		try
		{
			StringBuffer buffer = new StringBuffer();
			System.out.flush();
			int c = System.in.read();
			while (c != '\n' && c != -1)
			{
				buffer.append((char) c);
				c = System.in.read();
			}
			return buffer.toString().trim();
		}
		catch (IOException e)
		{
			return "";
		}
	}
}
