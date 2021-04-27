import java.util.Scanner;

public class Room4 implements Room{

	@Override
	public void play() throws InterruptedException {
		Room.setRoom( this );
		Room.clearConsole();
		if( Room.getPlayer().completedMissions().isEmpty() ) {
			HomeRoom.getInstance().removeMission( new Room4a(), "Find more of Echo's siblings. (Recommended Level: 4)");
		}
		Scanner kbd = new Scanner(System.in);
		System.out.println( "Once again you rest before going to investigate what you saw on your way back from getting parts with Echo.");
		System.out.println( "When you wake up you see smoke rising up from the west, near where you arrived.");
		System.out.println( "Its just like your dream.");
		System.out.println( "" );
		System.out.println( "The robots who operate the outpost frantically prepare their posts for the arrival of another human.");
		System.out.println( "Amidst the chaos, you spot the faint purple glow from Echo's repulsors as he manuevers through the crowds.");
		Room.clearConsole();
		System.out.println( "                                                                                \r\n"
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
		System.out.println( "Echo: " + Room.getPlayer().getName() + "! I'm sorry but we have to head towards that menacing plume of smoke!");
		System.out.println( "      My scans tell me its a new arrival and if so, they're in danger.");
		System.out.println( "      The wildlife will be extremely aggressive due the crash, we have to hurry!");
		Thread.sleep( 1000 );
		System.out.println( "\nHow will you respond?" );
		System.out.println( "1) Then there's no time to lose, lets go!" );
		System.out.println( "2) You have to find him yourself, you can't risk losing both of your humans." );
		System.out.println( "3) I'll let natural selection handle it." );
		int selection = Room.getSelection( kbd, 3 );
		Room.clearConsole();
		
		if( selection == 0 ) { //Go with echo load Room5
			if( Room.getPlayer().getAlignment().getSecond().equals( Trait.EVIL ) || Room.getPlayer().getAlignment().getFirst().equals( Trait.CHAOTIC )) {
				
			}
			Room.addTraitPoint( Trait.LAWFUL, 7 );
			Room.addTraitPoint( Trait.GOOD, 7 );
			Room.init( new Room5() );
		}
		
		if( selection == 1 ) { //Stay back, load Room6a
			Room.addTraitPoint( Trait.CHAOTIC, 7);
			Room.addTraitPoint( Trait.GOOD, 7);
			Room.init( new Room6a());
		}
		if( selection == 2 ) { //Stay back, load Room6a
			if( Room.getPlayer().getAlignment().getFirst().equals( Trait.EVIL )) {
				System.out.println( "Honestly, I'm not surprised..." );
			}
			Room.addTraitPoint( Trait.LAWFUL, 7 );
			Room.addTraitPoint( Trait.EVIL, 7);
			Room.init( new Room6a() );
		}
		
		
	}
}
