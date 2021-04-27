import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface Room {
	public static Scanner kbd = new Scanner( System.in);
	public void play() throws InterruptedException;
	public static void addTraitPoint( Trait t, int value ) {
		if( t.equals( t.CHAOTIC ) || t.equals( t.LAWFUL ) ) {
			Main.player.firstAxis.updateValue( t, value );
		}
		if( t.equals( t.GOOD ) ||  t.equals( t.EVIL ) ) {
			Main.player.secondAxis.updateValue( t, value );
		}
	}
	public static Player getPlayer() {
		return Main.player;
	}
	
	public static void setRoom( Room newRoom ) {
		Main.currentRoom = newRoom;
	}
	public static Room getCurrentRoom() {
		return Main.currentRoom;
	}
	public static int getSelection( Scanner kbd, int n ) {
		String selection = kbd.next();
		boolean isValid = false;
		while( isValid != true ) {
			if( selection.isEmpty() || Integer.parseInt( selection ) > n || Integer.parseInt( selection ) <  1 ) {
				System.out.println( "Please enter a valid selection." );
				selection = kbd.next();
			}
			else { 
				isValid = true;
			
			}
		}
		return Integer.parseInt( selection ) - 1;
	}
	
	public static void clearConsole( ) {
		System.out.println( "\nPress Enter to continue.");
		try {
			System.in.read();

			System.out.print("\033[H\033[2J"); 
			System.out.flush();
		}
		catch( Exception e ) {}
	}
	
	public static boolean init( Room nextRoom ) {
		Room.setRoom( nextRoom );
		try {
			Room.getCurrentRoom().play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
