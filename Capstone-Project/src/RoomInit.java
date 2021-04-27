import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RoomInit implements Room {

	public static boolean init() {
		Room.setRoom( new RoomInit() );
		try {
			Room.getCurrentRoom().play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public void play() throws InterruptedException {
		System.out.println( "Who are you?" );
		String name = kbd.nextLine();
		if( name.trim().isEmpty() ) {
			System.out.println( "Error: No Response");
			RoomInit.init();
		}
		else {
			Main.player = new Player( name );
			System.out.println( "Error: Anomaly detected!");
			Thread.sleep( 100 );
			System.out.println( "	Exception @ \"P#r$0n/\\\" DENIED.DENIED.DENIED: Access Denied - Anomalous Response" );
			System.out.println( " 		-> \"" + name + "\"" );	
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
			Room1.init();
		}
		
	}

	



}
