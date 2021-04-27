import java.util.ArrayList;
import java.util.Scanner;

public class Room1 implements Room {


	public static boolean init() {
		Room.setRoom( new Room1() );
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
		Room.clearConsole();
		System.out.println( " .. ........... .............  ........... . ..... ........ .......\r\n"
				+ " ......  ....................%.... .... ..... .........%............\r\n"
				+ " .@@@ ........ @@.... @@@@  . ............................  *  .....\r\n"
				+ " ....@@ ..... @ .... @ .............   ....... .....; .... *** .....\r\n"
				+ " .....\\@\\....@ .... @ ............................. #  .. *****  ...\r\n"
				+ "  @@@.. @@@@@  @@@@@@___.. ....... ...%..... ...  {###}  *******\r\n"
				+ " ....@-@..@ ..@......@@@\\...... %...... ....... <## ####>********\r\n"
				+ "   @@@@\\...@ @ ........\\@@@@ ..... ...... ....... {###}***********\r\n"
				+ " ....%..@  @@ /@@@@@ . ....... ...............<###########> *******\r\n"
				+ " ...... .@-@@@@ ...V......     .... %.......... {#######}******* ***\r\n"
				+ " ...... .  @@ .. ..v.. .. . ... ............<###############>*******\r\n"
				+ " ......... @@ .... ................. .......   {## ######}***** ****\r\n"
				+ " ..%..... @@ .. .%.... . ................ <###################> ****\r\n"
				+ " . .... . @@ . .... .... .. ...... ......... {#############}********\r\n"
				+ " .... ... @@ ... .. ....................<################  #####>***\r\n"
				+ " . .... ..@@@ .............................{##################}*****\r\n"
				+ " ......... @@@  .... ... ........  .. <##########################>**\r\n"
				+ "  @@@@ ....@@@  ....... ................ {###   ##############}*****\r\n"
				+ " @@@@@@@  @@@@@ .. @ @@@@@@@@@@@ @@  <############################>*\r\n"
				+ " @@@@@@@ @@@@@@@ @@@@@@@@@@@@@@@@@@@ ..... @@@@@@  @@@@@@@  @@@@\r\n"
				+ " @@@@@@###@@@@@### @@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ " @@@@@@@@###@##@@ @@@@@@@@@@@@@@@@@@@@@ @@@@@   @@@@@@@@@@@@@@@@@@@\r\n"
				+ " @@@@@@@@@@@### @@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ " @@@@@@@@@#####@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
				+ "\nYou awake on a strange world, Earth-like with an unsettlingly calm aura."
		+ "\nYour exosuit flashes the message 'Life Support Unnecessary, shutting down'."
		+ "\nYou feel your senses are playing tricks on you as bronze trees dance to the warm wind, and feathered animals of all sizes graze the red and grey brush."
		+ "\nWhere the horizon meets the lavender sky in the east you spot a seemingly inhabited outpost, perhaps the people(?) there can help."
		+ "\nOr the arid climate may allow you to build a signal fire.");
		Thread.sleep( 5000 );
		System.out.println( "\nWhat will you do?"
		+ "\n1) Head to the outpost."
		+ "\n2) Attempt to build a fire." );
		String selection = kbd.next();
		boolean isValid = false;
		while( isValid != true ) {
			if( selection.isEmpty() || Integer.parseInt( selection ) > 2 || Integer.parseInt( selection ) <  1 ) {
				System.out.println( "Please enter a valid selection." );
				selection = kbd.next();
			}
			else { 
				isValid = true;
			
			}
		}
		Room.clearConsole();
		if( Integer.parseInt( selection ) == 1 ) {
			//Went to outpost
			System.out.println( "\n\nYou begin to make your way east towards the outpost, inspecting both your equipment and surroundings. "
					+ "\nYou are equipped with a basic exosuit and standard-issue handgun. "
					+ "\n	The exosuit has arm-mounted thrusters for quick maneuvers in low-G environments. Learned \"Thruster Punch\""
					+ "\n	The handgun's optics are well-suited for close range. Learned \"Focused Shot\"");
			Room.clearConsole();
			Room.getPlayer().printAllSkills();
			Room.clearConsole();
			System.out.println( "\n\nAfter hiking for some time you notice multiple trails of dust making their way towards you from the north."
					+ "\nYou reach for your handgun. As they get closer you notice that the clouds are being made by a wild animal pursuing a small hovering robot of some kind.");
			Room.clearConsole();
			System.out.println( "\nThe robot puts some distance between it and the creature chasing it. As it approaches, you understand its artificial cries for help."
					+ "\n\nUnfamiliar Robot: DISTRESS - DISTRESS - DISTRESS"
					+   "\n                  Request: Help me Stranger! -- Diagnostic: Weapon systems malfunctioning."
					+ "\n\nThe spherical drone begins to frantically hover in circles around you flashing some sort of warning lights.");
			System.out.println( "\nHow will you respond?"
					+ "\n1) \"Get behind me.\" (Combat)"
					+ "\n2) \"I'll take care of it, but afterwards you scram! (Combat)"
					+ "\n3) \"Handle it yourself!\" (Run)"
					+ "\n4) \"RUN!\" (Run)");
			selection = kbd.next();
			isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > 4 || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;
				
				}
			}
			Room.clearConsole();
			if( Integer.parseInt( selection ) == 1 ) {
				Room.addTraitPoint( Trait.GOOD, 7);
				Room.addTraitPoint( Trait.LAWFUL, 7);
				ArrayList<Enemy> enemies = new ArrayList<Enemy>();
				ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
				enemySkills.add( new EnemySkill( false, 1, 10, 8, 6, "Charge", "The Dracobird charges to deal up to 10 damage. 8 + d6 to hit." ));
				enemySkills.add( new EnemySkill( false, 1, 7, 11, 9, "Slash", "The Dracobird slashes to deal up to 7 damage. Guaranteed hit, can crit."));
				enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
				System.out.println( "\r\n"
						+ "              _          _\r\n"
						+ "             _/|    _   |\\_\r\n"
						+ "           _/_ |   _|\\\\ | _\\\r\n"
						+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
						+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
						+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
						+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
						+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
						+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
						+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
						+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
						+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
						+ "              /_|//|\\| |_\\ \\\r\n"
						+ "             /////||\\||\\_ \\\r\n"
						+ "             |///|/|||\\|\\\\\\|         \r\n"
						+ "              / \\/|||/||/\\/           \r\n"
						+ "                /|/\\| \\/ \\/                     \r\n"
						+ "                \\/  |\\/     \r\n"
						+ "");
				System.out.println( "The bot seemingly transmits data on the creature you are about to face to your suit..." );
				System.out.println( enemies.get( 0 ).toString());
				Room.clearConsole();
				Combat c = new Combat( Room.getPlayer(), enemies );
				if( c.combat() ) Room2.init(1);
			}
			else if( Integer.parseInt( selection ) == 2 ) {
				Room.addTraitPoint( Trait.CHAOTIC, 7 );
				Room.addTraitPoint( Trait.GOOD, 7 );
				ArrayList<Enemy> enemies = new ArrayList<Enemy>();
				ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
				enemySkills.add( new EnemySkill( false, 1, 10, 8, 6, "Charge", "The Dracobird charges to deal up to 10 damage. 8 + d6 to hit." ));
				enemySkills.add( new EnemySkill( false, 1, 7, 11, 9, "Slash", "The Dracobird slashes to deal up to 7 damage. Guaranteed hit, can crit."));
				enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
				System.out.println( "\r\n"
						+ "              _          _\r\n"
						+ "             _/|    _   |\\_\r\n"
						+ "           _/_ |   _|\\\\ | _\\\r\n"
						+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
						+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
						+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
						+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
						+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
						+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
						+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
						+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
						+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
						+ "              /_|//|\\| |_\\ \\\r\n"
						+ "             /////||\\||\\_ \\\r\n"
						+ "             |///|/|||\\|\\\\\\|         \r\n"
						+ "              / \\/|||/||/\\/           \r\n"
						+ "                /|/\\| \\/ \\/                     \r\n"
						+ "                \\/  |\\/     \r\n"
						+ "");
				System.out.println( "The bot seemingly transmits data on the creature you are about to face to your suit..." );
				System.out.println( enemies.get( 0 ).toString());
				Room.clearConsole();
				Combat c = new Combat( Room.getPlayer(), enemies );
				if( c.combat() ) Room2.init(1);
			}
			else if( Integer.parseInt( selection ) == 3 ) {
				Room.addTraitPoint( Trait.EVIL, 7);
				Room.addTraitPoint( Trait.CHAOTIC, 7 );
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
				System.out.println( "\nYou try to run but the bot follows. Pursued by the bird-like creature, you've been led to other members of its pack."
						+ "\n\nUnfamiliar Robot: Observation: Stranger is an asshole."
						+   "\n                  Suggestion: You need me, you don't know what you're fighting!"
						+ "\n\nThe bot seemingly transmits data on the creatures you are about to face to your suit..." );
				System.out.println( "\r\n"
						+ "              _          _\r\n"
						+ "             _/|    _   |\\_\r\n"
						+ "           _/_ |   _|\\\\ | _\\\r\n"
						+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
						+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
						+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
						+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
						+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
						+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
						+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
						+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
						+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
						+ "              /_|//|\\| |_\\ \\\r\n"
						+ "             /////||\\||\\_ \\\r\n"
						+ "             |///|/|||\\|\\\\\\|         \r\n"
						+ "              / \\/|||/||/\\/           \r\n"
						+ "                /|/\\| \\/ \\/                     \r\n"
						+ "                \\/  |\\/     \r\n"
						+ "");
				System.out.println( enemies.get( 0 ).toString());
				System.out.println( enemies.get( 2 ).toString());
				Room.clearConsole();
				Combat c = new Combat( Room.getPlayer(), enemies );
				if( c.combat() ) Room2.init(2);
			}
			else if( Integer.parseInt( selection ) == 4 ) {
				ArrayList<Enemy> enemies = new ArrayList<Enemy>();
				ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
				ArrayList<EnemySkill> enemySkills2 = new ArrayList<EnemySkill>();
				enemySkills.add( new EnemySkill( false, 1, 15, 8, 10, "Charge", "The Dracobird charges to deal up to 15 damage. 8 + d10 to hit." ));
				enemySkills.add( new EnemySkill( false, 1, 10, 11, 9, "Slash", "The Dracobird slashes to deal up to 10 damage. Guaranteed hit, can crit."));
				enemySkills2.add( new EnemySkill( false, 1, 20, 10, 12, "Alpha Charge", "The Dracobird Alpha charges to deal up to 20 damage. 10 + d12 to hit, can crit." ));
				enemySkills2.add( new EnemySkill( false, 1, 10, 13, 9, "Alpha Slash", "The Dracobird Alpha slashes to deal up to 15 damage. Guaranteed hit, can crit."));
				enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
				enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
				System.out.println( "You try to run, the seemingly friendly robot hovering by your side. Pursued by the bird-like creature, you don't make it far before you've been led to another member of its pack."
						+ "\nThe bot seemingly transmits data on the creatures you are about to face to your suit..." );
				System.out.println( "\r\n"
						+ "              _          _\r\n"
						+ "             _/|    _   |\\_\r\n"
						+ "           _/_ |   _|\\\\ | _\\\r\n"
						+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
						+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
						+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
						+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
						+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
						+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
						+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
						+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
						+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
						+ "              /_|//|\\| |_\\ \\\r\n"
						+ "             /////||\\||\\_ \\\r\n"
						+ "             |///|/|||\\|\\\\\\|         \r\n"
						+ "              / \\/|||/||/\\/           \r\n"
						+ "                /|/\\| \\/ \\/                     \r\n"
						+ "                \\/  |\\/     \r\n"
						+ "");
				System.out.println( enemies.get( 0 ).toString());
				Room.clearConsole();
				Combat c = new Combat( Room.getPlayer(), enemies );
				if( c.combat() ) Room2.init(2);
			}
		}
		else {
			//Attempted fire
			System.out.println( " .. ........... .............  ........... . ..... ........ .......\r\n"
					+ " ......  ....................%.... .... ..... .........%............\r\n"
					+ " .@@@ ........ @@.... @@@@  . ............................  *  .....\r\n"
					+ " ....@@ ..... @ .... @ .............   ....... .....; .... *** .....\r\n"
					+ " .....\\@\\....@ .... @ ............................. #  .. *****  ...\r\n"
					+ "  @@@.. @@@@@  @@@@@@___.. ....... ...%..... ...  {###}  *******\r\n"
					+ " ....@-@..@ ..@......@@@\\...... %...... ....... <## ####>********\r\n"
					+ "   @@@@\\...@ @ ........\\@@@@ ..... ...... ....... {###}***********\r\n"
					+ " ....%..@  @@ /@@@@@ . ....... ...............<###########> *******\r\n"
					+ " ...... .@-@@@@ ...V......     .... %.......... {#######}******* ***\r\n"
					+ " ...... .  @@ .. ..v.. .. . ... ............<###############>*******\r\n"
					+ " ......... @@ .... ................. .......   {## ######}***** ****\r\n"
					+ " ..%..... @@ .. .%.... . ................ <###################> ****\r\n"
					+ " . .... . @@ . .... .... .. ...... ......... {#############}********\r\n"
					+ " .... ... @@ ... .. ....................<################  #####>***\r\n"
					+ " . .... ..@@@ .............................{##################}*****\r\n"
					+ " ......... @@@  .... ... ........  .. <##########################>**\r\n"
					+ "  @@@@ ....@@@  ....... ................ {###   ##############}*****\r\n"
					+ " @@@@@@@  @@@@@ .. @ @@@@@@@@@@@ @@  <############################>*\r\n"
					+ " @@@@@@@ @@@@@@@ @@@@@@@@@@@@@@@@@@@ ..... @@@@@@  @@@@@@@  @@@@\r\n"
					+ " @@@@@@###@@@@@### @@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
					+ " @@@@@@@@###@##@@ @@@@@@@@@@@@@@@@@@@@@ @@@@@   @@@@@@@@@@@@@@@@@@@\r\n"
					+ " @@@@@@@@@@@### @@@@@@@@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@\r\n"
					+ " @@@@@@@@@#####@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n");
			System.out.println( "This clearing where you came to will be perfect for a fire. You walk over to the nearby brush to collect some tinder.");
			Room.clearConsole();
			System.out.println( "You spot an object shining in the distance under a nearby tree. Will you investigate?"
					+ "\n1) Yes"
					+ "\n2) No");
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
			Room.clearConsole();
			if( Integer.parseInt( selection ) == 1 ) {
				System.out.println( "                                                                                \r\n"
						+ "                                                                                \r\n"
						+ "                     **,,.                                ***.                  \r\n"
						+ "                   #*(***,,,...*                      ..     /,*/               \r\n"
						+ "                 */((/***,,,......,,              ..          ../,(,            \r\n"
						+ "              ,*,,.,,/%**,,,.....  ...,.  .,*        .         ,...,*.          \r\n"
						+ "            .*...,                                     ,      *   ...,*         \r\n"
						+ "           **,*       .*.         *         ,   ,   ,        ,       //,        \r\n"
						+ "          #,*.    ,                    , .         .                ,,*         \r\n"
						+ "         (,,.. ,                          ..         .      ,      .,*          \r\n"
						+ "        (*...,        (#%(,.., .,            ,        ,           ,             \r\n"
						+ "       .(,..*     *#(((. /*     *(/#.          .       .   ,      . *           \r\n"
						+ "       *(.,,    *(////,   ,,. ,,.    //         ,          .     .  ,           \r\n"
						+ "       /,,,    /////(  .           ,   **        ,               ,  .           \r\n"
						+ "       /,,/   ,/**** .               . ./*                .      .  ,           \r\n"
						+ "       /,,*   (***** .                   *.       *       ,      .  *           \r\n"
						+ "       ,/,/   /***** ,                *  */               *.,,,. .  ,           \r\n"
						+ "        (,,.   ****** ,                  //       ,       *      ,   .          \r\n"
						+ "....... .(,*   ,,,,,** .            .   (,        ,       *      .   . .........\r\n"
						+ "....... . (,,  . **,,,(#  .,     ..   (. .       .       .       ,... ..........\r\n"
						+ "...........(,,,   #((#(///..,     ,/(/*/        .       ,        ,,,,,/.........\r\n"
						+ "............,/,,(((#//*#**,       **/  ,       .       .   .      ,,,,*.........\r\n"
						+ "..............,#******/#**,       ,*/     .. ,       .     ,    ...#(/..........\r\n"
						+ "................/(**/////**       ,*/        ,/.   .        ,...,,*.............\r\n"
						+ ".................../(/****....,(//**,        ***#,       ..,*/,,/...............\r\n"
						+ "....................../*/((....,          ,(%/       *,,,,,,*,..................\r\n"
						+ "..........................,/*..,,    /,........ ,/,/.,,*/*......................\r\n"
						+ "....................................*  .(((((((((* .............................\r\n"
						+ "................................................................................\r\n"
						+ "................................................................................\r\n"
						+ "................................................................................");
				System.out.println( "It seems to be a broken drone of some sort. It's shaped like a sphere, with a triangular display on one side pointing downward on one side."
						+ "\nYou can't figure out how it moves. It is perfectly round and smooth, perhaps it rolls?"
						+ "\nYou reach down and touch the piece of foreign technology and its display blinks purple. A low pitched artificial voice speaks...");
				Room.clearConsole();
				System.out.println( "\nStrange Drone: zzZZkZt BEACON ACTIVATED tZkZZzz");
				Thread.sleep( 5000 );
				System.out.println( "\nYou are blinded by a flash of more purple light. When your eyes readjust you immediately notice you are on the ground with a similar drone hovering above you."
						+ "\nThis one is smaller than the last and its display is blue. Its shell is polished gunmetal." );
				Room.clearConsole();
				System.out.println( "\nUnfamiliar Robot: Greetings stranger. "
						+ 			"\n                  Calculation: You have been unconscious for precisely seven minutes and sixteen seconds."
						+ 			"\n                  Observation: The local wildlife has been eyeing up a 'corpse' for the past sixty-seven seconds."
						+ 			"\n                  Suggestion: Introductions can wait while you show them you are not a corpse.");
				System.out.println( "\nHow will you respond?"
						+ "\n1) \"Get behind me.\" (Combat)"
						+ "\n2) \"RUN!\" (Run)");
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
				Room.clearConsole();
				if( Integer.parseInt( selection ) == 1 ) {
					Room.addTraitPoint( Trait.GOOD, 7);
					Room.addTraitPoint( Trait.LAWFUL, 7);
					ArrayList<Enemy> enemies = new ArrayList<Enemy>();
					ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
					enemySkills.add( new EnemySkill( false, 1, 10, 8, 6, "Charge", "The Dracobird charges to deal up to 10 damage. 8 + d6 to hit." ));
					enemySkills.add( new EnemySkill( false, 1, 7, 11, 9, "Slash", "The Dracobird slashes to deal up to 7 damage. Guaranteed hit, can crit."));
					enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
					System.out.println("              _          _\r\n"
							+ "             _/|    _   |\\_\r\n"
							+ "           _/_ |   _|\\\\ | _\\\r\n"
							+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
							+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
							+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
							+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
							+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
							+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
							+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
							+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
							+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
							+ "              /_|//|\\| |_\\ \\\r\n"
							+ "             /////||\\||\\_ \\\r\n"
							+ "             |///|/|||\\|\\\\\\|         \r\n"
							+ "              / \\/|||/||/\\/           \r\n"
							+ "                /|/\\| \\/ \\/                     \r\n"
							+ "                \\/  |\\/     ");
					System.out.println( "The bot seemingly transmits data on the creature you are about to face to your suit..." );
					System.out.println( enemies.get( 0 ).toString());
					Room.clearConsole();
					Combat c = new Combat( Room.getPlayer(), enemies );
					if( c.combat() ) Room2.init(3);
				}
				else if( Integer.parseInt( selection ) == 2 ) {
					ArrayList<Enemy> enemies = new ArrayList<Enemy>();
					ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
					ArrayList<EnemySkill> enemySkills2 = new ArrayList<EnemySkill>();
					enemySkills.add( new EnemySkill( false, 1, 15, 8, 10, "Charge", "The Dracobird charges to deal up to 15 damage. 8 + d10 to hit." ));
					enemySkills.add( new EnemySkill( false, 1, 10, 11, 9, "Slash", "The Dracobird slashes to deal up to 10 damage. Guaranteed hit, can crit."));
					enemySkills2.add( new EnemySkill( false, 1, 20, 10, 12, "Alpha Charge", "The Dracobird Alpha charges to deal up to 20 damage. 10 + d12 to hit, can crit." ));
					enemySkills2.add( new EnemySkill( false, 1, 10, 13, 9, "Alpha Slash", "The Dracobird Alpha slashes to deal up to 15 damage. Guaranteed hit, can crit."));
					enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
					enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
					System.out.println( "You try to run, the seemingly friendly robot hovering by your side. Pursued by the bird-like creature, you don't make it far before you've been led to another member of its pack.");
					System.out.println( "              _          _\r\n"
							+ "             _/|    _   |\\_\r\n"
							+ "           _/_ |   _|\\\\ | _\\\r\n"
							+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
							+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
							+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
							+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
							+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
							+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
							+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
							+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
							+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
							+ "              /_|//|\\| |_\\ \\\r\n"
							+ "             /////||\\||\\_ \\\r\n"
							+ "             |///|/|||\\|\\\\\\|         \r\n"
							+ "              / \\/|||/||/\\/           \r\n"
							+ "                /|/\\| \\/ \\/                     \r\n"
							+ "                \\/  |\\/     ");
					System.out.println("The bot seemingly transmits data on the creatures you are about to face to your suit..." );
					System.out.println( enemies.get( 0 ).toString());
					Room.clearConsole();
					Combat c = new Combat( Room.getPlayer(), enemies );
					if( c.combat() ) Room2.init(4);
				}
			}
			else {
				System.out.println( "After collecting a few armfuls of sticks and twigs, you reach into your pocket to take out a flint.");
				Thread.sleep( 1000 );
				System.out.println( "'How did I know that was there?'");
				Thread.sleep( 1000 );
				System.out.println( "You take a moment to get the fire going..." );
				Room.clearConsole();
				System.out.println( "With the fire going now, someone is sure to find you. You take a moment to familiarize yourself with the rest of your equipment."
						+ "\nYou are equipped with a basic exosuit and standard-issue handgun.");
				System.out.println("	The exosuit has arm-mounted thrusters for quick maneuvers in low-G environments. Learned \"Thruster Punch\"");
				System.out.println( "		" + Room.getPlayer().getSkills().get(0).toString() );
				System.out.println("	The handgun's optics are well-suited for close range. Learned \"Focused Shot\"");
				
				System.out.println(  "		" + Room.getPlayer().getSkills().get(1).toString() );
				Room.clearConsole();
				System.out.println( "\n\nAfter waiting seemingly forever you notice multiple trails of dust making their way towards you from the south."
						+ "\nYou get up to look,  and as they get closer you notice that the clouds are being made by a wild animal pursuing a small hovering robot of some kind.");
				Room.clearConsole();
				System.out.println( "\nThe robot puts some distance between it and the creature chasing it. As it approaches, you understand its artificial cries for help."
						+ "\n\nUnfamiliar Robot: DISTRESS - DISTRESS - DISTRESS"
						+   "\n                  Request: Help me Stranger! -- Diagnostic: Weapon systems malfunctioning."
						+ "\n\nThe spherical drone begins to frantically hover in circles around you flashing some sort of warning lights.");
				System.out.println( "\nHow will you respond?"
						+ "\n1) \"Get behind me.\" (Combat)"
						+ "\n2) \"RUN!\" (Run)");
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
					Room.clearConsole();
				}
				if( Integer.parseInt( selection ) == 1 ) {
					Room.addTraitPoint( Trait.GOOD, 7);
					Room.addTraitPoint( Trait.LAWFUL, 7);
					ArrayList<Enemy> enemies = new ArrayList<Enemy>();
					ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
					enemySkills.add( new EnemySkill( false, 1, 10, 8, 6, "Charge", "The Dracobird charges to deal up to 10 damage. 8 + d6 to hit." ));
					enemySkills.add( new EnemySkill( false, 1, 7, 11, 9, "Slash", "The Dracobird slashes to deal up to 7 damage. Guaranteed hit, can crit."));
					System.out.println("              _          _\r\n"
							+ "             _/|    _   |\\_\r\n"
							+ "           _/_ |   _|\\\\ | _\\\r\n"
							+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
							+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
							+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
							+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
							+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
							+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
							+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
							+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
							+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
							+ "              /_|//|\\| |_\\ \\\r\n"
							+ "             /////||\\||\\_ \\\r\n"
							+ "             |///|/|||\\|\\\\\\|         \r\n"
							+ "              / \\/|||/||/\\/           \r\n"
							+ "                /|/\\| \\/ \\/                     \r\n"
							+ "                \\/  |\\/     ");
					enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
					System.out.println( "The bot seemingly transmits data on the creature you are about to face to your suit..." );
					System.out.println( enemies.get( 0 ).toString());
					Room.clearConsole();
					Combat c = new Combat( Room.getPlayer(), enemies );
					if( c.combat() ) Room2.init(1);
				}
				else if( Integer.parseInt( selection ) == 2 ) {
					
					ArrayList<Enemy> enemies = new ArrayList<Enemy>();
					ArrayList<EnemySkill> enemySkills = new ArrayList<EnemySkill>();
					ArrayList<EnemySkill> enemySkills2 = new ArrayList<EnemySkill>();
					enemySkills.add( new EnemySkill( false, 1, 15, 8, 10, "Charge", "The Dracobird charges to deal up to 15 damage. 8 + d10 to hit." ));
					enemySkills.add( new EnemySkill( false, 1, 10, 11, 9, "Slash", "The Dracobird slashes to deal up to 10 damage. Guaranteed hit, can crit."));
					enemySkills2.add( new EnemySkill( false, 1, 20, 10, 12, "Alpha Charge", "The Dracobird Alpha charges to deal up to 20 damage. 10 + d12 to hit, can crit." ));
					enemySkills2.add( new EnemySkill( false, 1, 10, 13, 9, "Alpha Slash", "The Dracobird Alpha slashes to deal up to 15 damage. Guaranteed hit, can crit."));
					enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
					enemies.add( new Enemy( 50, "Dracobird", "Named for it's resemblance to a dragon, the Dracobird is a two legged, man-sized flightless bird known for its bright patterns, sharp talons, and horned crest.", 8, enemySkills ));
					System.out.println( "You try to run, the seemingly friendly robot hovering by your side. Pursued by the bird-like creature, you don't make it far before you've been led to another member of its pack.");
					System.out.println( "              _          _\r\n"
							+ "             _/|    _   |\\_\r\n"
							+ "           _/_ |   _|\\\\ | _\\\r\n"
							+ "         _/_/| /  /   \\|\\ |\\_\\_\r\n"
							+ "       _/_/  |/  /  _  \\/\\|  \\_\\_ \r\n"
							+ "     _/_/    ||  | | \\o/ ||    \\_\\_\r\n"
							+ "    /_/  | | |\\  | \\_ V  /| | |  \\_\\\r\n"
							+ "   //    ||| | \\_/   \\__/ | |||    \\\\\r\n"
							+ "  // __| ||\\  \\          /  /|| |__ \\\\\r\n"
							+ " //_/ \\|||| \\/\\\\        //\\/ ||||/ \\_\\\\\r\n"
							+ "///    \\\\\\\\/   /        \\   \\////    \\\\\\\r\n"
							+ "|/      \\/    |  //|\\ \\  |     \\/      \\|\r\n"
							+ "              /_|//|\\| |_\\ \\\r\n"
							+ "             /////||\\||\\_ \\\r\n"
							+ "             |///|/|||\\|\\\\\\|         \r\n"
							+ "              / \\/|||/||/\\/           \r\n"
							+ "                /|/\\| \\/ \\/                     \r\n"
							+ "                \\/  |\\/     ");
							System.out.println( "The bot seemingly transmits data on the creatures you are about to face to your suit..." );
					System.out.println( enemies.get( 0 ).toString());
					Room.clearConsole();
					Combat c = new Combat( Room.getPlayer(), enemies );
					if( c.combat() ) Room2.init(2);
				}
			}
			kbd.close();
		}
	}








}
