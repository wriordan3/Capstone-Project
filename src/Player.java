import java.util.ArrayList;
import java.util.Collections;


public class Player {
	private String name;
	private int level;
	private Weapon primary;
	private Armor armor;
	private ArrayList<PlayerSkill> skills;
	public PlayerMap firstAxis;
	public PlayerMap secondAxis;
	private Room currentLocation;
	private int maxHP;
	private int currentHP;
	private int armorClass;
	private Alignment alignment;
	
	public Player( String name ) {
		this.name = name;
		level = 1;
		this.primary = new Weapon( 8, "Genitech EVA-Tac Mk.I", "A mass-produced semi-automatic ballistic weapon for the first humans travelling to Soteria. Uses pressure to fire a hardened projectile, versatile and can be used with\na range of ammunition and in the most extreme climates." );
		this.armor = new Armor( 10, "Genitech EVA Exo-Suit", "A mass-produced exo-suit for the first humans travelling to Soteria. Provides moderate protection from hazardous climates and functions in space. Light armor.");
		armorClass = level + armor.getArmorClassModifier();
		this.skills = new ArrayList<PlayerSkill>();
		skills.add( new PlayerSkill(false, 1, 8, 14, 6, "Thruster Punch", "Use your exosuit's arm-mounted thruster to deliver a powerful punch. (8 damage | 14 + 1d6 to hit)"));
		skills.add( new PlayerSkill( true, 1, 4, 12, 10, "Focused Shot", "Time the perfect shot for a higher chance to critical hit. Can deliver 3x damage super-criticals (4 damage + weapon  | 12 + 1d10 to hit)"));
		ArrayList<Trait> first = new ArrayList<Trait>();
		first.add( Trait.LAWFUL );
		first.add( Trait.NEUTRAL1 );
		first.add( Trait.CHAOTIC );
		firstAxis = new PlayerMap( first );
		ArrayList<Trait> second = new ArrayList<Trait>();
		second.add( Trait.GOOD );
		second.add( Trait.NEUTRAL2 );
		second.add( Trait.EVIL );
		secondAxis = new PlayerMap( second );
		first.add(Trait.LAWFUL);
		first.add(Trait.NEUTRAL1);
		first.add(Trait.CHAOTIC);
		second.add(Trait.GOOD);
		second.add(Trait.NEUTRAL2);
		second.add(Trait.EVIL);
		maxHP = 75;
		currentHP = maxHP;
		this.alignment = new Alignment( firstAxis, secondAxis );
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return String.format( "%s - %d / %dHP", this.name, this.currentHP, this.maxHP );
	}

	public boolean checkDamage(int attackAccuracy) {
		return attackAccuracy > armorClass;
	}

	public void takeDamage(int i) {
		currentHP -= i;
		
	}
	public Weapon getWeapon() {
		return this.primary;
	}
	public ArrayList<PlayerSkill> getSkills() {
		return skills;
	}
	public Alignment getAlignment() {
		return this.alignment;
	}
	public boolean isDead() {
		return this.currentHP <= 0;
	}
	
	public class Alignment {
		private Trait first;
		private Trait second;
		
		public Alignment( PlayerMap firstAxis, PlayerMap secondAxis ) {
			int first = firstAxis.get().get( Trait.LAWFUL );
			this.first = Trait.LAWFUL;
			int second = secondAxis.get().get( Trait.GOOD );
			this.second = Trait.GOOD;
			if( firstAxis.get().get( Trait.NEUTRAL1 ) > first ) {
				first = firstAxis.get().get( Trait.NEUTRAL1 );
				this.first = Trait.NEUTRAL1;
			}
			if( firstAxis.get().get( Trait.CHAOTIC ) > first ) {
				first = firstAxis.get().get( Trait.CHAOTIC );
				this.first = Trait.CHAOTIC;
			}
			if( secondAxis.get().get( Trait.NEUTRAL2) > second ) {
				second = secondAxis.get().get( Trait.NEUTRAL2 );
				this.second = Trait.NEUTRAL2;
			}
			if( secondAxis.get().get( Trait.EVIL) > second ) {
				second = secondAxis.get().get( Trait.EVIL );
				this.second = Trait.EVIL;
			}
		}
		
		public Trait getFirst() {
			return this.first;
		}
		public Trait getSecond() {
			return this.second;
		}
		
		
	}
	
	
}
