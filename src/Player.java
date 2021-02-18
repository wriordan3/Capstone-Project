import java.util.ArrayList;

public class Player {
	private String name;
	private int level;
	//private ArrayList<Skill> skills;
	private PlayerMap firstAxis;
	private PlayerMap secondAxis;
	private Room currentLocation;
	
	public Player( String name ) {
		this.name = name;
		level = 1;
		//skills
		ArrayList<Trait> first = new ArrayList<Trait>();
		ArrayList<Trait> second = new ArrayList<Trait>();
		first.add(Trait.LAWFUL);
		first.add(Trait.NEUTRAL);
		first.add(Trait.CHAOTIC);
		second.add(Trait.GOOD);
		second.add(Trait.NEUTRAL);
		second.add(Trait.EVIL);
		
	}
	
	public String getName() {
		return this.name;
	}
}
