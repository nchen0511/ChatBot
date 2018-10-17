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
		System.out.println("Welcome to the chatbot, nice to meet you. Please pick a number from 1 ~ 4.");


		while (true)
		{
			//Use Logic to control which chatbot is handling the conversation\
			//This example has only chatbot1
			String statement = in.nextLine();
			if(statement.contains("1")){
				chatbot1.chatLoop(statement);
			} else if(statement.contains("2")) {
				chatbotDego.chatLoop(statement);
			} else if(statement.contains("3")){
				chatbot3.chatLoop(statement);
			} else if(statement.contains("4")){
				chatbot4.chatLoop(statement);
			} else {
				System.out.println("Please pick a number from 1 ~ 4.");
			}
		}
	}

}
