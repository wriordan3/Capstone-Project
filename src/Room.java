import java.util.List;

public interface Room {
	
	public void play() throws InterruptedException;
	public static void addTraitPoint( Trait t, int value ) {
		if( t.equals( t.CHAOTIC ) || t.equals(t.NEUTRAL1) || t.equals( t.LAWFUL ) ) {
			Main.player.firstAxis.updateValue( t, value );
		}
		if( t.equals( t.GOOD ) || t.equals(t.NEUTRAL2) || t.equals( t.EVIL ) ) {
			Main.player.secondAxis.updateValue( t, value );
		}
	}
	public static Player getPlayer() {
		return Main.player;
	}
}
