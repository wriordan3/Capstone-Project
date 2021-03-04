import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room1 implements Room {

	private static Room thisRoom;
	//Create new instance of the room to allow linked traversal through story. Print initial text for room and call getoptions
	
	public static Room init() {
		System.out.println( "\nYou awake on a strange world, Earth-like with an unsettlingly calm aura."
				+ "\nYou feel your senses are playing tricks on you as bronze trees dance to the warm wind, and feathered animals of all sizes graze the red and grey brush."
				+ "\nWhere the horizon meets the lavender sky you spot an outpost, perhaps the people there can help... if they're human."
				+ "\nOr the arid climate may allow you to build a signal fire." );
		getOptions();
		return new Room1();
		
	}

	//Create scanner to take in user input, print all options for player, call option.selected() for respective user input
	public static void getOptions() {
		int i = 1;
		List<Method> options = new ArrayList<Method>();
		for( Class<?> cls : Room1.class.getDeclaredClasses() ) {
			try {
				@SuppressWarnings("deprecation")
				Object obj = cls.newInstance();
				Method getOption = cls.getDeclaredMethod( "getOption" );
				getOption.setAccessible(true);
				System.out.println( i + " -> " + getOption.invoke(obj, null) );
				options.add( getOption );
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			
		}
		Scanner kbd = new Scanner( System.in );
		int selection = kbd.nextInt();
		if( selection > options.size() ) { System.out.println( "Please enter a valid number." ); Room1.getOptions();}
		try {
			options.get( selection -1 ).invoke( thisRoom, null );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static class Option1 implements Option {
		static String optionText = "Reach the outpost.";
		static String getOption() { return optionText; }
		static Room selected() {
			return Room1a.init();
		}
	}
	
	public static class Option2 implements Option {
		static String optionText = "Attempt to build a fire.";
		static String getOption() { return optionText; }
		static Room selected() {
			return Room1b.init();
		}
	}
}
