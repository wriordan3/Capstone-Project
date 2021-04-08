import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


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
		skills.add(PlayerSkill.getAllSkills().get( 0 ));
		skills.add(PlayerSkill.getAllSkills().get( 1 ));
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
		maxHP = 75;
		currentHP = maxHP;
		this.alignment = new Alignment( firstAxis, secondAxis );
	}
	public PlayerMap getFirst() {
		return this.firstAxis;
	}
	public PlayerMap getSecond() {
		return this.secondAxis;
	}
	public String getName() {
		return this.name;
	}
	public void printAllSkills() {
		for( int i = 0; i < this.getSkills().size(); i++  ) {
			System.out.println( (i + 1) + ") " + this.getSkills().get( i ).toString() );
		}
	}
	public void levelUp() {
		this.level++;
		System.out.print( "\n" );
		for( PlayerSkill s : PlayerSkill.getAllSkills() ) {
			if( s.level == this.level ) {
				this.skills.add( s );
				System.out.println( "You have learned: " + s.toString() );
			}
		}
		int c = 1;

		System.out.println( "\nWhich skill would you like to augment?" );
		for( PlayerSkill s : getSkills() ) {
			if( s.getDesired().equals( this.getAlignment().getFirst()) || s.getDesired().equals( this.getAlignment().getSecond())) {
				System.out.println( (c) + ") " + s.toString() );
			}
			c++;
		}
		Scanner kbd = new Scanner( System.in );
		String selection = kbd.next();
		boolean isValid = false;
		while( isValid != true ) {
			if( selection.isEmpty() || 
					Integer.parseInt( selection ) > getSkills().size() ||
					Integer.parseInt( selection ) <  1 ||
					!getSkills().get( Integer.parseInt( selection ) - 1).canAugment()) {
				System.out.println( "Please enter a valid selection." );
				selection = kbd.next();
			}
			else { 
				isValid = true;
			
			}
		}
		getSkills().get( Integer.parseInt( selection ) - 1).augment();
		System.out.println( "Skill successfully augmented" );
	}
	public int getLevel() {
		return this.getLevel();
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP( int n ) {
		maxHP = n;
	}
	public String toString() {
		return String.format( "%s - %d / %dHP", this.name, this.currentHP, this.maxHP );
	}

	public boolean checkDamage(int attackAccuracy) {
		armorClass = level + armor.getArmorClassModifier();
		return attackAccuracy > armorClass;
	}

	public void takeDamage(int i) {
		currentHP -= i;
		
	}
	public void restoreHealth( double healing ) {
		currentHP += healing;
		if( currentHP >= maxHP ) currentHP = maxHP;
		System.out.println( healing + " health restored." );
	}
	public void restoreHealth() {
		currentHP = maxHP;
		System.out.println( "Health restored." );
	}
	public Weapon getWeapon() {
		return this.primary;
	}
	public ArrayList<PlayerSkill> getSkills() {
		return skills;
	}
	public Alignment getAlignment() {
		this.alignment = new Alignment( firstAxis, secondAxis );
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

	public Armor getArmor() {
		return armor;
	}
	
	
}
