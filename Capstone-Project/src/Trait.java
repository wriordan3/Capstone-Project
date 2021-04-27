
public enum Trait {
	LAWFUL( "Lawful" ),
	NEUTRAL1( "Neutral (First axis)" ),
	NEUTRAL2( "Neutral (Second axis)"),
	CHAOTIC( "Chaotic" ),
	GOOD( "Good" ),
	EVIL( "Evil" );
	
	private String name;
	private Trait( String name ) {
		this.name = name;
	}
	
	public Trait getOpposite() {
		switch( this.name ) {
		case( "Lawful" ) :
			return CHAOTIC;
		case( "Chaotic" ) :
			return LAWFUL;
		case( "Good" ) :
			return EVIL;
		case( "Evil" ) :
			return GOOD;
		}
		return null;
	}	
}
