import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBotChen chatbot1 = new ChatBotChen();
		ChatBotDego chatbotDego = new ChatBotDego();
		ChatBotCox chatbot3 = new ChatBotCox();
		ChatBotJohan chatbot4 = new ChatBotJohan();


		Scanner in = new Scanner (System.in);
		System.out.println("Hi, nice to meet you, I'm the Halloween Witch Bot. What do you want to do, you can go on an \"adventure\" or we can just \"talk\".");


		while (true)
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example has only chatbot1
			String statement = in.nextLine();
			if(statement.contains("adventure")){
				System.out.println("What do want to do, you can go \"trick-or-treating\", you can spend your halloween in a \"fantasy world\" or you can try to \"escape a serial killer\".");
				statement = in.nextLine();
				if (statement.contains("trick-or-treating"))
					chatbot3.chatLoop(statement);
				else if (statement.contains("fantasy"))
					chatbot1.chatLoop(statement);
				else if (statement.contains("escape")||statement.contains("killer")||statement.contains("murderer"))
					chatbot4.chatLoop(statement);
				else
					System.out.println("Please choose one of the adventures");
			} else if(statement.contains("talk")) {
				chatbotDego.chatLoop(statement);
			} else {
				System.out.println("Please choose either talking or going on an adventure.");
			}
		}
	}

}
