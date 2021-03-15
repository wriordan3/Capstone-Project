import java.util.List;

public class Enemy {
	private int maxHP;
	private int currentHP;
	private String name;
	private String description;
	private int armorClass;
	private List<EnemySkill> skills;
	
	public Enemy( int maxHP, String name, String description, int armorClass, List<EnemySkill> skills ) {
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.name = name;
		this.description = description;
		this.armorClass = armorClass;
		this.skills = skills;
	}
	public String toString() {
		return String.format( "%s - %s", name, description );
	}
	public boolean checkDamage( int accuracy ) {
		return accuracy > armorClass;
	}
	public void takeDamage( int damage ) {
		currentHP -= damage;
	}
	public List<EnemySkill> getSkills() {
		return this.skills;
	}
	public String getInfo() {
		return String.format( "%s - ( %d / %dHP )", name, currentHP, maxHP);
		
	}
	public boolean isDead() {
		return this.currentHP <= 0;
	}
	
	public String getName() {
		return this.name;
	}
}
