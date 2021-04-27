
public class Room7 implements Room {
	private int state;
	
	protected Room7( int s ) {
		state = s;
	}
	@Override
	public void play() throws InterruptedException {
		if( state == 0 ) { //Sided with brother in forest
			System.out.println( "The Son points to you and in an instant you feel your body twist and stretch as you're suddenly drawn through time and space.");
			System.out.println( "You come to in what appears to be an endless server room, standing in front of a purple console.");
			System.out.println( "\nThe Son: Place your hand on the console and we can recreate this world.");
			System.out.println( "You place your hand on the console interface and your entire vision goes black.");
			Room.init( new EndingB() );
		}
		if( state == 1 ) { //sided with echo in forest
			System.out.println( "You try to run with Echo, but in an instant you feel your body twist and stretch as you're suddenly drawn through time and space.");
			System.out.println( "You come to in what appears to be an endless server room, standing in front of a purple console.");
			System.out.println( "Echo is functioning again by your side, and The Son is there too." );
			System.out.println( "\nThe Son: Place your hand on the console so I can recreate this world.");
			Room.clearConsole();
			System.out.println( "You place your hand on the console interface and your entire vision goes black.");
			Room.init( new EndingC() );
		}
		if( state == 3 ) { //Defeated brother at outpost using frequency emitter
			System.out.println( "You come to in what appears to be an endless server room, standing in front of a purple console.");
			System.out.println( "The Son: I never expected you would be so special. What a shame you have to take my place so I can be free." );
			System.out.println( "         We could have been gods together, but I'm an only-child.");
			System.out.println( "Echo: No, " + Room.getPlayer().getName() + "! You don't have to!");
			System.out.println( "      Purge the system, and The Son and I with it. Its the only way to save humanity.");
			System.out.println( "      Only someone who can use Father's technology can." );
			System.out.println( "\nWhat will you do?" );
			System.out.println( "1) Touch the console.");
			System.out.println( "2) Purge system.");
			int selection = Room.getSelection( kbd, 2 );
			
			if( selection == 0 ) {
				System.out.println( "You place your hand on the console interface and your entire vision goes black.");
				Room.init( new EndingB() );
			}
			else {
				System.out.println( "You activate the frequency emitter one more time, hoping to purge the system. Your vision goes black." );
				Room.init( new EndingC() );
			}
		}

	}

}
