import java.util.ArrayList;

public class Room6a implements Room {
//Stayed back, echo went to find wreckage. He returns unsuccessful and the outpost is attacked by dracobirds and pachys
	@Override
	public void play() throws InterruptedException {
		int selection;
		System.out.println( "The other robots in the outpost pay no mind to you as they prepare for the arrival of another human.");
		if( Room.getPlayer().getAlignment().getFirst().equals( Trait.LAWFUL) && Room.getPlayer().getAlignment().getSecond().equals( Trait.GOOD ) ) {
			System.out.println( "You do everything you can to assist the robots while you pass the time." );
			Thread.sleep(1000);
			if( HomeRoom.getInstance().qmStock().containsKey( "Extended Barrel: Longer barrel for higher muzzle velocity. Increase damage +3" )) {
				System.out.println( "After helping the quartermaster organize his stock, he gives you a free weapon upgrade:" );
				System.out.println( "	Extended Barrel: Longer barrel for higher muzzle velocity. Increase damage +3" );
				HomeRoom.getInstance().qmStock().remove("Extended Barrel: Longer barrel for higher muzzle velocity. Increase damage +3");
				Weapon currentWeapon = Room.getPlayer().getWeapon();
				Room.getPlayer().setWeapon( new Weapon( currentWeapon.getDamage() + 3, currentWeapon.getName() + " - Extended Barrel", currentWeapon.getDescription() + "(+3 damage)" ));
			}
			Thread.sleep(1000);
			if( HomeRoom.getInstance().exoStock().containsKey( "Light Armor Mod: Dracobird leather reinforcement provides a slight bonus to protection. Increase armor class +1" )) {
				System.out.println( "The group of drones that perform maintenance on your exosuit install a free upgrade for helping them test new modifications:" );
				System.out.println( "	Light Armor Mod: Dracobird leather reinforcement provides a slight bonus to protection. Increase armor class +1" );
				HomeRoom.getInstance().exoStock().remove("Light Armor Mod: Dracobird leather reinforcement provides a slight bonus to protection. Increase armor class +1");
				Armor currentArmor = Room.getPlayer().getArmor();
				Room.getPlayer().setArmor( new Armor( currentArmor.getArmorClassModifier() + 1, currentArmor.getName() + " - Light Armor Mod", currentArmor.getDescription() + "(+1 AC)" ));
			}
		}
		else {
			System.out.println( "You find nothing to do while you pass the time, as the robots seem perfectly okay handling business on their own." );
		}
		Room.clearConsole();
		System.out.println( "Echo doesn't return until sundown, with a small group of pachies charging close behind!");
		System.out.println( "All of the lighting in the outpost begins flashing red, and alarms blare as Echo approaches.");
		if( !Room.getPlayer().completedMissions().isEmpty() ) {
			System.out.println( "With only one way in or out of the outpost, your only option is to drive them off somehow.");
			Thread.sleep( 1000 );
			System.out.println( "What will you do?" );
			System.out.println( "1) Defend the outpost." );
			System.out.println( "2) Use Frequency Emitter");
			
			selection = Room.getSelection( kbd, 2 );
			Room.clearConsole();
			if( selection == 0 ) {
				System.out.println( "You are ready at the gate when Echo and the pachies arrive.");
				ArrayList<Enemy> enemies = new ArrayList<Enemy>();
				ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
				enemySkills.add( new EnemySkill( false, 1, 20, 8, 6, "Tackle", "The Pachy charges head first, dealing high damage but with low accuracy. 8 + d6 to hit." ));
				enemies.add( new Enemy( 80, "Pachy", "A two legged reptile best known for its domed skull, the pachy is a frighteningly resilient enemy with remarkable strength.", 8, enemySkills ));
				enemies.add( new Enemy( 80, "Pachy", "A two legged reptile best known for its domed skull, the pachy is a frighteningly resilient enemy with remarkable strength.", 8, enemySkills ));
				System.out.println( "                                               ____\r\n"
						+ "  ___                                      .-~. /_\"-._\r\n"
						+ "`-._~-.                                  / /_ \"~o\\  :Y\r\n"
						+ "      \\  \\                                / : \\~x.  ` ')\r\n"
						+ "      ]  Y                              /  |  Y< ~-.__j\r\n"
						+ "     /   !                        _.--~T : l  l<  /.-~\r\n"
						+ "    /   /                 ____.--~ .   ` l /~\\ \\<|Y\r\n"
						+ "   /   /             .-~~\"        /| .    ',-~\\ \\L|\r\n"
						+ "  /   /             /     .^   \\ Y~Y \\.^>/l_   \"--'\r\n"
						+ " /   Y           .-\"(  .  l__  j_j l_/ /~_.-~    .\r\n"
						+ "Y    l          /    \\  )    ~~~.\" / `/\"~ / \\.__/l_\r\n"
						+ "|     \\     _.-\"      ~-{__     l  :  l._Z~-.___.--~\r\n"
						+ "|      ~---~           /   ~~\"---\\_  ' __[>\r\n"
						+ "l  .                _.^   ___     _>-y~\r\n"
						+ " \\  \\     .      .-~   .-~   ~>--\"  /\r\n"
						+ "  \\  ~---\"            /     ./  _.-'\r\n"
						+ "   \"-.,_____.,_  _.--~\\     _.-~\r\n"
						+ "               ~~     (   _}       \r\n"
						+ "                      `. ~(\r\n"
						+ "                        )  \\\r\n"
						+ "                  /,`--'~\\--'~\\   \r\n"
						+ "	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
				System.out.println( "Echo transmits data on the creatures you are about to face to your suit..." );
				System.out.println( enemies.get( 0 ).toString());
				System.out.println( enemies.get( 1 ).toString());
				Room.clearConsole();
				Combat c = new Combat( Room.getPlayer(), enemies );
				if( !c.combat() ) Room.init( new EndingA() ); //Player dies, had no respect for the haven created by the entity
				System.out.println( "As you strike the final blow you notice hordes of dracobirds, pachies, and other creatures surrounding the outpost" );
				System.out.println( "They back away slowly as a mysterious man steps forward, with long blonde hair and a pale complexion, wearing a black skin-tight suit");
				System.out.println( "He points to you and Echo and in an instant you feel your body twist and stretch as you're suddenly drawn through time and space.");
				Room.clearConsole();
				Room.init( new Room7( 1 ));
			}
			if( selection ==  1 ) {
				System.out.println( "You rush to the gate. As Echo reaches you, you activate the Frequency Transmitter." );
				System.out.println( "The pachies immediately shake their heads and come to halt, before casually retreating from the outpost.");
				System.out.println( "Even though you heard nothing, it was clear from the flickering of his monitor that the frequency had some effect on Echo.");
				Room.clearConsole();
				System.out.println( "A mysterious man approaches the gate, with long blonde hair and a pale complexion, wearing a black skin-tight suit" );
				System.out.println( "\nStranger: I'm impressed. I never would've expected a human to gain control over Father's technology");
				System.out.println( "          Perhaps you'll be useful after all..." );
				System.out.println( "\nHe points to you and Echo and in an instant you feel your body twist and stretch as you're suddenly drawn through time and space.");
				Room.init( new Room7( 3 ));
			}
		}
	}

}
