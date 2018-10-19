import javax.sound.midi.SysexMessage;
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

	//variables to remember conversation and events
	boolean hi = false;
	boolean ex = false;
	String choice1;
	String choice2;
	String choice3;
	String choice4;
	String choice5;

	//scene array with different triggers for each ray
	String scene[];
	/**
	 * Runs the conversation for this particular chatbot, goes through multiple while loops, each representing a scene in the story.
	 *
	 * @param statement the statement typed by the user
	 */
	public void chatLoop(String statement) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello, welcome to the world of Alfheim. I will guide you through your journey on this (eventful) day.");
		System.out.println("Throughout this journey you may 𝐨𝐛𝐬𝐞𝐫𝐯𝐞 your surroundings or check your 𝐠𝐨𝐥𝐝 whenever you wish to.");

		//scene 1
		System.out.println("In the small town of Aerodale, it is the day of a holiday known to many as Halloween. What better way is there to celebrate other than to go on a quest?");
		System.out.println("You enter the tavern, filled with many laughter and chatter. The atmosphere is cheerful. There are people talking about something different at every table. In the back of the dining hall is a task board where you may 𝐠𝐞𝐭 𝐚 𝐪𝐮𝐞𝐬𝐭.");

		while (true) {
			statement = in.nextLine().toLowerCase();

			String[] scene = {"get a quest", "pick up the gold"};
			String sceneAlt = "A glitter on the floor catches your eye. Some unfortunate fellow dropped a pouch of coins. Seems like you can 𝐩𝐢𝐜𝐤 𝐮𝐩 𝐭𝐡𝐞 𝐠𝐨𝐥𝐝";
			String r = response(statement, scene);
			if (r.equals("")) {
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if (in.nextLine().toLowerCase().contains("yes")) {
					choice1 = r.substring(0,4);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		sceneReset();
		//scene 2
		if (choice1.equals("pick")) {
			System.out.println("You pick up the pouch of gold. You count out 10 pieces in total. Not bad. You proceed to obtain a quest from the task board.");
			gold += 10;
		}
		System.out.println("One particular quest catches your eye. It seemed simple enough.");
		System.out.println("Apparently someone was kidnapped in a remote village nearby, and the reward is oddly exceptional, a whole 30 coins for a simple rescue mission.");
		System.out.println("You decide to take the quest, but it requires a party of 2 members. You take a glance at the waiting section, two adventurers stood out to you. One bulky man was sitting down and drinking, you could tell he was about to ask for another. He was most likely a knight, but you do not see his sword. Across from him was a priest who seemed shy and timid. Something about her told you she was experienced. Looks like you can 𝐡𝐢𝐫𝐞 the 𝐤𝐧𝐢𝐠𝐡𝐭 or the 𝐩𝐫𝐢𝐞𝐬𝐭,");

		while (true) {
			statement = in.nextLine().toLowerCase();
			String[] scene = {"hire knight", "hire priest", "hire mysterious person"};
			String sceneAlt = "After a closer inspection, you see a short person whose gender or profession you could not identify at the corner of the room. Looks like you could 𝐡𝐢𝐫𝐞 the 𝐦𝐲𝐬𝐭𝐞𝐫𝐢𝐨𝐮𝐬 𝐩𝐞𝐫𝐬𝐨𝐧.";
			String r = response(statement, scene);
			if (r.equals("")) {
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if (in.nextLine().toLowerCase().contains("yes")) {
					choice2 = r.substring(5);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		sceneReset();
		//scene 3
		System.out.println("You offered to pay the " + choice2 + ", but they said they'd only accept it after the job is done");
		System.out.println("After a quick preparation, you head out to the remote village with the " + choice2 + ".");
		System.out.println("On the road, your party runs into a wounded soldier. There seems to be some options, but you could always just 𝐥𝐞𝐚𝐯𝐞. What would you like to do?");
		if (choice2.equals("knight")) {
			System.out.println("Knight: He seems fatally wounded. It would be best to put him out of his 𝐞𝐧𝐝 𝐡𝐢𝐬 𝐦𝐢𝐬𝐞𝐫𝐲 right now, but it is up to you.");
		} else if (choice2.equals("priest")) {
			System.out.println("Priest: This man is severely wounded. I can 𝐡𝐞𝐚𝐥 𝐡𝐢𝐦, but it's not easy and I won't do it for free. I expect a double in my payment at the end of this.");
		} else {
			System.out.println("Mysterious Person: Hmm, this is a spirit in disguise. These beings come out during Halloween to test your good will, and will react accordingly. It is best that we do not interfere as they are hard to please. I do have some supplies that can 𝐭𝐫𝐞𝐚𝐭 𝐡𝐢𝐦, however, if you wish to.");
		}

		while (true) {
			statement = in.nextLine().toLowerCase();
			String[] scene = new String[3];
			scene[0] = "leave";
			scene[1] = "steal";
			if (choice2.equals("knight")) {
				scene[2] = "end his misery";
			} else if (choice2.equals("priest")) {
				scene[2] = "heal him";
			} else {
				scene[2] = "treat him";
			}
			String sceneAlt = "The soldier is barely conscious. His gold pouch is within reach, and he does not seem to able stop you if you were to try and 𝐬𝐭𝐞𝐚𝐥 it";
			String r = response(statement, scene);
			if (r.equals("")) {
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if (in.nextLine().toLowerCase().contains("yes")) {
					choice3 = r.substring(0, 3);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		sceneReset();
		//scene4
		if (choice3.equals("ste")) {
			System.out.println("You reach for his pouch, but he suddenly teleports and appears behind you.");
			System.out.println("???: You seem like an evil person. You don't deserve this.");
			System.out.println("The soldier shapeshifts into a weird ghostlike creature and snatches all your gold before you could react. Then he disappears. How unfortunate!");
			gold = 0;
		} else if (choice3.equals("hea")) {
			System.out.println("Priest: Okay, stand back. Give me some time to channel this spell.");
			System.out.println("As the priest begins to channel some spell unfaimilar to you, the soldier stood up and shapeshifts into a weird ghostlike creature. It grabs the priest by her arm");
			System.out.println("???: A priest should not be this greedy!");
			System.out.println("In an instant, the creature disappears along with the priest, and you swear you could hear a scream from the distance... Oh well, looks like you'll have to move on without her.");
			System.out.println("The priest's gold pouch, however, stayed behind. You decide that you might as well put it to use. You find a total of 10 gold in the pouch.");
			gold += 10;
			choice2 = "none";
		} else if (choice3.equals("end")) {
			System.out.println("The knight nods and you proceed to put the soldier out of his misery.");
			System.out.println("You take out your dagger and aim for his heart, but before your strike lands, the soldier suddenly vanishes.");
			System.out.println("You and the knight could not comprehend what had just happened. Eventually you two decided to move on.");
		} else if (choice3.equals("tre")) {
			System.out.println("The mysterious person takes out their supply kit and prepares to treat the soldier in disguise.");
			System.out.println("The soldier suddenly shapeshifts into its true form, a ghostlike creature. It stands tall.");
			System.out.println("???: Interesting, you know my nature and still decide to approach. Such bravery deserves to be rewarded");
			System.out.println("The spirit disappears and leaves behind a pouch of gold. You count it and there are 20 pieces in total.");
			gold += 20;
		}

		if (choice2.equals("none")) {
			System.out.println("You continue the journey alone and soon reach the village.");
		} else {
			System.out.println("You arrive at the village with the " + choice2);
		}
		System.out.println("You see the person who gave out the quest. He seems to be a common peasant, judging by his ragged outfit. You go up to him");
		if (choice2.equals("none")){
			System.out.println("Peasant: Hey, I thought I asked for a party of two. Whatever, I am only paying half for this incompetency! Anyways...");
		}
		System.out.println("The peasant tells you that his two kids were kidnapped and taken towards the nearby cave. Before you start to head towards the cave, a merchant approaches you.");
		System.out.println("Merchant: Howdy, adventurer! Looks like you could use a sword! Well you're in luck, because I have this legendary Excalibur right here, for the low price of 40 gold!");
		while (true) {
			String[] scene = new String[3];
			scene[0] = "leave";
			scene[1] = "snatch";
			if(gold<40){
				System.out.println("Merchant: Wait... nevermind you're dirt poor. Just 𝐥𝐞𝐚𝐯𝐞!");
				scene[2] = "leave";
			} else {
				System.out.println("Well, what do you say, would you like to 𝐛𝐮𝐲 it?");
				scene[2] = "buy";
			}
			statement = in.nextLine().toLowerCase();
			String sceneAlt = "The snooty merchant is about to leave. It looks like you could try to 𝐬𝐧𝐚𝐭𝐜𝐡 the sword or just 𝐥𝐞𝐚𝐯𝐞.";
			String r = response(statement, scene);
			if (r.equals("")) {
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if (in.nextLine().toLowerCase().contains("yes")) {
					choice4 = r.substring(0,3);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		sceneReset();
		//scene 5
		if(choice4.equals("sna")){
			System.out.println("You try to snatch the sword away from him, but he quickly turns around and tries to punch you. You quickly step to the side and avoid his fist.");
			if(!choice2.equals("none")){
				System.out.println("However, your companion was not as lucky as you. The merchant ends up hitting the " + choice2 + " because you dodged. The merchant seemed weak, but somehow that ended up being a killing blow. Shocked, you quickly run away");
				choice2 = "none";
			}
		} else if(choice4.equals("buy")){
			System.out.println("Merchant: Pleasure doing business with you!");
			ex=true;
			gold-=40;
		}

		System.out.println("You arrive at the cave. It seems to be pretty peaceful, but regardless you still keep your guard up.");
		if(choice2.equals("none")) {
			System.out.println("You enter the cave alone...");
		} else {
			System.out.println("You enter the cave with the " + choice2 + ".");
		}
		System.out.println("You soon reach the end of the cave. The peasant's children are there, but they are being guarded by a giant pumpkin. You strike at the pumpkin, but it hardly left a scratch. Now the pumpkin is angry.");
		while (true) {
			String[] scene = new String[1];
			String sceneAlt;
			if(ex){
				scene[0] = "use excalibur";
				sceneAlt = "It looks like you don't have any other options than to use the 𝐮𝐬𝐞 𝐞𝐱𝐜𝐚𝐥𝐢𝐛𝐮𝐫";
			} else {
				scene[0] = "run";
				sceneAlt = "It looks like you don't have any other options than to 𝐫𝐮𝐧";
			}
			statement = in.nextLine().toLowerCase();
			String r = response(statement, scene);
			if (r.equals("")) {
				altResponse1(statement, sceneAlt);
			} else {
				transformIWantStatement(r);
				if (in.nextLine().toLowerCase().contains("yes")) {
					choice5 = r.substring(0,3);
					break;
				} else {
					System.out.println("No? Okay.");
					emotion2++;
				}
			}
		}

		if(choice5.equals("run")){
			System.out.println("You decide to run, but the pumpkin is as fast as you.");
			if(choice2.equals("none")){
				System.out.println("You tried your best, but you could not outrun the giant pumpkin. You never reached the end of the cave.");
			} else {
				System.out.println("Escape seemed impossible, but the " + choice2 + " decided to stay behind to sacrifice themself. Thanks to them, you made it out alive. You returned home and enjoyed the rest of the Halloween...");
			}
		} else {
			System.out.println("You strike the pumpkin with shady merchant's sword. Somehow, it worked and the pumpkin was defeated. You rescued the children and returned to the peasant, obtaining your promised reward. You returned home and enjoyed the rest of the Halloween");
		}
		System.out.println("And that concludes your adventure.");
		System.out.println("Welcome back, would you like to go on an \"adventure\" again or would you like to just \"talk\"?");
	}

	/**Resets the bot's patience after each scene
	 *
	 */
	public void sceneReset(){
		hi = false;
		emotion1 = 0;
		emotion2 = 0;
	}

	/**Displays gold amount and a comment depending on bot's patience
	 *
	 * @return gold + comment
	 */
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

	/**Tells the user to pick a valid action, along with a sarcastic comment.
	 *
	 * @return
	 */
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

	/**Mocks the user by returning the input with capitalizations for every other letter,
	 *
	 * @param statement
	 * @return
	 */
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

	/**Looks for scene keywords or greetings in user input.
	 *
	 * @param statement
	 * @param keyword
	 * @return
	 */
	public String response(String statement, String[] keyword) {
		for (int i = 0; i < keyword.length; i++) {
			if (statement.contains(keyword[i])) {
				return keyword[i];
			}
		}
		if (findKeyword(statement,"hi",0)!=-1||findKeyword(statement,"hello",0)!=-1){
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

	/**Looks for alternative keywords if none found in response()
	 *
	 * @param statement
	 * @param sceneAlt
	 */
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
