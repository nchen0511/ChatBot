import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user.
 * This version:
 * @author Brooklyn Tech CS Department
 * @version September 2018
 */
public class ChatBotDego
{
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
	int emotion = 0;
	String potType = "";
	boolean game = false;

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
            while (!statement.equalsIgnoreCase("quit")){


            if (game == true) {
                System.out.println(getResponseGame(statement));
            }
        }
			System.out.println(getResponse(statement));


		}
    // To use transform methods only in certain conditions like in a game make another method similar to getresponse and then make an if statement in chat loop that would check for the state and if its true it will use the second get response methof
	}
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, Im a witch boo";
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

		if (statement.length() == 0)
		{
			response = "Say something, please im not that ugly.";
		}

		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
                	emotion--;
		}

		else if (findKeyword(statement, "levin") >= 0)
		{
			response = "More like LevinTheDream amiright?";
			emotion++;
		}

		// Response transforming I want to statement
		else if (findKeyword(statement, "I want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want",0) >= 0)
		{
			response = transformIWantStatement(statement);
		}
		else
		{
			response = getRandomResponse();
			if(response.equals("Want to hear a joke?")){
			    int index = 5;    //5 is place holder for a random number

            }
		}

		return response;
	}

	public String getResponseGame(String statement){
	    String response = "";

	    if(statement.length() == 0){
	        response = "Did you mean to press enter?";
        }
        else if(findKeyword(statement, "I want to", 0) >= 0){
            response = transformAction(statement);
        }
        else if(findKeyword (statement, "add") >= 0){
            response = transformAdd(statement);
        }
        else if(findKeyword (statement, "remove") >= 0){
            response = transformRemove(statement);
        }
        else if(findKeyword(statement, "finish") >= 0){
        	response = transformfinish(statement);
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


    /**
     *
     * @param statement
     * @return
     */

	private String transformAction(String statement){
		//remove the final period if there is one
		statement = statement.trim();
		String period = statement.substring(statement.length() - 1);
		if(period.equals(".")){
			statement = statement.substring(0, statement.length() - 1);
		}
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Are you sure you want to " + restOfStatement + "?";
	}


    /**
     * During make a potion game when you are adding more stuff to the pot it will tell you what is in the pot and if you want to add more stuff
     * @param statement
     * @return
     */

    private String transformAdd(String statement){
        //remove the final period if there is one
        statement = statement.trim();
        String period = statement.substring(statement.length() - 1);
        if(period.equals(".")){
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "add", 0);
        String restOfStatement = statement.substring(psn + 4).trim();
        return "Are you sure you want to add a " + restOfStatement + "?";
    }

    /**
     * During make a potion game when you want to remove stuff to the pot it will tell you what is in the pot if you are sure you want to remove the object
     * @param statement
     * @return
     */

    private String transformRemove(String statement){
        //remove the final period if there is one
        statement = statement.trim();
        String period = statement.substring(statement.length() - 1);
        if(period.equals(".")){
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "remove", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        return "Are you sure you want to remove a " + restOfStatement + "?";
    }

    /**
     *
     * @param statement
     * @return
     */

    private String transformfinish(String statement){
        //remove the final period if there is one
        statement = statement.trim();
        String period = statement.substring(statement.length() - 1);
        if(period.equals(".")){
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "finish", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Are you sure dont want to add anything else to the " + potType + "?";
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
    public String getPotType() {
        Random r = new Random ();
        return potTypes [r.nextInt(potTypes.length)];
    }

    private String getJoke(int index){
		return randomhalloweenJokes[index];

	}
	private String getjokeanswer(int index){
		return haloweenJokeAnswers[index];
	}

	private String [] randomNeutralResponses = {"Would you like to play the potion maker game?","What are you going as for halloween.", "Want to hear a joke?",};
	private String [] randomAngryResponses = {"Bahumbug.", "Harumph", "The rage consumes me!"};
	private String [] randomHappyResponses = {"H A P P Y, what's that spell?", "Today is a good day", "You make me feel like a brand new pair of shoes."};
	private String [] randomhalloweenJokes = {"What do ghosts eat for supper?","What do you do when 50 zombies surround your house?","What is the most important subject a witch learns in school?","Why didn’t the skeleton want to go to school?",
										"Why didn’t the skeleton cross the road?","Why did the skeleton cross the road?","Why didn’t the skeleton go to the ball?","What did the little girl say when she had to choose between a tricycle and a candy bar?",
										"What do you call a fat pumpkin?","What room does a ghost not need?","Why are ghosts so bad at lying?","Who did Frankenstein take to the dance?","Why is Superman’s costume so tight?","What do ghosts use to wash their hair?",
										"What is a vampire’s favorite fruit?","What kind of dessert does a ghost like?","When is it bad luck to be followed by a black cat?","What do moms dress up as on Halloween?","What is a ghost’s favorite fruit?",
										"What do you get when you cross a snowman with a vampire?","Why do ghosts make good cheerleaders?","Why is a skeleton so mean?","What do vampires take when they are sick?"};
	private String [] haloweenJokeAnswers = {"Spooketi!","Hope it’s Halloween!!","Spelling.","His heart wasn’t in it.","He didn’t have any guts!","To get to the body shop.","Because he had no BODY to go with.","Trike or Treat?","A plumpkin.","A living room!",
											"Because you can see right through them!","His “ghoul” friend!","Because he wears a size “S”.","Shamboo!","A nectarine!","I scream!","When you’re a mouse.","Mummies!","Booberries!","Frostbite.","Because they have a lot of spirit.",
											"He doesn’t have a heart.","Coffin drops!"};
	private String [] potTypes = {"pot", "saucepan", "stewpot", "kettle", "jar", "crock", "vessel", "crucible"};

}