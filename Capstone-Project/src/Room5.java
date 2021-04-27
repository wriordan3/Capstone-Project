

public class Room5 implements Room {
	//Went with echo to find escape pod
	
	private String turtle1 = 
			  "         .,-;-;-,. /'_\\\r\n"
			+ "       _/_/_/_|_\\_\\) /\r\n"
			+ "     '-<_><_><_><_>=/\\\r\n"
			+ "jgs~~~~`/_/====/_/-'\\_\\~~~~\r\n"
			+ "        \"\"     \"\"    \"\"";
	private String turtle2 = 
			  "    .,-;-;-,. /'_\\\r\n"
			+ "  _/_/_/_|_\\_\\) /\r\n"
			+ "'-<_><_><_><_>=/\\\r\n"
			+ "  `/_/====/_/-'\\_\\~~~~\r\n"
			+ "   \"\"     \"\"    \"\"";
	
	@Override
	public void play() throws InterruptedException {
		if( Room.getPlayer().getAlignment().getFirst().equals( Trait.CHAOTIC ) || Room.getPlayer().getAlignment().getSecond().equals( Trait.EVIL )) {
			System.out.println( "Echo: I'm impressed, " + Room.getPlayer().getName() + ", I didn't expect you to care.");
		}
		if( Room.getPlayer().getAlignment().getFirst().equals( Trait.LAWFUL ) && Room.getPlayer().getAlignment().getSecond().equals( Trait.GOOD)) {
			System.out.println( "Echo: That's the " + Room.getPlayer().getName() + "!" );
		}
		System.out.println( "      The crash was near where I found you. We should start there");
		Room.clearConsole();
		System.out.println( turtle1 );
		System.out.println( turtle2 );
		System.out.println( "As you approach the forest, group of large tortoise-like creatures begin charging towards you at surprisingly high speeds." );
		System.out.println( "What will you do?");
		System.out.println( "1) Stand your ground." );
		System.out.println( "2) Run away." );
		System.out.println( "3) Throw Echo." );
		
		int selection = Room.getSelection( kbd,  3 );
		
		Room.clearConsole();
		if( selection == 0 ) {
			System.out.println( turtle1 );
			System.out.println( turtle2 );
			Room.addTraitPoint(Trait.LAWFUL, 7 );
			System.out.println( "The enormous creatures determine you not to be a threat to them.");
			System.out.println( "They charge past you paying no mind at all.");
			
		}
		if( selection == 1  ) {
			System.out.println( "You and echo begin to flee before realizing that the creatures were not chasing you at all.");
		}
		if( selection == 2 ) {
			System.out.println( turtle1 );
			System.out.println( turtle2 );
			Room.addTraitPoint( Trait.CHAOTIC, 7 );
			Room.addTraitPoint( Trait.EVIL, 7 );
			System.out.println( "You grab hold of Echo and hurl him towards the creatures.");
			System.out.println( "He lets out a loud sequence of earpiercing beeps, followed by the crisp clank of him ricocheting off the creature's shell");
			System.out.println( "The creatures continue to stampede through you. Take 15 damage." );
			Room.getPlayer().takeDamage( 15 );
			
			Room.clearConsole();
			System.out.println( "Echo looks down on you as you find your footing, shaking rhythmically and letting out a series of cheerful beeps." );
			System.out.println( "This must be his way of laughing at you." );
			System.out.println( "Echo: Yes that was really smart " + Room.getPlayer().getName() + ", I can tell your plan worked perfectly...");
			System.out.println( "      Get up, we don't have time for this.\n" );
		}
		
		System.out.println( "Echo: We aren't far now. Just a little ways left to go." );
		Room.clearConsole();
		int scrap = 5;
		Room.getPlayer().addCurrency( scrap );
		System.out.printf( "\nYou found %d scrap on this mission. Total: %d",  scrap, Room.getPlayer().getCurrency());
		Room.clearConsole();
		Room.init( new Room6b() );
	}

}
