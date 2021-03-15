
import java.util.Hashtable;
import java.util.List;

public class PlayerMap {
	private Hashtable<Trait, Integer> traits;
	
	public PlayerMap( List<Trait> t ) {
		traits = new Hashtable<Trait, Integer>();
		for( Trait o : t ) {
			traits.put( o, 0 );
		}
	}
	
	public void updateValue( Trait t, int newVal ) {
		traits.replace( t, traits.get(t) + newVal );
	}
	
	public Hashtable<Trait, Integer> get() {
		return this.traits;
	}
}
