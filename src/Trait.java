
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
}
