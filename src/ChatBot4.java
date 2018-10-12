/*import java.util.Scanner;

public class ChatBotJohan
{
	private int timer = 15;
	private boolean win = false;
	private String inventory[] = {};
	private String roomObs[][] = new String{
	{"scissors", "You notice a pair of bloody scissors on the floor, useful for cutting string. You pocket it."},
	{"window", "The window is barred with thick steel. It would be a waste of time to try to break through them."},
	{"door", "You approach the door. A glimmer catches your eye. A string is connected from the doorknob to a hanging safe. Unless you find a way to cut the string, the door is a death trap."],
		{"knife", "There is a rusty knife on the floor. A surefire way to get tetanus. You pocket it."},
		{"safe", "The safe is hanging from the ceiling via string attached to the doorknob. Could there be something in it?"},
		{"safe", "The safe is now on the floor. However, you cannot crack it. Maybe there is a code somehwere?"},
		{"drawer", "You try to open the drawer but it's stuck! If only you had something to pry it open."};

		public static void main(String[] args)
		{
			Scanner phrase = new Scanner(System.in);
			System.out.println ("You awaken in a dimly lit room. You have no idea of your whereabouts. Panicking, you look around for" +
					" a way out. You observe a pair of scissors, a window, a door, a rusty knife, a safe, and a drawer. A clock" +
					" on the wall is also ticking. You have 15 minutes until midnight.");
			while (timer != 0 || win != true)


		}
	}

	private String transformKeyword(String statement)
	{
		statement = statement.trim();
		statement = statement.toLowerCase();
		int stop = 0;
		for (int i = 0; i < roomObs.length; i++)
		{
			if(!(statement.indexOf(roomObs[i][0]) == -1))
			{
				System.out.println(roomObs[i][1]);
				if(!(roomObs[i][1].indexOf("You pocket it.") == -1))
					inventory[inventory.length] = roomObs[i][0];
				timer--;
				stop++;
				break;
			}
		}
		if (stop == 0)
			System.out.println("You are confused by your own thought process. Try again.");
	}


	private String findKeyword(String statement);*/