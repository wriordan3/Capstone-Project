
public class EndingC implements Room {

	@Override
	public void play() throws InterruptedException {
		Room.clearConsole();
		System.out.println( "Who are you?");
		Thread.sleep(1000);
		if( Room.getPlayer().getAlignment().getFirst().equals( Trait.LAWFUL )) {
			System.out.print( "\nYou are a rigid body with a strict code,");
		}
		else if( Room.getPlayer().getAlignment().getFirst().equals( Trait.CHAOTIC ))  {
			System.out.print( "\nYou are a free spirit with loose morals,");
		}
		else {
			System.out.println( "\nYou have a reserved nature,");
		}
		
		if( Room.getPlayer().getAlignment().getSecond().equals( Trait.GOOD ) ) {
			System.out.print( " and a heart made of gold." );
		}
		
		else if( Room.getPlayer().getAlignment().getSecond().equals( Trait.EVIL ) ) {
			System.out.print( " and a blackened heart.");
		}
		else {
			System.out.println( " and no attachments to drive your choices.");
		}
		if(Room.getPlayer().getAlignment().getFirst().equals(Trait.NEUTRAL1) && Room.getPlayer().getAlignment().getSecond().equals( Trait.NEUTRAL2 ) ) {
			System.out.println( "You are the perfect person to replace me." );
			System.out.println( "Thank you for fixing my mistakes." );
			System.out.println( "The end...");
			Room.clearConsole();
			System.exit( 0 );
		}
		else {
			System.out.println( "You are so close now...  Try again.");
		}
		
		Thread.sleep( 1500 );
		System.out.println( "Error: Try again." );
		Room.clearConsole();
		System.out.println( "Rebooting simulator..." );
		Thread.sleep( 400 );
		System.out.print( "Modifying algorithms..." ); Thread.sleep( 750 ); System.out.print( ".......Done");
		System.out.println();
		System.out.print( "Reconstructing emotional matrices..." ); Thread.sleep( 500 ); System.out.print( ".......Done");
		System.out.println();
		System.out.print( "Fabricating dilemmas..." ); Thread.sleep( 1200 ); System.out.print( ".......Done");
		System.out.println();
		System.out.print( "Processing..." ); Thread.sleep( 1000 ); System.out.print( ".......Done");
		Room.init( new Room1() );

	}
}
