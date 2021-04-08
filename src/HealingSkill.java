import java.util.function.BiConsumer;

public class HealingSkill extends PlayerSkill {

	public HealingSkill( int level, String name, String description, Trait desired, BiConsumer<PlayerSkill, Enemy> castAugment) {
		super(false, level, 0, 0, 0, name, description, desired, castAugment);

	}
	
	public void cast( Enemy enemy ) {
		if( isAugmented ) castAugment.accept( this, enemy);
		else {
			double healing = (double)Main.player.getLevel() * 10;
			Main.player.restoreHealth( healing );
		}
	}

}
