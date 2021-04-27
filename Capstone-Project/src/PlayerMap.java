
import java.util.Hashtable;
import java.util.List;

public class PlayerMap {
	private Hashtable<Trait, Integer> table;
	private final int total = 100;
	
	public PlayerMap( Trait t1, Trait t2) {
		table = new Hashtable<Trait, Integer>();
		table.put( t1, total/2 );
		table.put( t2,  total/2 );
	}
	
	public PlayerMap( Trait t1, int n1, Trait t2, int n2 ) {
		if( n1 + n2 != 100 	) throw new IllegalArgumentException( "Trait values must total 100" ); 
		table = new Hashtable<Trait, Integer>();
		table.put( t1,  n1 );
		table.put( t2, n2 );
	}
	
	public void updateValue( Trait t, int newVal ) {
		table.replace( t, table.get(t) + newVal );
		table.replace( t.getOpposite(), table.get(t.getOpposite()) - newVal );
	}
	
	public Hashtable<Trait, Integer> get() {
		return this.table;
	}
}
