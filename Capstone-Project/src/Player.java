import java.util.ArrayList;
import java.util.Collection;
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
	private int maxHP;
	private int currentHP;
	private int armorClass;
	private int currency;
	private Alignment alignment;
	private ArrayList<Room> completedMissions;
	
	public Player( String name ) {
		completedMissions = new ArrayList<Room>();
		this.name = name;
		level = 1;
		this.primary = new Weapon( 8, "Genitech EVA-Tac Mk.I", "A mass-produced semi-automatic ballistic weapon for the first humans travelling to Soteria. Uses pressure to fire a hardened projectile, versatile and can be used with\na range of ammunition and in the most extreme climates." );
		this.armor = new Armor( 10, "Genitech EVA Exo-Suit", "A mass-produced exo-suit for the first humans travelling to Soteria. Provides moderate protection from hazardous climates and functions in space. Light armor.");
		armorClass = level + armor.getArmorClassModifier();
		this.skills = new ArrayList<PlayerSkill>();
		skills.add(PlayerSkill.getAllSkills().get( 0 ));
		skills.add(PlayerSkill.getAllSkills().get( 1 ));
		firstAxis = new PlayerMap( Trait.LAWFUL, Trait.CHAOTIC );
		secondAxis = new PlayerMap( Trait.GOOD, Trait.EVIL );
		maxHP = 75;
		currentHP = maxHP;
		this.alignment = new Alignment( firstAxis, secondAxis );
		currency = 0;
	}
	
	public Player( String name, int level, int currency, Weapon weapon, Armor armor, ArrayList<Integer> first, ArrayList<Integer> second, ArrayList<Integer> augs, ArrayList<Room> missions ) {
		completedMissions = missions;
		this.name = name;
		this.level = level;
		this.currency = currency;
		this.primary = weapon;
		this.armor = armor;
		this.armorClass = level + armor.getArmorClassModifier();
		this.skills = new ArrayList<PlayerSkill>();
		for( int i = 0; i < augs.size(); i++ ) {
			skills.add( PlayerSkill.getAllSkills().get( i ) );
			if( augs.get( i ) == 1 ) {
				skills.get(i).augment();
			}
		}
		firstAxis = new PlayerMap( Trait.LAWFUL, first.get( 0 ), Trait.CHAOTIC, first.get( 1 ));
		secondAxis = new PlayerMap( Trait.GOOD, first.get( 0 ), Trait.EVIL, first.get( 1 ));
		
		maxHP = 65 + (10*(level));
		currentHP = maxHP;
		
		this.alignment = new Alignment( firstAxis, secondAxis );
		
	}
	
	public ArrayList<Room> completedMissions() {
		return this.completedMissions;
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
	public void setLevel( int n ) {
		this.level = n;
		skills = new ArrayList<PlayerSkill>();
		for( PlayerSkill s : PlayerSkill.getAllSkills() ) { 
			if( s.level <= this.level ) {
				skills.add( s );
			}
		}
	}
	public void levelUp() {
		this.level++;
		this.maxHP += 10;
		System.out.print( "\n" );
		for( PlayerSkill s : PlayerSkill.getAllSkills() ) {
			if( s.level == this.level ) {
				this.skills.add( s );
				System.out.println( "You have learned: " + s.toString() );
			}
		}
		
		int c = 1;

		ArrayList<PlayerSkill> potentials = new ArrayList<PlayerSkill>();
		for( PlayerSkill s : getSkills() ) {
			if( ( s.getDesired().equals( this.getAlignment().getFirst()) || s.getDesired().equals( this.getAlignment().getSecond())) && s.canAugment() ) {
				potentials.add( s );
			}
		}
		if( !potentials.isEmpty() ) {

			System.out.println( "\nWhich skill would you like to augment?" );
			for( PlayerSkill s : potentials ) {
				System.out.println( c + ") " + s.toString() );
				c++;
					
			}
			int selection = Room.getSelection( Room.kbd, potentials.size() );
			getSkills().get( selection ).augment();
			System.out.println( "Skill successfully augmented" );
		}
		
		

		
	}
	public int getLevel() {
		return this.level;
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
	public void setWeapon( Weapon newWeapon ) {
		this.primary = newWeapon;
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
			this.first = Trait.NEUTRAL1;
			this.second = Trait.NEUTRAL2;
			
			if( firstAxis.get().get( Trait.CHAOTIC ) > 60 ) {
				this.first = Trait.CHAOTIC;
			}
			if( firstAxis.get().get( Trait.LAWFUL ) > 60 ) {
				this.first = Trait.LAWFUL;
			}
			
			if( secondAxis.get().get( Trait.EVIL ) > 60 ) {
				this.second = Trait.EVIL;
			}
			if( secondAxis.get().get( Trait.GOOD ) > 60 ) {
				this.second = Trait.GOOD;
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

	
	public int getCurrency() {
		return this.currency;
	}
	
	public void addCurrency( int n ) {
		currency += n;
	}

	public void setArmor(Armor armor2) {
		this.armor = armor2;
		
	}
}
