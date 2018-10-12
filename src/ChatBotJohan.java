import java.util.Scanner;

public class ChatBotJohan
{
	private int timer = 15;
	private boolean win = false;
    private int stop = 0;
    private String used;
    private String usedOn;
	private String inventory[] = {};
	private String[][] roomObs = {
	    {"scissors", "You notice a pair of bloody scissors on the floor, useful for cutting string. You pocket it."},
        {"window", "The window is barred with thick steel. It would be a waste of time to try to break through them."},
        {"door", "You approach the door. A glimmer catches your eye. A string is connected from the doorknob to a hanging safe. Unless you find a way to cut the string, the door is a death trap."},
        {"knife", "There is a rusty knife on the floor. A surefire way to get tetanus. You pocket it."},
        {"safe", "The safe is hanging from the ceiling via string attached to the doorknob. Could there be something in it?"},
        {"safe", "The safe is now on the floor. However, you cannot crack it. Maybe there is a code somehwere?"},
        {"drawer", "You try to open the drawer but it's stuck! If only you had something to pry it open."},
	};

    public void main(String[] args)
    {
        System.out.println("You awaken in a dimly lit room. You have no idea of your whereabouts. Panicking, you look around for" +
                " a way out. You observe a pair of scissors, a window, a door, a rusty knife, a safe, and a drawer. A clock" +
                " on the wall is also ticking. You have 15 minutes until midnight.");
        chatLoop();
    }

    private void chatLoop()
    {
        Scanner in = new Scanner(System.in);
        String statement = in.nextLine();
        while (timer != 0 || !win)
        {
            transformKeyword(statement);
        }
    }

	private void transformKeyword(String statement)
	{
		statement = statement.trim();
		statement = statement.toLowerCase();
		stop = 0;
		if(statement.contains("use"))
        {
            if(statement.contains("on"))
            {
                used = statement.substring(statement.indexOf("use") + 1, statement.indexOf("on"));
                usedOn = statement.substring(statement.indexOf("on") + 1);
            }
            used = statement.substring(statement.indexOf("use") + 1);
            for(int j = 0; j < inventory.length; j++)
            {
                if(inventory[j].equals(used))
                {
                    stop++;
                    if(statement.contains("on"))
                    {
                    if(!(statement.contains("on")))
                    {
                        System.out.println("What would you like to use the " + inventory[j] + " on?");
                    }
                    break;
                }
            }
            if(stop == 0)
                System.out.println("You don't have that object in your inventory.");
        }
		for (int i = 0; i < roomObs.length; i++)
		{
            stop = 0;
			if(statement.contains(roomObs[i][0]))
			{
				System.out.println(roomObs[i][1]);
				if(roomObs[i][1].contains("You pocket it."))
					inventory[inventory.length] = roomObs[i][0];
				timer--;
				if(timer == 1)
                    System.out.println(timer + " minute until midnight. You feel an overwhelming sense of dread.");
				else
				    System.out.println(timer + " minutes until midnight.");
				stop++;
				break;
			}
		}
		if (stop == 0)
			System.out.println("You are confused by your own thought process. Try again.");
	}
        private int findKeyword(String statement, String goal, int startPos)
        {
            String phrase = statement.trim().toLowerCase();
            goal = goal.toLowerCase();
            int psn = phrase.indexOf(goal, startPos);
            while (psn >= 0)
            {
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
                if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
                        && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
                {
                    return psn;
                }
                psn = phrase.indexOf(goal, psn + 1);
            }
            return -1;
        }
}


