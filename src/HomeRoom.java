import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeRoom implements Room {
	private List< Room > missions;
	private List< String > missionStrings;
	private static HomeRoom thisInstance = null;
	private boolean firstVisit;
	
	private HomeRoom( List<Room> _missions, List<String> _missionStrings ) {
		missions = _missions;
		missionStrings = _missionStrings;
		firstVisit = true;
	}
	
	public static HomeRoom getInstance() {
		if( thisInstance == null ) {
			thisInstance = new HomeRoom( new ArrayList<Room>(), new ArrayList<String>() );
		}
		return thisInstance;
	}
	
	public void addMission( Room room, String missionText ) {
		missions.add( room );
		missionStrings.add( missionText );
	}
	public void removeMission( Room room, String missionText ) {
		missions.remove( room );
		missionStrings.remove( missionText );
	}

	@Override
	public void play() throws InterruptedException {
		Room nextRoom = null;
		if( firstVisit ) {
			System.out.println( "As you enter the outpost, you immediately take note that there are no people around, only more robots.");
			System.out.println( "Some are bipedal, some are rovers, and some even hover at eye level, but all are communicating the same thing:" );
			Thread.sleep( 2000 );
			System.out.println( "\nTHE FIRST HAS ARRIVED. THE FIRST HAS ARRIVED.");
			System.out.println( "BEGIN OPERATION: SOTER" );
			Thread.sleep( 2000 );
			System.out.println( "Each robot moves to seemingly take their posts. Small metal buildings neatly organized on one main walkway light up in an almost festive manner."
					+ "\nEach one is clearly labeled, it seems. This outpost is meant to be a supply post for humans, and you are the first." );
		}
		Room.getPlayer().levelUp();
		Scanner kbd = new Scanner( System.in );
		boolean isDone = false;
		while( !isDone ) {
			System.out.println( "\nWhere will you go?\n" );
			System.out.println( "1) Quartermaster" );
			System.out.println( "2) Exosuit Specialist" );
			System.out.println( "3) Medical Facility" );
			for( int i = 0; i < missionStrings.size(); i++ ) {
				System.out.println( (i+4 ) + ") " + missionStrings.get( i ) );
			}
			String selection = kbd.next();
			Boolean isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > missionStrings.size() + 3 || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;

				}
			}
			if( Integer.parseInt( selection ) == 1) {
				quarterMaster();
			}
			else if( Integer.parseInt( selection ) == 2) {
				exosuitSpecialist();
			}
			else if( Integer.parseInt( selection ) == 3) {
				medicalFacility();
			}
			else {
				nextRoom = missions.get( Integer.parseInt( selection ) - 4 );
				isDone = true;
			}
		}
		nextRoom.play();
		
	}
	
	public void quarterMaster() {
		if( Room.getPlayer().getAlignment().getSecond() == Trait.GOOD ) {
			System.out.println( "The bipedal robot who seemingly operates this armory approaches you eagerly." );
			System.out.println( "\n\"Hello, friend. Shall I equip you with new armaments?\"");
		}
		if( Room.getPlayer().getAlignment().getSecond() == Trait.EVIL ) {
			System.out.println( "\nThe bipedal robot who seemingly operates this armory approaches you cautiously." );
			System.out.println( "\n\"I will equip you with new armaments if you wish, but please note that aggression will not be tolerated.\"");
		}
	}
	public void exosuitSpecialist() {
		if( Room.getPlayer().getAlignment().getFirst() == Trait.LAWFUL ) {
			System.out.println( "\nA group of five small pipedal robots approach you, various tools in hand. They speak in unison:" );
			System.out.println( "\n\"Your exosuit is in exceptional condition. Would you like to apply some modifications?\"");
		}
		if( Room.getPlayer().getAlignment().getFirst() == Trait.CHAOTIC ) {
			System.out.println( "\nA group of five small pipedal robots approach you, various tools in hand. They speak in unison:" );
			System.out.println( "\n\"You seem to be rather unorthodox in your exosuit usage. Would you like to apply some modifications?\"");
		}
	}
	public void medicalFacility() {
		if( Room.getPlayer().getCurrentHP() == Room.getPlayer().getMaxHP() ) {
			System.out.println( "\nYou are already in exceptional health. Leaving Medical Facility." );
		} else {
			if( Room.getPlayer().getCurrentHP() >= Room.getPlayer().getMaxHP()/2 ) {
				System.out.println( "\nYou are directed to a medical capsule by a robot standing at a workstation near the entrance." );
				System.out.println( "You remove your exosuit and enter the capsule. Laying on your back, the roof slides closed above you. An artificial voice says:");
				System.out.println( "\n\"Subject in moderate condition. Applying nanite treatment." );
				System.out.println( "\nA small swarm of microscopic robots enters the capsule through the oxygen vents. You feel no pain as they gather around your afflicted areas and work." );
				Room.getPlayer().restoreHealth();
			}
			if( Room.getPlayer().getCurrentHP() <= Room.getPlayer().getMaxHP()/2 ) {
				System.out.println( "\nYou are directed to a medical capsule by a robot standing at a workstation near the entrance." );
				System.out.println( "You limp to the medical bay, remove your exosuit and enter the capsule. Laying on your back, the roof slides closed above you. An artificial voice says:");
				System.out.println( "\n\"Subject in near critical condition. Applying anaesthetic and hyper-aggressive nanite treatment." );
				System.out.println( "\nYou go unconscious in a matter of seconds. You awake to find neither scarring nor pain in any of your previously damaged areas." );
				Room.getPlayer().restoreHealth();
			}
		}
	}
}
