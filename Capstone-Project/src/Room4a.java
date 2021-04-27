
public class Room4a implements Room {

	@Override
	public void play() throws InterruptedException {
		Room.setRoom( this );
		System.out.println( "Loaded side mission" );
		Room.getPlayer().completedMissions().add( this );
		Room.getPlayer().addCurrency( 6 );
		System.out.println( "Completed side mission" );
		Room.clearConsole();
		HomeRoom.getInstance().play();
	}

}
