
public class EnemySkill extends Skill {
	public EnemySkill(boolean isRanged, int level, double damage, int accuracy, double accuracyModifier, String name, String description) {
		super(isRanged, level, damage, accuracy, accuracyModifier, name, description);
	}


	public void cast( Player player ) {
		int attackAccuracy = accuracy + (int)(Math.random() * accuracyModifier ) + 1;
		double dmg =  (Math.random() * this.damage );
		if( player.checkDamage( attackAccuracy ) ) {
			if( attackAccuracy >= 20 ) {
				dmg *= 2;
				player.takeDamage( (int) dmg );
				System.out.println( String.format( "%s took %d damage - Critical Hit!", player.getName(), (int)dmg ));
			}
			else {
				player.takeDamage( (int)dmg );
				System.out.println( String.format( "%s took %d damage", player.getName(), (int)dmg ));
			}
		}
		else System.out.println( "The attack missed" );
	}

	@Override
	public String toString() {
		return this.name;
	}

}
