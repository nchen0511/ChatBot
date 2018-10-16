import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotChen {
	//emotion starts at 0, which is neutral, increases whenever user does not proceed to the next scene, becomes more impatient
	int emotion1 = 0;
	int emotion2 = 0;

	//gold will be a variable used throughout the adventure
	int gold = 20;

	//variables to remember player choices
	boolean hi = false;
	String choice1;
	String scene[];
	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 *
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello, welcome to the world of Alfheim. I, C Bot, will be your game master for this session.");
		System.out.println("Throughout this journey you may 𝐨𝐛𝐬𝐞𝐫𝐯𝐞 your surroundings or check your 𝐠𝐨𝐥𝐝 whenever you wish to.");

		//scene 1
		System.out.println("In the small town of Aerodale, it is the day of a holiday known to many as Halloween. What better way is there to celebrate other than to go on a quest?");
		System.out.println("You enter the tavern, filled with many laughter and chatter.");
		while (true) {
			statement = in.nextLine().toLowerCase();

            String[] scene = {"get a quest"};
            String sceneAlt = "The atmosphere is cheerful. There are people talking about something different at every table. In the back of the dining hall is a task board where you may 𝐠𝐞𝐭 𝐚 𝐪𝐮𝐞𝐬𝐭.";
			String r = response(statement,scene);
			if(r.equals("")){
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if(in.nextLine().toLowerCase().contains("yes")){
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		emotion1 = 0;
		emotion2 = 0;
		//scene 2
		System.out.println("One particular quest catches your eye. It is a simple pest control quest.");
		System.out.println("Apparently there was a slime invasion in a remote village nearby, but the reward is oddly exceptional.");
		System.out.println("You decide to take the quest, but it requires a party of 2 members.");
		while (true) {
			statement = in.nextLine().toLowerCase();
			String[] scene = {"hire knight", "hire priest", "hire mysterious person"};
			String sceneAlt = "You look around, there seems be several adventurers gathered at the waiting section, looking for a party. One bulky man was sitting down and drinking, you could tell he was about to ask for another. He was most likely a knight, but you do not see his sword. Across from him was a priest who seemed shy and timid. Something about her told you she was experienced. Finally, at the corner of the room was a short person whose gender or profession you could not identify. Looks like your choices is to 𝐡𝐢𝐫𝐞 the 𝐤𝐧𝐢𝐠𝐡𝐭, the 𝐩𝐫𝐢𝐞𝐬𝐭, or the 𝐦𝐲𝐬𝐭𝐞𝐫𝐢𝐨𝐮𝐬 𝐩𝐞𝐫𝐬𝐨𝐧";
			String r = response(statement,scene);
			if(r.equals("")){
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if(in.nextLine().toLowerCase().contains("yes")){
					choice1 = r.substring(4);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		emotion1 = 0;
		emotion2 = 0;
		//scene 3
		System.out.println("You offered to pay the " + choice1 + "  10 gold, but they'll only accept it after the job is done");
		System.out.println("After a quick preparation, you head out to the remote village with the " + choice1);
		System.out.println("On the road, your party runs into a wounded soldier. What would you like to do?");
		while (true) {
			statement = in.nextLine().toLowerCase();
			String[] scene = {"hire knight", "hire priest", "hire mysterious person"};
			String sceneAlt = "You look around, there seems be several adventurers gathered at the waiting section, looking for a party. One bulky man was sitting down and drinking, you could tell he was about to ask for another. He was most likely a knight, but you do not see his sword. Across from him was a priest who seemed shy and timid. Something about her told you she was experienced. Finally, at the corner of the room was a short person whose gender or profession you could not identify. Looks like your choices is to 𝐡𝐢𝐫𝐞 the 𝐤𝐧𝐢𝐠𝐡𝐭, the 𝐩𝐫𝐢𝐞𝐬𝐭, or the 𝐦𝐲𝐬𝐭𝐞𝐫𝐢𝐨𝐮𝐬 𝐩𝐞𝐫𝐬𝐨𝐧";
			String r = response(statement,scene);
			if(r.equals("")){
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if(in.nextLine().toLowerCase().contains("yes")){
					choice1 = r.substring(4);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

	}

	public String checkGold(){
		emotion1++;
		int num = (int)(Math.random()*3);
		String comment;
		if(emotion1>10){
			String [] responses = {"Can you hurry up already?", "You've already checked " + emotion1 + " times!", "Now can we move on with the story?"};
			comment = responses[num];
		} else if(emotion1>4){
			String [] responses = {"Please hurry up.", "Can we get back to the story?", "Okay, I think you've checked enough."};
			comment = responses[num];
		} else {
			String [] responses = {"Looking pretty good.", "", "Nice!"};
			comment = responses[num];
		}
	    return "Your party currently has " + gold + " gold piece(s). " + comment;
    }
    public String invalidAction(){
		emotion2++;
		int num = (int)(Math.random()*3);
		String comment = "";
		if(emotion2>10){
			String [] responses = {"Okay??", "Do you not speak English?", "How do you mess up " + emotion2 + " times?!"};
			comment = responses[num];
		} else if(emotion2>6){
			String [] responses = {"What don't you understand?", "IN. BOLD.", "Sir."};
			comment = responses[num];
		} else if(emotion2>3) {
			String [] responses = {"What's so hard to get?", "In. Bold.", "Have you tried to OBSERVE?"};
			comment = responses[num];
		}
	    return "Please pick a valid action (in bold). " + comment;
    }

    public String mock(String statement){
		String newStr = "";
		for(int i = 0; i < statement.length();i++){
			if(i%2==0){
				newStr += statement.substring(i,i+1).toLowerCase();
			} else {
				newStr += statement.substring(i,i+1).toUpperCase();
			}
		}
		return newStr;
	}

	public String response(String statement, String[] keyword) {
		for (int i = 0; i < keyword.length; i++) {
			if (statement.contains(keyword[i])) {
				return keyword[i];
			}
		}
		if (findKeyword(statement,"hi",0)==-1||findKeyword(statement,"hello",0)==-1){
			if(!hi){
				System.out.println("Hello!");
				hi = true;
			} else {
				System.out.println("You already said hi.");
				emotion2++;
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
        	if(Math.random()>0.3) {
				System.out.println(invalidAction());
			} else {
        		System.out.println(mock(statement));
			}
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
	private int findKeyword(String statement, String goal,
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
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}


	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
/*	private String getRandomResponse ()
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
*/
}
