import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotChen {
	//emotion starts at 0, which is neutral, increases as user makes worse choice and the bot's comment will become progressively more sarcastic
	int emotion = 0;

	//gold will be a variable used throughout the adventure
	int gold = 0;

	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 *
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello, welcome to the world of Alfheim. I, C Bot, will be your game master for this session. Throughout this journey you may 𝐨𝐛𝐬𝐞𝐫𝐯𝐞 your surroundings or check your 𝐠𝐨𝐥𝐝 whenever you wish to.");

		//scene 1
		System.out.println("In the small town of Aerodale, it is the day of a holiday known to many as Halloween. What better way is there to celebrate other than to go on a quest? You enter the tavern, filled with many laughter and chatter.");
		while (true) {
			statement = in.nextLine().toLowerCase();

            String[] scene = {"get a quest"};
            String sceneAlt = "The atmosphere is cheerful. There are people talking about something different at every table. In the back of the dining hall is a task board where you may 𝐠𝐞𝐭 𝐚 𝐪𝐮𝐞𝐬𝐭.";
			String r = response(statement,scene);
			if(r.equals("")){
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if(findKeyword(in.nextLine().toLowerCase(),"yes",0)){
					break;
				} else {
					System.out.println("No? Okay.");
				}
			}
			break;
		}

		//scene 2
		System.out.println("One particular quest catches your eye. It is a simple pest control quest. Apparently there was a slime invasion in a remote village nearby, but the reward is oddly exceptional. You decide to take the quest, but it requires a party of 2 members.");
		while (true) {
			statement = in.nextLine().toLowerCase();
			String[] scene = {"hire "};
			String sceneAlt = "You look around, there seems be adventurers gathered at the waiting section, looking for a party. Judging by their appearance, you could tell their class";
		}
	}

	public String checkGold(){
	    return "Your party currently has " + gold + " gold piece(s).";
    }
    public String invalidAction(){
	    return "Please choose a valid action (in bold).";
    }

	public String response(String statement, String[] keyword) {
		for (int i = 0; i < keyword.length; i++) {
			if (findKeyword(statement,keyword[i],0)) {
				return keyword[i];
			}
		}
		return "";
	}

	public void altResponse1(String statement, String sceneAlt){
        if(statement.contains("observe")){
            System.out.println(sceneAlt);
        } else if (statement.contains("gold")){
            System.out.println(checkGold());
        } else {
            System.out.println(invalidAction());
        }
	}

	/**
	 * Take a statement with "I want <something>." and transform it into
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private void transformIWantStatement(String keyword)
	{
		System.out.println("Are you sure you want to " + keyword + "?");
	}
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private boolean findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return false;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return false;
	}


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse ()
	{
		Random r = new Random ();
		if (emotion == 0)
		{	
			return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0)
		{	
			return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
	}
	
	private String [] randomNeutralResponses = {"Interesting, tell me more",
			"Hmmm.",
			"Do you really think so?",
			"You don't say.",
			"It's all boolean to me.",
			"So, would you like to go for a walk?",
			"Could you say that again?",
			"Oh that's just a bunch of boolean."
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	
}
