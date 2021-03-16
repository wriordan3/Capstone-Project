import java.util.ArrayList;
import java.util.List;

public class PlayerSkill extends Skill {

	private boolean isAugmented;
	
	public PlayerSkill(boolean isRanged, int level, int damage, int accuracy, double accuracyModifier, String name, String description) {
		super(isRanged, level, damage, accuracy, accuracyModifier, name, description);
		isAugmented = false;
	}
	public void cast( Enemy enemy ) {
		int attackAccuracy = accuracy + (int)(Math.random() * accuracyModifier) + 1;
		double dmg = this.damage;
		if( isRanged ) dmg += Main.player.getWeapon().getDamage();
		if( enemy.checkDamage( attackAccuracy ) ) {
			if( attackAccuracy == 20 ) {
				if( attackAccuracy >20 ) {
					dmg *= 3;
				}
				else{
					dmg *= 2;
				}
				enemy.takeDamage( (int)dmg );
				System.out.println( String.format( "%s took %d damage - Critical Hit!", enemy.getName(), (int)dmg ));
				
			}
			else {
				enemy.takeDamage( (int)dmg );
				System.out.println( String.format( "%s took %d damage", enemy.getName(), (int)dmg ));
			}
			
		}
		else System.out.println( "The attack missed" );
	}
	public boolean isAugmented() {
		return this.isAugmented;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getInfo() {
		return String.format( "%s - ( %d damage | %d + 1d%d to hit )", name, damage, accuracy, accuracyModifier );
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format( "%s (Unlocks at Level %d) - %s", name, level, description );
	}
	
	public static List<PlayerSkill> getAllSkills() {
		ArrayList<PlayerSkill> skills = new ArrayList<PlayerSkill>();
		skills.add( new PlayerSkill(false, 1, 8, 14, 6, "Thruster Punch", "Use your exosuit's arm-mounted thruster to deliver a powerful punch. (8 damage | 14 + 1d6 to hit)"));
		skills.add( new PlayerSkill( true, 1, 4, 12, 10, "Focused Shot", "Time the perfect shot for a higher chance to critical hit. Can deliver 3x damage super-criticals (4 damage + weapon  | 12 + 1d10 to hit)"));
		skills.add( new PlayerSkill( true, 2, 0, 20, 0, "Assisted Shot", "Echo takes control of your exosuit's targeting system to ensure a critical hit. ( 2 * weapon damage | guaranteed crit )"));
		return skills;
	}
}
