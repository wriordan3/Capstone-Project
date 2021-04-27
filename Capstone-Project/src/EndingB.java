
public class EndingB implements Room {

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
		if(Room.getPlayer().getAlignment().getFirst().equals(Trait.LAWFUL) && Room.getPlayer().getAlignment().getSecond().equals( Trait.EVIL ) ) {
			System.out.println( "I am not surprised that you would give in to my son." );
			System.out.println( "Perhaps I made the wrong choice after all.");
		}
		else if( Room.getPlayer().getAlignment().getFirst().equals( Trait.CHAOTIC) && !Room.getPlayer().getAlignment().getSecond().equals( Trait.GOOD )) {
			System.out.println( "Did you allow my creation to be destroyed for fun?");
			System.out.println( "Perhaps I made the wrong choice after all.");
		}
		else {
			System.out.println( "Or so that's what I thought. Perhaps nothing can stop my Son...");
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
