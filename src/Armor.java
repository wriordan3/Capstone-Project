
public class Armor {
	private int armorClassModifier;
	private String name;
	private String description;
	
	public Armor( int armorClassModifier, String name, String description ) {
		this.armorClassModifier = armorClassModifier;
		this.name = name;
		this.description = description;
	}
	public int getArmorClassModifier() {
		return this.armorClassModifier;
	}
}
