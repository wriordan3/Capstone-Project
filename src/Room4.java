
public class Room4 implements Room{

	@Override
	public void play() throws InterruptedException {
		Room.setRoom( this );
		System.out.println( "Loaded main mission" );
	}
	
}
