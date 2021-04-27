import java.util.Collection;

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
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}
