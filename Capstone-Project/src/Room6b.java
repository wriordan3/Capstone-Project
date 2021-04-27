
public class Room6b implements Room {

	@Override
	public void play() throws InterruptedException {
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
				+ "\r\n"
				+ "");
		System.out.println( "You arrive at the same forest where you woke up on your first day here.");
		System.out.println( "It's not nearly as quiet as it was then. Whatever fell from the sky seems to have disturbed and angered all of the wildlife.");
		System.out.println( "You follow a trail of fallen branches until you reach the clearing where it landed.");
		
		Room.clearConsole();
		
		System.out.println( "               (  @@@@@@@@@@@@@@@@@      @@@@@@@@@@)                               \r\n"
				+ "                     @@@@@@@@@@@        @@@@@@@@@)                                 \r\n"
				+ "                ( @@@@@@@@@@@    @@@@@@@@@@@                                         \r\n"
				+ "                     @@@@@@@@@@@@@@@@)                                       . \r\n"
				+ "                 ( @@@@@@@@@@@                                                    \r\n"
				+ "                  (@@@@@@@@@@@@)                             (  @@)                 \r\n"
				+ "                 (  @@@  )                                    @@@@                 \r\n"
				+ "              ////,.     /...                             (  @@@@                \r\n"
				+ "            *(&%#((#((**/*****......,                   ( @@@  )                  \r\n"
				+ "          ./////#(/(////((//**/*/*,,,,,,/. ,              @                      \r\n"
				+ "           (#(((##/((///%((/(/(/(//*(*(*,,,.,,./,*. .     )                      \r\n"
				+ "     ###   (######((////#(#&(#((/(//(//**//**(*/.      (                         \r\n"
				+ "    #o###       ((#(((//((/((&(#&((////(((/%(#***,(..   ,                       \r\n"
				+ "  #####o###    .(#(((((((/////((#((#(((((((/////****,*.,  . .                   \r\n"
				+ " #o#\\#|#/###     (#(((((((((////////((##((#/////////*//*,,...                   \r\n"
				+ "  ###\\|/#o#         (#((((((((((//(///@((//(////(///(/*/*,,..                   \r\n"
				+ ",,,# }|{  #,,,,,,,,,,, (#((((((((((((%((///////////////(/**,. ,,,,,,                   \r\n"
				+ ",,,,,}|{,,,,,,,,,,,,,,,,, #######(((#((((//////////(((/*/(**,. //,,,               \r\n"
				+ ",,,,,,,,,,,,,,,,,,,,,,,,,,,,*//((((%%#((((((((///((((##(#(////*/,,,,                \r\n"
				+ ",,,,,,,,,,,,,,,,,,,,,,,,,////////*//(((((####(((((((((((((///*/.,,,,               \r\n"
				+ ",,,,,,,,,,,,,,,,,,,,,,///((///,,***/,*,**(((((##%#######(((//(,,,,,,             \r\n"
				+ ",,,,,,,,,,,,,,,,,,,////((/////////.,*.,,,,,*******//(((/*(##%#*                 \r\n"
				+ ",,,,,,,,,,,,,,,,*//(///((/((#/(///#(((/..*,.,.,..,.,......, ,    .  .            \r\n"
				+ ",,,,,,,,,,,,,,////////((((#/#(#/(((/(//(/(///,.,,,...  .     .      .             \r\n"
				+ ",,,,,,,,,,,,,(///////((//(((((#(/((/(((#///((///(//  ... . .     , ..,            \r\n"
				+ ",,,,,,,,,,,,,,,,,,,/(((((((((((((((#%((((((((((#((((((*./,...,                    ");
		System.out.println( "Echo was right, a person definitely landed here, although they are gone now.");
		System.out.println( "You approach only to notice a hatch on the far side thats been removed, revealing an empty capsule." );
		System.out.println( "Much like Echo, this technology is foreign-yet-familiar. The interior was clearly designed for a human being but unlike anything you've ever seen.");
		
		System.out.println( "\nEcho: This is highly irregular... My planetary records show nothing about a crash when you arrived." );
		System.out.println( "      Where are you from?" );
		Room.clearConsole();
		System.out.println( "You don't even know the answer to that yourself, but before you can try to explain, a man appears from behind a nearby tree." );
		System.out.println( "He has long blonde hair and a pale complexion, wearing a black skin-tight suit");
		System.out.println( "Echo: Greetings stranger! My name is 3-CH0, but you can call me --" );
		Thread.sleep( 1000 );
		System.out.println( "\nBefore Echo could finish the stranger snapped his fingers and Echo completely shut down, reaching the ground with a loud clank.");
		System.out.println( "The stranger now turns his gaze towards you, and speaks in an unsettlingly calm tone." );
		System.out.println( "\nStranger: Wonderful, now we can speak properly, " + Room.getPlayer().getName() + ".");
		System.out.println( "          My name is unpronounceable to you, but you may call me The Son." );
		System.out.println( "          I have been called to defend my Father's creation. Human beings must not be allowed to poison this world." );
		Room.clearConsole();
		System.out.println( "The Son: I can't tell if you are decent or foolish for seeking me out, but I will grant you one opportunity to join me." );
		System.out.println( "         Come to the control room with me. We can reset this world and keep it as our own paradise." );
		System.out.println( "\nWhat will you do?");
		System.out.println( "1) Go with The Son" );
		System.out.println( "2) Grab ball, run like hell." );
		
		int selection = Room.getSelection( kbd, 2 );
		Room.clearConsole();
		
		if( selection == 0 ) {
			Room.addTraitPoint( Trait.LAWFUL, 4 );
			Room.addTraitPoint( Trait.EVIL, 6 );
			int scrap = 8;
			Room.getPlayer().addCurrency( scrap );
			System.out.printf( "\nYou found %d scrap on this mission. Total: %d",  scrap, Room.getPlayer().getCurrency());
			Room.init( new Room7( 0 ) );
		}
		else {
			Room.addTraitPoint( Trait.CHAOTIC, 4 );
			Room.addTraitPoint( Trait.GOOD, 6 );
			int scrap = 8;
			Room.getPlayer().addCurrency( scrap );
			System.out.printf( "\nYou found %d scrap on this mission. Total: %d",  scrap, Room.getPlayer().getCurrency());
			Room.init( new Room7( 1 ) );
		}

	}

}
