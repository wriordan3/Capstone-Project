import java.util.List;

public class Enemy {
	private int maxHP;
	private int currentHP;
	private String name;
	private String description;
	private int armorClass;
	private List<EnemySkill> skills;
	private boolean isFrozen;
	
	public Enemy( int maxHP, String name, String description, int armorClass, List<EnemySkill> skills ) {
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.name = name;
		this.description = description;
		this.armorClass = armorClass;
		this.skills = skills;
		this.isFrozen = false;
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
	public int getCurrentHP() {
		return currentHP;
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	
	public void freeze() {
		isFrozen = true;
	}
	public void unfreeze() {
		isFrozen = false;
	}
	
	public boolean isFrozen() {
		return isFrozen;
	}
}
