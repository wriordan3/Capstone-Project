
public class Weapon {
	private int damage;
	private String name;
	private String description;
	
	public Weapon( int damage, String name, String description) {
		this.damage = damage;
		this.name = name;
		this.description = description;
	}
	
	public int getDamage() {
		return this.damage;
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	
	public String toString() {
		return String.format( "%s - (&d damage) %s", name, damage, description );
	}
}
