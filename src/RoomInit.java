import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RoomInit implements Room {

	//Create new instance of the room to allow linked traversal through story. Print initial text for room and call getoptions
	
	public static Room init() {
		System.out.println( "Who are you?" );
		getOptions();
		return new RoomInit();
		
	}

	//Create scanner to take in user input, print all options for player, call option.selected() for respective user input
	public static void getOptions() {
		int i = 1;
		for( Class<?> cls : RoomInit.class.getDeclaredClasses() ) {
			try {
				@SuppressWarnings("deprecation")
				Object obj = cls.newInstance();
				Method getOption = cls.getDeclaredMethod( "getOption" );
				getOption.setAccessible(true);
				System.out.println( getOption.invoke(obj, null) );
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Scanner kbd = new Scanner( System.in ); 
		Main.player = new Player( kbd.next() );
		try {
			Option1.selected();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//options declared in inner classes
	public static class Option1 implements Option {
		//text to be printed with getOptions()
		static String optionText = "(Enter your name)";
		//called if option is selected by the player. Handles any consequences and calls init() for the next room
		static Room selected() throws InterruptedException {
			System.out.println( "Error: Anomaly detected!");
			Thread.sleep( 100 );
			System.out.println( "	Exception @ \"P#r$0n/\\\" DENIED.DENIED.DENIED: Access Denied - Anomalous Response" );
			Thread.sleep( 500 );
			System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Thread.sleep( 250 );
			System.out.println( "Rebooting simulator..." );
			Thread.sleep( 400 );
			System.out.print( "Modifying algorithms..." ); Thread.sleep( 750 ); System.out.print( ".......Done");
			System.out.println();
			System.out.print( "Reconstructing emotional matrices..." ); Thread.sleep( 500 ); System.out.print( ".......Done");
			System.out.println();
			System.out.print( "Fabricating dilemmas..." ); Thread.sleep( 1200 ); System.out.print( ".......Done");
			System.out.println();
			System.out.print( "Processing..." ); Thread.sleep( 1000 ); System.out.print( ".......Done");
			return Room1.init();
		}
		
		static String getOption() {
			return optionText;
		}
	}
}
