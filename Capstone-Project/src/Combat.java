import java.util.List;
import java.util.Scanner;

public class Combat {
	private Player player;
	private List<Enemy> enemies;
	private boolean playerDead;
	private boolean enemiesDead;
	
	public Combat( Player player, List<Enemy> enemies ) {
		this.player = player;
		this.enemies = enemies;
		playerDead = false;
		enemiesDead = false;
	}
	
	public boolean combat() {
		Scanner kbd = Room.kbd;
		while( !playerDead || !enemiesDead) {
			System.out.println( "\n\n" + player.toString() );
			//TODO: display combat options (offense, healing, defense)
			//Display all enemy health and get target
			System.out.println( "\nWho would you like to target?" );
			for( int i = 0; i < enemies.size(); i++ ) {
				System.out.println( (i + 1) + ") " + enemies.get( i ).getInfo() );
			}
			String selection = kbd.next();
			boolean isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > enemies.size() || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;
				
				}
			}
			int enemyIndex = Integer.parseInt( selection ) - 1;
			
			//Get ability the player would like to use.
			System.out.println( "...with which ability?");
			player.printAllSkills();
			selection = kbd.next();
			isValid = false;
			while( isValid != true ) {
				if( selection.isEmpty() || Integer.parseInt( selection ) > this.player.getSkills().size() || Integer.parseInt( selection ) <  1 ) {
					System.out.println( "Please enter a valid selection." );
					selection = kbd.next();
				}
				else { 
					isValid = true;

				}
			}
			int skillIndex = Integer.parseInt( selection ) - 1;
			//cast player ability
			System.out.println( String.format( "\n%s used %s on %s", this.player.getName(), this.player.getSkills().get(skillIndex).getName(), enemies.get( enemyIndex ).getName() ));
			this.player.getSkills().get( skillIndex).cast( enemies.get( enemyIndex ));
			//check enemy health, if dead remove from list.
			if( enemies.get( enemyIndex ).isDead() ) {
				System.out.println( String.format( "%s is dead.", enemies.get( enemyIndex ).getName() ));
				enemies.remove( enemyIndex );
			}
			//if list empty, end loop return playerDead
			if( enemies.size() == 0 ) {
				enemiesDead = true;
				System.out.println( "Victory!" );
				return true;
			}
			//for each enemy, get random ability
			for( Enemy e : enemies ) {
				if( !e.isFrozen() ) {
					int skillIndexE = (int)( Math.random() * e.getSkills().size() );
					
	
					//cast enemy ability
					try {
						Thread.sleep( 1000 );
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println( String.format( "\n%s used %s on %s", e.getName(), e.getSkills().get(skillIndexE).toString(), this.player.getName() ));
					e.getSkills().get( skillIndexE ).cast( player );
					//check player health, if dead end game
					if( player.isDead() ) {
						playerDead = true;
						System.out.println( "You died. Ending game." );
						return false;
					}
				}
				else {
					e.unfreeze();
				}
			}
			Room.clearConsole();
		}
		return !playerDead;
	}
}
