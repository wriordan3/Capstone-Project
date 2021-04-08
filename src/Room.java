import java.util.List;
import java.util.Scanner;

public interface Room {
	
	public void play() throws InterruptedException;
	public static void addTraitPoint( Trait t, int value ) {
		if( t.equals( t.CHAOTIC ) || t.equals(t.NEUTRAL1) || t.equals( t.LAWFUL ) ) {
			Main.player.firstAxis.updateValue( t, value );
		}
		if( t.equals( t.GOOD ) || t.equals(t.NEUTRAL2) || t.equals( t.EVIL ) ) {
			Main.player.secondAxis.updateValue( t, value );
		}
	}
	public static Player getPlayer() {
		return Main.player;
	}
	
	public static Boolean isValidSelection( String selection, int optionsSize ) {
		Boolean isValid = false;
		while( isValid != true ) {
			if( selection.isEmpty() || Integer.parseInt( selection ) > 2 || Integer.parseInt( selection ) <  1 ) {
				System.out.println( "Please enter a valid selection." );
			}
			else { 
				isValid = true;
			
			}
		}
		return isValid;
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
}
