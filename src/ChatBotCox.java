import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotCox
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	private int emotion = 0;
	private int curIdx = 0;
    private static String[] eventArray = {"Your 9 years old and it's once again your favorite time of year; October.  You've spent a full month before hand picking out your costume for Halloween. Tonight is finally the big night and your Mom is taking you out trick-or-treating along with your older brother who decided to wear the same Batman costume he did last year.\n You leave your house you can see the street filled with children running across the streets and between houses. Filled with excitement you dart through the crowds of children to the house across the street eager to collect your candy, but before you know it you realize you've been separated from your mom.  What do you do?",
			//N1
			"Telling yourself that you can find your mom later, you continue on to the house where you encounter another group of kids like yourself receiving candy from the old lady in the doorway.  When it's finally your turn you eagerly approach and say \"trick-or-treat!\".  As the old lady gives you some Reese's Peanut Butter cups she notices that you you don't have any adult with you and asks if you've lost your parents and want to come inside while she calls around and tries to figure out where they are?",
			//N2
			"Politely refusing the old lady's request you again wonder if you should try and find your mother.",
			//N3
			"Standing on the crowded street under the light of a street lamp you hvae trouble deciding between going left or right.",
			//N4
			"Deciding to head left, you spot your mother who looks frantic as she looks through the crowd presumably looking for you.  Do you approach her?",
			//N5
			"As you near her she turns and spots you and immediately lunges towards you screaming your name in relief.  She scolds you for having run off so quickly without having a second thought about staying close to her.  She decides that as a punishment you're done trick-or-treating for the night and immediately takes you and your brother home.  You spend the rest of the night looking out the window at the other kids in your neighborhood enjoying there nights until finally falling asleep in your bed.\nTHE END.",
			//N6
			"Looking for your mother you begin to panick as you realize how dense the crowd of people is around you, and being a nine year old kid, you can't see over the heads of anyone around you.  Do you decide to go left or right to search for your mom?",
			//N7
			"Deciding to head right, you bump into your older brother who gives you an affectionate nuggie, which you don't like at all.  It seems as though he lost track of mom too though he was probably trying to do that.  He asks if you want to hang out and trick-or-treat with him for the rest of the night.",
			//N8
			"Telling your brother that you'd like to be a lone wolf that night, you continue on through the crowds by yourself until you come across a hot pink house with other children already swarming the porch to check out the cool decorations they have laid out and get huge amounts of candy, and another apparently less popular house with a much shorter line. Which house do you go to?",
			//N9
			"After waiting for a while to get to the front of the line of the pink house you finally realize that your efforts were not in vain as they gave you two full sized packs of skittles.  After coming down from the high of receiving such a gift you consider your next stop.",
			//N10
			"Heading back to look for your mom, your eventually spot her frantically looking for you.  Do you approach her?",
			//N11
			"Heading into the old lady's house she tells you to take a seat on the sofa in the living room while she goes and makes some calls to try and find your mother.  She tells you to make yourself at home and take any candy you want from the bowl on the coffee table while you wait.",
			//N12
			"While waiting for the old lady to come back you fill yourself up with all the candy you could ever want, even enough so that you no longer want to keep Trick-or-treating, and after about 15 minutes sitting there in silence, you hear the doorbell rings and the old lady returns saying that it must be your mother.  As she opens the door you see your moms familiar face look in at yours as relief washes over her face as she goes to hug you.  She quickly however becomes angry and she scolds you for having run off so quickly without having a second thought about staying close to her.  She immediately takes you and your brother home.  Where you quickly fall asleep in your bed full of candy.\nTHE END.",
			//N13
			"Successfully sneaking away from your mother you come to side of the street with an man on his porch attempting to hand out apples to kids who pass by, but they all seem to be ignoring him in favor of actual candy.  Do you want apples?",
			//N14
			"Deciding that you might want to be at least a little bit healthy on a night like tonight you approach the man and say \"trick-or-treat!\", apparently overjoyed to actually have a kid who wants something other that candy he proudly hands you the apple and says to have a nice night.  Now which way do you go down the street, left or right?",
			//N15
			"Deciding that tonight is not the night for apples, you instead turn around only to find your angry mother facing you with her hands on her hips.  She scolds you for having run off so quickly without having a second thought about staying close to her.  She decides that as a punishment you're done trick-or-treating for the night and immediately takes you and your brother home.  You spend the rest of the night looking out the window at the other kids in your neighborhood enjoying there nights until finally falling asleep in your bed.\nTHE END.\"",
			//16
			"Deciding to roll with your brother he immediately returns to your mother where you're for having run off so quickly without having a second thought about staying close to her.  She decides that as a punishment you're done trick-or-treating for the night and immediately takes you and your brother home.  You spend the rest of the night looking out the window at the other kids in your neighborhood enjoying there nights until finally falling asleep in your bed.\nTHE END.\"",
			//17
			"Heading to the unpopular house you see that the man on the porch is handing out apples, do want some?",
			//18
			"You sit on the sofa waiting for about 15 minutes in silence, you finally hear the doorbell ring and the old lady returns saying that it must be your mother.  As she opens the door you see your moms familiar face look in at yours as relief washes over her face as she goes to hug you.  She quickly however becomes angry and she scolds you for having run off so quickly without having a second thought about staying close to her.  She immediately takes you and your brother home where you spend the rest of the night looking out the window longingly at those still trick or treating.\nTHE END.\""
    };
    private static String[] keyArray = {"candy", "mom",//K0
			"no", "yes", //K1
			"candy", "mom", //K2
			"left", "right", //K3
			"yes", "no", //K4
			null, null, //K5
			"left", "right", //K6
			"no", "yes", //K7
			"popular", "unpopular", //K8
			"mom", "candy", //K9
			"yes", "no", //K10
			"candy", "wait",//K11
			null, null,//K12
			"yes", "no",//K13
			"left", "right", //K14
			null, null, //K15
			null, null, //K16
			"yes", "no", //K17
			null, null //18
    };
    private static int[] resArray = {1,6,//R0
			2,11,//R1
			3,10,//R2
			4,7,//R3
			5,13,//R4
			12,12,//R5
			4,7,//R6
			8,16,//R7
			9,17,//R8
			10,17,//R9
			5,13,//R10
			12,18,//R11
			12,12,//R12
			14,15,//R13
			4,7,//R14
			15,15,//R15
			16,16,//R16
			14,15,//R17
			18,18//18
    };

	/**
	 * Runs the conversation for this particular chatbot, should allow switching to other chatbots.
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement)
	{
		Scanner in = new Scanner (System.in);
		System.out.println (getGreeting());

		while (!statement.equals("Bye"))
		{
			statement = in.nextLine();
			//getResponse handles the user reply
			System.out.println(getResponse(statement));
		}
	}

	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return eventArray[0];
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";

		if (findKeyword(statement, keyArray[curIdx * 2]) >= 0)
		{
			curIdx = resArray[curIdx * 2];
			response = eventArray[curIdx];
		}

		else if (findKeyword(statement, keyArray[(curIdx * 2) + 1]) >= 0)
		{
			curIdx = resArray[(curIdx * 2) + 1];
			response = eventArray[curIdx];
		}

		else
		{
			response = "I'm sorry I don't understand";
		}

		return response;
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}

	
	/**
	 * Take a statement with "I want <something>." and transform it into 
	 * "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	
    private String areYouSure(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }

        return "Are you sure you want to " + statement + "?";
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
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
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
			"Could you say that again?"
	};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};

}
