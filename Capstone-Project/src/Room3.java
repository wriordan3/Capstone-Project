import java.util.ArrayList;
import java.util.Scanner;

public class Room3 implements Room {

	@Override
	public void play() throws InterruptedException {
		Room.setRoom( this );
		Room.clearConsole();
		System.out.println("\nYou rest before you leave the outpost with Echo the next day, now hiking North towards a range of snow-capped mountains."
				+ "\nThe crimson light of the rising sun paints a stunning reflection across their peaks.");
		System.out.println( "\nEcho:  Anomaly: My brothers and sisters have been transmitting their locations ever since I found you.");
		System.out.println(   "       Observation: One appears to be nearby at the foot of the nearby mountain range.");
		System.out.println(   "\nHow will you respond?");
		System.out.println(   "1) Siblings?");
		System.out.println(   "2) What were they doing there?" );
		System.out.println(   "3) Say nothing.");
		int selection = Room.getSelection(kbd, 3 );
		Room.clearConsole();
		
		if( selection == 0 ) {
			System.out.println( "\nEcho:  Statement: Father created z7z~SEVEN~7z7 of us to look after home in his absence." );
			System.out.println( "\n\nYou begin mouthing the words you wish to ask your ever-confusing companion, but once again your sound was silenced.");
			System.out.println( "Echo's monitor begins to flash purple as an unfamiliar voice assaults your conscious mind:");
			System.out.println( "\n\"I am creator...");
			System.out.println( "     destroyer...");
			System.out.println( "     father." );
			System.out.println( "\n...who are you?\"");
			System.out.println( "\nYour vision fades again. When you come to, you've arrived at a clearing near your destination, already noon and with no memory of your journey.");
			Room.clearConsole();
		}
		
		else if( selection == 1 ) {
			System.out.println( "\nEcho:  Statement: My siblings and I are constantly taking data from the planet and reporting back to Father." );
			System.out.println( "\n\nYou begin mouthing the words you wish to ask your ever-confusing companion, but once again your sound was silenced.");
			System.out.println( "Echo's monitor begins to flash purple as an unfamiliar voice assaults your concscious mind:");
			System.out.println( "\nI am creator...");
			System.out.println( "     destroyer...");
			System.out.println( "     father." );
			System.out.println( "\n...who are you?");
			System.out.println( "\nYour vision fades again. When you come to, you've arrived at a clearing near your destination, already noon and with no memory of your journey.");
			Room.clearConsole();
		}
		
		else if( selection == 2 ) {
			System.out.println( "\nYou make the hike in silence, paying no mind to your new robotic companion and his glitchy vocalizer." );
			System.out.println( "After about an hour of travelling, you are ambushed by a small pack of Dracobirds.");
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
			ArrayList<EnemySkill> enemySkills2 = new ArrayList<EnemySkill>();
			enemySkills.add( new EnemySkill( false, 1, 10, 8, 6, "Charge", "The Dracobird charges to deal up to 15 damage. 8 + d6 to hit." ));
			enemySkills.add( new EnemySkill( false, 1, 7, 11, 9, "Slash", "The Dracobird slashes to deal up to 10 damage. Guaranteed hit, can crit."));
			enemySkills2.add( new EnemySkill( false, 1, 15, 10, 12, "Alpha Charge", "The Dracobird Alpha charges to deal up to 15 damage. 10 + d12 to hit, can crit." ));
			enemySkills2.add( new EnemySkill( false, 1, 10, 13, 9, "Alpha Slash", "The Dracobird Alpha slashes to deal up to 15 damage. Guaranteed hit, can crit."));
			enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
			enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
			enemies.add( new Enemy( 75, "Dracobird Alpha", "Named for it's resemblance to a dragon, the Dracobird Alpha is a two legged, 8-foot tall flightless bird known for having the brightest patterns and most intimidating crest in it's pack.", 8, enemySkills2 ));
			Thread.sleep(1000);
			System.out.println( enemies.get( 0 ).toString());
			System.out.println( enemies.get( 2 ).toString());
			Room.clearConsole();
			Combat c = new Combat( Room.getPlayer(), enemies );
			if( !c.combat()) System.exit(0);
			System.out.println( "\nYou fend off the dracobirds and continue towards your destination without saying a word. If not for Echo announcing your arrival, the silence may have never broken.");
		}
		
		System.out.println(   "\nEcho:  Public Service Announcement: We have arrived!" );
		if(Room.getPlayer().getAlignment().getSecond().equals( Trait.GOOD)) System.out.println( 	"       Suggestion: With your brawn, we can retrieve the parts much quicker." ); //suggests that you follow because you have before
		if(Room.getPlayer().getAlignment().getSecond().equals( Trait.NEUTRAL2)) System.out.println( "        Statement: If you're willing, I could certainly use protection while I recover the parts." ); //takes an independent approach, expecting you to remain neutral.
		if(Room.getPlayer().getAlignment().getSecond().equals( Trait.EVIL)) System.out.println( 	"     Interjection: I don't suppose you'll help me recover the parts, so I won't ask." );
		System.out.println(   "\nHow will you respond?");
		System.out.println(   "1) Sure, I'll help.");
		System.out.println(   "2) Say nothing but follow anyways." );
		System.out.println(   "3) Heck no, get them yourself.");
		selection = Room.getSelection(kbd, 3 );
		
		if( selection == 0 ) {
			if(Room.getPlayer().getAlignment().getSecond().equals( Trait.EVIL)) System.out.println( "Echo: Observation: What a pleasant surprise!" );
			//Follow echo, lawful good, combat.
			Room.addTraitPoint( Trait.LAWFUL, 7 );
			Room.addTraitPoint( Trait.GOOD, 7);
			System.out.println( "\nEcho loops around you a few times, playing back excited beeps and tones before leading the way.");
			System.out.println("\nYou follow Echo a short ways through a rock scramble and find his sibling's round chassis laying on the ground, monitor blinking purple" );
			System.out.println( "As Echo begins to disassemble his fallen comrade, you are both ambushed by a new creature.");
			Room.clearConsole();
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
			enemySkills.add( new EnemySkill( false, 1, 20, 8, 6, "Tackle", "The Pachy charges head first, dealing high damage but with low accuracy. 8 + d6 to hit." ));
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
			
			System.out.println( "Echo transmits data on the creature you are about to face to your suit...\n" );
			System.out.println( enemies.get( 0 ).toString());
			Room.clearConsole();
			Combat c = new Combat( Room.getPlayer(), enemies );
			if( !c.combat() ) System.exit(0);
			System.out.println( "\nEcho:  Wonderful news, " + Room.getPlayer().getName() + ": I've repaired my damaged vocalizer!");
		}
		else if( selection == 1 ) {
			//Follow echo, Chaotic neutral, combat.
			Room.addTraitPoint( Trait.CHAOTIC, 7 );
			System.out.println( "\nLeaving you to decide for yourself, Echo begins to search for the robot on his own.");
			System.out.println("\nYou follow Echo a short ways through a rock scramble and find his sibling's round chassis laying on the ground, monitor blinking purple" );
			System.out.println( "As Echo begins to disassemble his fallen comrade, you are both ambushed by a new creature.");
			ArrayList<Enemy> enemies = new ArrayList<Enemy>();
			ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
			enemySkills.add( new EnemySkill( false, 1, 20, 8, 6, "Tackle", "The Pachy charges head first, dealing high damage but with low accuracy. 8 + d6 to hit." ));
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
			System.out.println( "Echo transmits data on the creature you are about to face to your suit..." );
			System.out.println( enemies.get( 0 ).toString());
			Room.clearConsole();
			Combat c = new Combat( Room.getPlayer(), enemies );
			if( !c.combat() ) System.exit(0);
			System.out.println( "\nEcho:  Wonderful news, " + Room.getPlayer().getName() + ": I've repaired my damaged vocalizer!");
		}
		else if( selection == 2 ) {
			if(Room.getPlayer().getAlignment().getSecond().equals( Trait.GOOD)) System.out.println( 	"Echo: Query: What's gotten into you today?" );
			Room.addTraitPoint( Trait.LAWFUL, 7 );
			Room.addTraitPoint( Trait.EVIL, 7);
			System.out.println( "\nEcho lets out an ear-piercing sequence of loud and abrasive signals which you can only assume are some sort of censored language before carrying on alone.");
			System.out.println( "\nYou find yourself getting hungry as you wait for Echo. You don't know how long it will take, should you forage for food?");
			System.out.println( "1) Yes." );
			System.out.println( "2) No." );
			selection = Room.getSelection( kbd,  2 );
			Room.clearConsole();
			if( selection == 0 ) {
				System.out.println( "\nYou come across a nearby copse bearing colorful fruit and decide to try one.");
				System.out.println( "It tastes fine at first, but as you walk back towards the rocks you feel yourself getting weaker. You sit and wait for Echo, hoping he'll know what to do.");
				Thread.sleep( 1500 );
				System.out.println( "You feel like you are about to pass out, and the sun seems to streak across the sky a hundred times." );
				System.out.println( "In your trance, you can't move or think. You feel like you're going to be sick.");
				Room.getPlayer().setMaxHP( Room.getPlayer().getMaxHP() - 10 );
				
			}
			else if( selection == 1 ) {
				System.out.println( "While you wait, you hear rustling in the nearby bushes.");
				System.out.println( "You get up to look, and as you reach for your firearm you're ambushed by an unknown creature.");
				ArrayList<Enemy> enemies = new ArrayList<Enemy>();
				ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
				
				if( Room.getPlayer().getSkills().size() > 2 ) {
					boolean isAugmented = Room.getPlayer().getSkills().get( 2 ).isAugmented();
					PlayerSkill echoSkill = Room.getPlayer().getSkills().get(2);
					Room.getPlayer().getSkills().remove( 2 );
					enemySkills.add( new EnemySkill( false, 1, 20, 8, 6, "Tackle", "??? charges head first, dealing high damage but with low accuracy. 8 + d6 to hit." ));
					enemies.add( new Enemy( 80, "???", "???", 8, enemySkills ));
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
					System.out.println( "Echo is not around to transmit data or heal you during combat" );
					Room.clearConsole();
					Combat c = new Combat( Room.getPlayer(), enemies );
					if( !c.combat() ) System.exit(0);
					Room.getPlayer().getSkills().add( echoSkill );
				} else {
				
					enemySkills.add( new EnemySkill( false, 1, 20, 8, 6, "Tackle", "??? charges head first, dealing high damage but with low accuracy. 8 + d6 to hit." ));
					enemies.add( new Enemy( 80, "???", "???", 8, enemySkills ));
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
					System.out.println( "Echo is not around to transmit data or heal you during combat" );
					Room.clearConsole();
					Combat c = new Combat( Room.getPlayer(), enemies );
					if( !c.combat() ) System.exit(0);
				}
				
			}
			System.out.println( "\nEcho:  Wonderful news, " + Room.getPlayer().getName() + ": I've repaired my damaged vocalizer!");
			System.out.println( "       I hope you didn't eat any of those poisonous 'blueberries' by the way. I can't have you getting sick during my monologue!" );
		}
		System.out.println(     "       We should return soon. It's time for me to answer all of your questions..."
							  + "\n       It all started when my z7z~fAth-E-rr~~~...." );
		
		System.out.println( "\nIt's happening again. It doesn't make you any less uneasy, but at least you don't have to listen to Echo...");
		System.out.println( "\nThis time you hear no voices in your dream, but rather a streak of fire across a morning sky faded from crimson to violet followed by a tower of smoke in the distance." );
		HomeRoom.getInstance().addMission( new Room4(), "Go to the place you saw in your dream. (Recommended Level: 3)");
		HomeRoom.getInstance().addMission( new Room4a(), "Find more of Echo's siblings. (Recommended Level: 4)");
		int scrap = 7;
		Room.getPlayer().addCurrency( scrap );
		System.out.printf( "\nYou found %d scrap on this mission. Total: %d",  scrap, Room.getPlayer().getCurrency());
		HomeRoom.getInstance().play();
	}
	
	

}
