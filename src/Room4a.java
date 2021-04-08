
public class Room4a implements Room {

	@Override
	public void play() throws InterruptedException {
		Room.setRoom( this );
		System.out.println( "Loaded side mission" );
	}

}
