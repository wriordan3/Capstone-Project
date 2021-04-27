import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class PlayerSkill extends Skill {


	protected boolean isAugmented;
	private Trait desired;
	protected BiConsumer<PlayerSkill, Enemy> castAugment;
	
	public PlayerSkill(boolean isRanged, int level, int damage, int accuracy, int accuracyModifier, String name, String description, Trait desired,
			BiConsumer<PlayerSkill, Enemy> castAugment) {
		super(isRanged, level, damage, accuracy, accuracyModifier, name, description);
		this.desired = desired;
		this.castAugment = castAugment;
		isAugmented = false;
	}
	public void cast( Enemy enemy ) {
		if( isAugmented ) castAugment.accept( this, enemy);
		else {
			int attackAccuracy = accuracy + (int)(Math.random() * accuracyModifier) + 1;
			double dmg = this.damage;
			if( isRanged ) dmg += Main.player.getWeapon().getDamage();
			if( enemy.checkDamage( attackAccuracy ) ) {
				if( attackAccuracy == 20 ) {
					if( attackAccuracy >20 ) {
						dmg *= 3;
						System.out.println( "SUPER CRIT" );
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
	}
	public Trait getDesired() {
		return this.desired;
	}
	public boolean isAugmented() {
		return this.isAugmented;
	}
	public boolean canAugment() {
		if( this.isAugmented ) return false;
		if(Main.player.getAlignment().getFirst().equals( desired ) || Main.player.getAlignment().getSecond().equals( desired ) ) return true;
		return false;
	}
	public void augment() {
		this.isAugmented = true;
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
		skills.add( new PlayerSkill(false, 1, 8, 14, 6, "Thruster Punch", "Use your exosuit's arm-mounted thruster to deliver a powerful punch. "
				+ "Augments with Chaotic to strike twice. (8 damage | 14 + 1d6 to hit)", Trait.CHAOTIC, new BiConsumer<PlayerSkill, Enemy>() {

			@Override
			public void accept(PlayerSkill arg0, Enemy arg1) {
				//TODO: fix
				arg0.isAugmented = false;
				arg0.cast( arg1 );
				arg0.cast( arg1 );
				arg0.augment();
			}
			
		}));
		skills.add( new PlayerSkill( true, 1, 4, 12, 10, "Focused Shot", "Time the perfect shot for a higher chance to critical hit. Augments with Evil for guaranteed criticals and execution. (4 damage + weapon  | 12 + 1d10 to hit)", Trait.EVIL, new BiConsumer<PlayerSkill, Enemy>()  {

			@Override
			public void accept(PlayerSkill arg0, Enemy arg1) {
				if( arg1.getCurrentHP() <= arg1.getMaxHP() / 4 ) {
					arg1.takeDamage( ( arg1.getMaxHP() / 4 ) + 1);
					System.out.println( String.format( "%s has been executed.", arg1.getName() ));
				}
				else {
					int attackAccuracy = arg0.accuracy + (int)(Math.random() * arg0.accuracyModifier) + 1;
					double dmg = arg0.damage;
					if( arg0.isRanged ) dmg += Main.player.getWeapon().getDamage();
					if( arg1.checkDamage( attackAccuracy ) ) {
						dmg = dmg * 2;
						arg1.takeDamage( (int)dmg);
						System.out.println( String.format( "%s took %d damage - Critical Hit!", arg1.getName(), (int)dmg ));

					}
					else System.out.println( "The attack missed" );
				}
			}
			
		}));
		skills.add( new HealingSkill( 2, "First-Aid", "Echo dispenses a stimulant that heals the player for 10*level hitpoints. Augment with Good to heal for 50% of max HP instead.",
				Trait.GOOD, new BiConsumer<PlayerSkill, Enemy>()  {

			@Override
			public void accept(PlayerSkill arg0, Enemy arg1) {
				double healing = (double)Main.player.getMaxHP()/2;
				Main.player.restoreHealth( healing );
			}
			
			
		}));
		return skills;
	}

}
