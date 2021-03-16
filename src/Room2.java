import java.util.Scanner;

public class Room2 implements Room {
	private int state;
	public Room2( int state ) {
		this.state = state;
	}
	public static boolean init( int state ) {
		Room.setRoom( new Room2( state ));
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
		Scanner kbd = new Scanner( System.in );
		String selection = "";
		boolean isValid = false;
		Thread.sleep( 3000 );
		System.out.println( "\n" );
		if( this.state == 1 ) {//went to outpost, first combat
			//Robot thanks for protection
			//
			System.out.println( "Unfamiliar Robot: Statement: 3-CH0 is grateful for your assistance, Stranger. I am programmed to allow humans to call me Echo." 
							  + "\n                      Query: What should 3-CH0 call you?" );
			Thread.sleep( 1000 );
			System.out.println( "\nHow will you respond?"
					+ "\n1) \"It's no problem. My name is " + Room.getPlayer().getName() + "."
					+ "\n2) \"My name is " + Room.getPlayer().getName() + ". Why do you talk like that?" );
			selection = kbd.next();
			isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > 2 || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;
				}
			}
			if( Integer.parseInt( selection ) == 1 ) {
				System.out.println( "\nEcho: Statement: It is nice to meet you, " + Room.getPlayer().getName() + "."
								  + "\n      Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
				Room.addTraitPoint( Trait.GOOD, 1 );
			}
			if( Integer.parseInt( selection ) == 2 ) {
				Room.addTraitPoint( Trait.EVIL, 1 );
				System.out.println( "\nEcho: Counter-Query: Do all humans open with such personal questions, " + Room.getPlayer().getName() + "?"
						  		  + "\n          Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
			}
			Thread.sleep( 1000 );
			System.out.println( 	"\n         Suggestion: Once we reach Lazarus Outpost, you can help me find replacement parts.");
			Thread.sleep( 2000 );
			System.out.println( ""
					+ "\nBefore you can decide yourself, you respond with a somber, involuntary \"Yes.\". " );
			HomeRoom.getInstance().addMission( new Room4(), "Find replacement parts for Echo. (Recommended Level: 2" );
			Thread.sleep( 1000 );
			System.out.println( "\nYou can't tell whether you are in control, or simply a character in someone else's game.");
		}
		else if( this.state == 2 ) {//went to outpost or started fire without finding other robot, ran
			//Robot judges you for running
			//If you abandoned the robot, special dialogue
			//Robot thanks for protection
			//
			System.out.println( "Unfamiliar Robot: Observation: Stranger has no spine."
					          + "\n                    Statement: Nevertheless, 3-CH0 is grateful for your assistance, Stranger. I am programmed to allow humans to call me Echo." 
							  + "\n                        Query: What should 3-CH0 call you?" );
			Thread.sleep( 1000 );
			System.out.println( "/nHow will you respond?"
					+ "\n1) \"It's no problem. My name is " + Room.getPlayer().getName() + "."
					+ "\n2) \"My name is " + Room.getPlayer().getName() + ". Why do you talk like that?" );
			selection = kbd.next();
			isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > 2 || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;
				}
			}
			if( Integer.parseInt( selection ) == 1 ) {
				System.out.println( "\nEcho: Statement: It is nice to meet you, " + Room.getPlayer().getName() + "."
								  + "\n      Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
				Room.addTraitPoint( Trait.GOOD, 1 );
			}
			if( Integer.parseInt( selection ) == 2 ) {
				Room.addTraitPoint( Trait.EVIL, 1 );
				System.out.println( "\nEcho: Counter-Query: Do all humans open with such personal questions, " + Room.getPlayer().getName() + "?"
						  		  + "\n          Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
			}
			Thread.sleep( 1000 );
			System.out.println( 	"\n         Suggestion: Once we reach Lazarus Outpost, you can help me find replacement parts.");
			Thread.sleep( 2000 );
			System.out.println( ""
					+ "\nBefore you can decide yourself, you respond with a somber, involuntary \"Yes.\". " );
			HomeRoom.getInstance().addMission( new Room4(), "Find replacement parts for Echo. (Recommended Level: 2" );
			Thread.sleep( 1000 );
			System.out.println( "\nYou can't tell whether you are in control, or simply a character in someone else's game.");
			
		}
		else if( this.state == 3 ) {//started fire and found other robot, combat
			//robot thanks for protection \
			//extended conversation about other bot
			System.out.println( "\nUnfamiliar Robot: Statement: 3-CH0 is grateful for your assistance, Stranger. I am programmed to allow humans to call me Echo." 
					  		  + "\n                      Query: What should 3-CH0 call you?" );
			Thread.sleep( 1000 );
			System.out.println( "\nHow will you respond?"
					+ "\n1) \"It's no problem. My name is " + Room.getPlayer().getName() + "."
					+ "\n2) \"My name is " + Room.getPlayer().getName() + ". Why do you talk like that?" );
			selection = kbd.next();
			isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > 2 || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;
				}
			}
			if( Integer.parseInt( selection ) == 1 ) {
				System.out.println( "\nEcho: Statement: It is nice to meet you, " + Room.getPlayer().getName() + "."
								  + "\n      Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
				Room.addTraitPoint( Trait.GOOD, 1 );
			}
			if( Integer.parseInt( selection ) == 2 ) {
				Room.addTraitPoint( Trait.EVIL, 1 );
				System.out.println( "\nEcho: Counter-Query: Do all humans open with such personal questions, " + Room.getPlayer().getName() + "?"
						  		  + "\n          Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
			}
			Thread.sleep( 1000 );
			System.out.println( 	"\n          Statement: My brother, the larger model who brought me to you, remotely activated distress signals from our other fallen siblings.");
			System.out.println(     "\n         Suggestion: You can take me to salvage parts from them so that I may make repairs.");
			Thread.sleep( 2000 );
			System.out.println( ""
					+ "\nBefore you can decide yourself, you respond with a somber, involuntary \"Yes.\". " );

			HomeRoom.getInstance().addMission( new Room4(), "Investigate the signals from Echo's 'brothers'. (Recommended Level: 2)" );
			Thread.sleep( 1000 );
			System.out.println( "\nYou can't tell whether you are in control, or simply a character in someone else's game.");
		}
		else if( this.state == 4 ) {//started fire and found other robot, ran
			//robot judges you for running
			//extended conversation about other bot
			System.out.println( "Unfamiliar Robot: Observation: Stranger has no spine."
			          + "\n                  Statement: Nevertheless, 3-CH0 is grateful for your assistance, Stranger. I am programmed to allow humans to call me Echo." 
					  + "\n                      Query: What should 3-CH0 call you?" );
			Thread.sleep( 1000 );
			System.out.println( "\nHow will you respond?"
					+ "\n1) \"It's no problem. My name is " + Room.getPlayer().getName() + "."
					+ "\n2) \"My name is " + Room.getPlayer().getName() + ". Why do you talk like that?" );
			selection = kbd.next();
			isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > 2 || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;
				}
			}
			if( Integer.parseInt( selection ) == 1 ) {
				System.out.println( "\nEcho: Statement: It is nice to meet you, " + Room.getPlayer().getName() + "."
								  + "\n      Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
				Room.addTraitPoint( Trait.GOOD, 1 );
			}
			if( Integer.parseInt( selection ) == 2 ) {
				Room.addTraitPoint( Trait.EVIL, 1 );
				System.out.println( "\nEcho: Counter-Query: Do all humans open with such personal questions, " + Room.getPlayer().getName() + "?"
						  		  + "\n          Statement: Those ZzZ-SAVAGE-zZz dracobirds damaged some of my components and now I speak like a 21st century virtual assistant." );
			}
			Thread.sleep( 1000 );
			System.out.println( 	"          Statement: My brother, the larger model who brought me to you, remotely activated distress signals from our other fallen siblings.");
			System.out.println(     "         Suggestion: You can take me to salvage parts from them so that I may make repairs.");
			Thread.sleep( 2000 );
			System.out.println( ""
					+ "\nBefore you can decide yourself, you respond with a somber, involuntary \"Yes.\". " );

			HomeRoom.getInstance().addMission( new Room4(), "Investigate the signals from Echo's 'brothers'. (Recommended Level: 2)" );
			Thread.sleep( 1000 );
			System.out.println( "\nYou can't tell whether you are in control, or simply a character in someone else's game.");
		}
		Thread.sleep( 2000 );
		System.out.println( "\nEcho: Exclamation: Wonderful!");
		System.out.println( "    Observation: We aren't far now. At average human walking pace, we should reach Lazarus outpost in approximately 2 hours, 4 minutes, and 46 seconds. ");
		Thread.sleep( 2000 );
		System.out.println( "\nYou want to ask Echo about the planet you are on, but once again a strange feeling overtakes you." );
		Thread.sleep( 1500 );
		System.out.println( "You feel time wash over you as two hours compresses to seconds. Images flash through your mind, but at the end you remember nothing.");
		Thread.sleep( 2000 );
		System.out.print( ".. except..." );
		Thread.sleep( 2000 );
		System.out.println( "\nEntity." );
		Thread.sleep( 1000 );
		System.out.println( "\nP#r$0n/\\." );
		Thread.sleep( 1000 );
		System.out.println( "\nBrother.");
		Thread.sleep( 5000 );
		HomeRoom.getInstance().play();
	}



}
