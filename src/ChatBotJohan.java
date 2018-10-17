import java.util.Scanner;

public class ChatBotJohan
{
	private int timer = 15;
	private boolean win = false;
    private int stop = 0;
    private String used;
    private String usedOn;
	private String inventory[] = {"", "", "", ""};
	private int counter = 0;
	private String[][] roomObs = {
	    {"scissors", "You notice a pair of bloody scissors on the floor, useful for cutting string. You pocket it."},
        {"scissors", "You've already taken the scissors."},
        {"window", "The window is barred with thick steel. It would be a waste of time to try to break through them."},
        {"window", "The window is barred with thick steel. It would be a waste of time to try to break through them."},
        {"door", "You approach the door. A glimmer catches your eye. A string is connected from the doorknob to a hanging safe. Unless you find a way to cut the string, the door is a death trap."},
        {"door", "The door is locked shut. There might be a key around here somewhere."},
        {"knife", "There is a rusty knife on the floor. A surefire way to get tetanus. You pocket it."},
        {"knife", "You've already taken the knife."},
        {"safe", "The safe is hanging from the ceiling via string attached to the doorknob. Could there be something in it?"},
        {"safe", "The safe is now on the floor. However, you cannot crack it. Maybe there is a code somewhere?"},
        {"drawer", "You try to open the drawer but it's stuck! If only you had something to pry it open."},
        {"drawer", "The drawer is now empty."}
	};
	private String[][] roomUse = {
            {"scissors", "door", "You use the scissors to snip the string. The safe comes crashing down onto the floor. The door is locked."},
            {"scissors", "window", "It's no use. The window is too thick to cut"},
            {"scissors", "knife", "Now's not the time for a sword fight."},
            {"scissors", "safe", "The safe is too thick to be busted open with scissors. You need the code."},
            {"scissors", "drawer", "The scissors are too thick to pry the drawer open with."},
            {"knife", "door", "The knife is far too rusty to cut anything with."},
            {"knife", "window", "Yeah...there's no way you're getting through this thing."},
            {"knife", "scissors", "Now's not the time for a sword fight."},
            {"knife", "safe", "The safe is too thick to be busted open with scissors. You need the code."},
            {"knife", "drawer", "code", "The knife is thin enough to slip into the crevice. You pry open the drawer. Inside, there is a code!", "code"},
            {"code", "door", "This code is only good for one thing: the safe."},
            {"code", "window", "This code is only good for one thing: the safe."},
            {"code", "scissors", "This code is only good for one thing: the safe."},
            {"code", "knife", "This code is only good for one thing: the safe."},
            {"code", "safe", "You enter the code into the safe. Inside, there is a key! It must be for the door!", "key"},
            {"code", "drawer", "This code is only good for one thing: the safe."},
            {"key", "door", "You enter the key into the door. Victory! You run as fast as you can from the house."},
            {"key", "window", "This key is only good for one thing: the door."},
            {"key", "scissors", "This key is only good for one thing: the door."},
            {"key", "knife", "This key is only good for one thing: the door."},
            {"key", "safe", "This key is only good for one thing: the door."},
            {"key", "drawer", "This key is only good for one thing: the door."}
    };

    public void chatLoop(String statemen)
    {
        System.out.println("You awaken in a dimly lit room. You have no idea of your whereabouts. Panicking, you look around for a way out.");
        System.out.println("You observe a pair of scissors, a window, a door, a rusty knife, a safe, and a drawer.");
        System.out.println("A clock on the wall is also ticking. You have 15 minutes until midnight.");
        Scanner in = new Scanner(System.in);
        String statement;
        while (timer != 0 || !win)
        {
            statement = in.nextLine();
            transformKeyword(statement);
        }
        if(timer == 0)
        {
            System.out.println("It's too late...");
            System.out.println("You scream as a man crashes through the wall, chainsaw in hand.");
            System.out.println("Nobody hears your screams as he saws you in half. It all goes hazy...");
        }
        if(win)
        {
            System.out.println("You finally escaped!");
        }
    }

	private void transformKeyword(String statement)
    {
        statement = statement.trim();
        statement = statement.toLowerCase();
        stop = 0;
        if (findKeyword(statement, "use", 0) != -1)
        {
            if (findKeyword(statement, "on", 0) != -1)
            {
                used = statement.substring(findKeyword(statement, "use", 0) + 4, findKeyword(statement, "on", 0));
                usedOn = statement.substring(findKeyword(statement, "on", 0) + 3);
                for (int j = 0; j < inventory.length; j++)
                {
                    System.out.println(used);
                    System.out.println(inventory[j]);
                    if(used.equals(inventory[j]))
                    if (inventory[j].equals(used))
                    {
                        System.out.println("HHHHHHHH");
                        stop++;
                        for(int i = 0; i < roomUse.length; i++)
                        {
                            if(roomUse[i][0] == used && roomUse[i][1] == usedOn)
                            {
                                if(roomUse[i].length > 3)
                                {
                                    System.out.println(roomUse[i][3]);
                                    inventory[counter] = roomUse[i][2];
                                    counter++;
                                    return;
                                }
                                else
                                {
                                    System.out.println(roomUse[i][2]);
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
                if(stop == 0)
                {
                    System.out.println("You don't have that object in your inventory.");
                    return;
                }
                stop = 0;
            }
            used = statement.substring(findKeyword(statement, "use", 0) + 1);
            for (int j = 0; j < inventory.length; j++)
            {
                if (inventory[j].equals(used))
                {
                    stop++;
                    if (findKeyword(statement, "on", 0) != -1)
                    {
                        if (findKeyword(statement, "on", 0) == -1)
                        {
                            System.out.println("What would you like to use the " + inventory[j] + " on?");
                        }
                        return;
                    }
                }
                if (stop == 0)
                {
                    System.out.println("You don't have that object in your inventory.");
                    return;
                }
            }
            return;
        }
        for (int i = 0; i < roomObs.length; i++) {
            stop = 0;
            if (findKeyword(statement, roomObs[i][0], 0) != -1)
            {
                System.out.println(roomObs[i][1]);
                if (roomObs[i][1].contains("You pocket it."))
                {
                    inventory[counter] = roomObs[i][0];
                    counter++;
                }
                timer--;
                if (timer == 1)
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

