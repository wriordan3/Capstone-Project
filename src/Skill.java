
public abstract class Skill {
	protected boolean isRanged;
	protected int level;
	protected double damage;
	protected int accuracy;
	protected double accuracyModifier;
	protected String name;
	protected String description;
	public abstract String toString();
	public Skill( boolean isRanged, int level, double damage, int accuracy, double accuracyModifier, String name, String description ) {
		this.isRanged = isRanged;
		this.level = level;
		this.damage = damage;
		this.accuracy = accuracy;
		this.accuracyModifier = accuracyModifier;
		this.name = name;
		this.description = description;
	}
}
