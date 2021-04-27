import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class HomeRoom implements Room {
	private List< Room > missions;
	private List< String > missionStrings;
	private static HomeRoom thisInstance = null;
	private boolean firstVisit;
	
	private Hashtable<String, Integer> qmstock = new Hashtable<String, Integer>();
	private Hashtable<String, Integer> exostock = new Hashtable<String, Integer>();
	
	private HomeRoom( List<Room> _missions, List<String> _missionStrings ) {
		missions = _missions;
		missionStrings = _missionStrings;
		firstVisit = true;
		
		qmstock.put( "Extended Barrel: Longer barrel for higher muzzle velocity. Increase damage +3", 10 );
		qmstock.put( "Reinforced Reciever: Stronger mechanisms allow for more pressure to be generated without compromising your weapon. Increase damage +5", 15 );
		qmstock.put( "Superheated Projectiles: Stronger mechanisms allow for more pressure to be generated without compromising your weapon. Increase damage +10", 30 );
		
		exostock.put( "Light Armor Mod: Dracobird leather reinforcement provides a slight bonus to protection. Increase armor class +1", 10 );
		exostock.put( "Improved Response Package: Exosuit responds to your actions much quicker. Increase armor class +2", 15 );
		exostock.put( "Titanium Mesh: Titanium mesh underlay drastically improves resilience. Increase armor class +3", 30 );
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
		for( Room r : missions ) {
			if( r.equals( room ) ) {
				missions.remove( r );
			}
		}
		for( int i = 0; i < missionStrings.size(); i++  ) {
			if( missionStrings.get(i).equals( missionText ) ) {
				missionStrings.remove( i );
			}
		}
	}
	
	public List<Room> getMissions() {
		return missions;
	}
	
	public List<String> getMissionStrings() {
		return missionStrings;
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
			firstVisit = false;
		}
		//Main.saveGame();
		Room.getPlayer().setMaxHP( 65 + (10*Room.getPlayer().getLevel() ));
		Room.getPlayer().levelUp();
		Room.clearConsole();
		boolean isDone = false;
		while( !isDone ) {
			System.out.println( "\nWhere will you go?\n" );
			System.out.println( "1) Quartermaster" );
			System.out.println( "2) Exosuit Specialist" );
			System.out.println( "3) Medical Facility" );
			System.out.println( "4) Exit Game" );
			for( int i = 0; i < missionStrings.size(); i++ ) {
				System.out.println( (i+5 ) + ") " + missionStrings.get( i ) );
			}
			String selection = kbd.next();
			Boolean isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > missionStrings.size() + 4 || Integer.parseInt( selection ) <  1 ) {
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
			else if( Integer.parseInt( selection ) == 4 ) {
				System.exit( 0 );
			}
			else {
				nextRoom = missions.get( Integer.parseInt( selection ) - 5 );
				missions.remove( Integer.parseInt( selection ) - 5 );
				missionStrings.remove( Integer.parseInt( selection ) - 5 );
				isDone = true;
			}
		}
		nextRoom.play();
		
	}
	

	public void quarterMaster() {
		Room.clearConsole();
		boolean done = false;
		if( Room.getPlayer().getAlignment().getSecond() == Trait.GOOD ) {
			System.out.println( "The bipedal robot who seemingly operates this armory approaches you eagerly." );
			System.out.println( "\n\"Hello, friend. Shall I equip you with new armaments?\"");
		}
		
		if( Room.getPlayer().getAlignment().getSecond() == Trait.EVIL ) {
			System.out.println( "\nThe bipedal robot who seemingly operates this armory approaches you cautiously." );
			System.out.println( "\n\"I will equip you with new armaments if you wish, but please note that aggression will not be tolerated.\"");
		}
		else {
			System.out.println( "The bipedal robot who seemingly operates this armory approaches you curiously." );
			System.out.println( "\n\"Are you here to buy or browse?\"");
		}
		while( !done ) {
			System.out.printf( "\nTotal Scrap: %d\n", Room.getPlayer().getCurrency() );
			int i = 1;
			for( Entry<String, Integer> e : qmstock.entrySet() ) {
				System.out.printf( "%d) %s  -  %d scrap\n", i, e.getKey(),  e.getValue() );
				i++;
			}
			System.out.printf( "%d) Leave\n", i);
			int selection = Room.getSelection( kbd, i );
			if( selection == i - 1 ) {
				done = true;
				Room.clearConsole();
			}
			if( selection == 0 )  {
				if( Room.getPlayer().getCurrency() >= 10 ) {
					Weapon currentWeapon = Room.getPlayer().getWeapon();
					Room.getPlayer().setWeapon( new Weapon( currentWeapon.getDamage() + 3, currentWeapon.getName() + " - Extended Barrel", currentWeapon.getDescription() + "(+3 damage)" ));
					qmstock.remove( "Extended Barrel: Longer barrel for higher muzzle velocity. Increase damage +3");
					Room.getPlayer().addCurrency( -10 );
				}
				else {
					System.out.println( "You can't afford that." );
					Room.clearConsole();
				}
			}
			if( selection == 1 )  {
				if( Room.getPlayer().getCurrency() >= 15 ) {
					Weapon currentWeapon = Room.getPlayer().getWeapon();
					Room.getPlayer().setWeapon( new Weapon( currentWeapon.getDamage() + 5, currentWeapon.getName() + " - Reinforced Reciever", currentWeapon.getDescription() + "(+5 damage)" ));
					qmstock.remove( "Reinforced Reciever: Stronger mechanisms allow for more pressure to be generated without compromising your weapon. Increase damage +5" );
					Room.getPlayer().addCurrency( -15 );
				}
				else {
					System.out.println( "You can't afford that." );
					Room.clearConsole();
				}
			}
			if( selection == 2 )  {
				if( Room.getPlayer().getCurrency() >= 30 ) {
					Weapon currentWeapon = Room.getPlayer().getWeapon();
					Room.getPlayer().setWeapon( new Weapon( currentWeapon.getDamage() + 10, currentWeapon.getName() + " - Superheated Projectiles", currentWeapon.getDescription() + "(+10 damage)" ));
					qmstock.remove( "Superheated Projectiles: Stronger mechanisms allow for more pressure to be generated without compromising your weapon. Increase damage +10" );
					Room.getPlayer().addCurrency( -30 );
				}
				else {
					System.out.println( "You can't afford that." );
					Room.clearConsole();
				}
			}
		}
	}
	public  Hashtable<String, Integer> qmStock() {
		return qmstock;
	}
	
	public void exosuitSpecialist() {
		Room.clearConsole();
		if( Room.getPlayer().getAlignment().getFirst() == Trait.LAWFUL ) {
			System.out.println( "\nA group of five small pipedal robots approach you, various tools in hand. They speak in unison:" );
			System.out.println( "\n\"Your exosuit is in exceptional condition. Would you like to apply some modifications?\"");
		}
		if( Room.getPlayer().getAlignment().getFirst() == Trait.CHAOTIC ) {
			System.out.println( "\nA group of five small pipedal robots approach you, various tools in hand. They speak in unison:" );
			System.out.println( "\n\"You seem to be rather unorthodox in your exosuit usage. Would you like to apply some modifications?\"");
		}
		else {
			System.out.println( "\nA group of five small pipedal robots approach you, various tools in hand. They speak in unison:" );
			System.out.println( "\n\"Would you like to apply some exosuit modifications?\"");
		}
		boolean done = false;
		while( !done ) {
			System.out.printf( "\nTotal Scrap: %d\n", Room.getPlayer().getCurrency() );
			int i = 1;
			for( Entry<String, Integer> e : exostock.entrySet() ) {
				System.out.printf( "%d) %s  -  %d scrap\n", i, e.getKey(),  e.getValue() );
				i++;
			}
			System.out.printf( "%d) Leave\n", i);
			int selection = Room.getSelection( kbd, i );
			if( selection == i - 1 ) {
				done = true;
				Room.clearConsole();
			}
			if( selection == 0 )  {
				if( Room.getPlayer().getCurrency() >= 10 ) {
					Armor currentArmor = Room.getPlayer().getArmor();
					Room.getPlayer().setArmor( new Armor( currentArmor.getArmorClassModifier() + 1, currentArmor.getName() + " - Light Armor Mod", currentArmor.getDescription() + "(+1 AC)" ));
					exostock.remove( "Light Armor Mod: Dracobird leather reinforcement provides a slight bonus to protection. Increase armor class +1");
					Room.getPlayer().addCurrency( -10 );
				}
				else {
					System.out.println( "You can't afford that." );
					Room.clearConsole();
				}
			}
			if( selection == 1 )  {
				if( Room.getPlayer().getCurrency() >= 15 ) {
					Armor currentArmor = Room.getPlayer().getArmor();
					Room.getPlayer().setArmor( new Armor( currentArmor.getArmorClassModifier() + 2, currentArmor.getName() + " - Improved Response Package", currentArmor.getDescription() + "(+3 AC)" ));
					exostock.remove( "Improved Response Package: Exosuit responds to your actions much quicker. Increase armor class +2" );
					Room.getPlayer().addCurrency( -15 );
				}
				else {
					System.out.println( "You can't afford that." );
					Room.clearConsole();
				}
			}
			if( selection == 2 )  {
				if( Room.getPlayer().getCurrency() >= 30 ) {
					Armor currentArmor = Room.getPlayer().getArmor();
					Room.getPlayer().setArmor( new Armor( currentArmor.getArmorClassModifier() + 3, currentArmor.getName() + " - Titanium Mesh", currentArmor.getDescription() + "(+3 AC)" ));
					exostock.remove( "Titanium Mesh: Titanium mesh underlay drastically improves resilience. Increase armor class +3" );
					Room.getPlayer().addCurrency( -30 );
				}
				else {
					System.out.println( "You can't afford that." );
					Room.clearConsole();
				}
			}
		}
	}
	public  Hashtable<String, Integer> exoStock() {
		return exostock;
	}
	
	public void medicalFacility() {
		Room.clearConsole();
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
		Room.clearConsole();
	}
}
