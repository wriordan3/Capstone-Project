import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.*;
public class Main {
	public static Player player;
	public static Room currentRoom;
	private static String fileName;
	private static FileWriter file;
	
	
	public static void main( String[] args ) {
		fileName = "saveData.json";
		HomeRoom.getInstance().addMission( new Room3(), "Find replacement parts for Echo. (Recommended Level: 2 )");
		player = new Player( "test" );
		Room.addTraitPoint( Trait.LAWFUL, 3);
		Room.addTraitPoint( Trait.GOOD, 4);
		try {
			HomeRoom.getInstance().play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void saveGame( ) {
		JSONObject game = new JSONObject();
		JSONObject p = new JSONObject();
		JSONObject armor = new JSONObject();
		armor.put("armorClassModifier", player.getArmor().getArmorClassModifier() );
		armor.put( "name", player.getArmor().getName() );
		armor.put( "description", player.getArmor().getDescription() );
		
		JSONObject weapon = new JSONObject();
		weapon.put("damage", player.getWeapon().getDamage() );
		weapon.put( "name", player.getWeapon().getName() );
		weapon.put( "description", player.getWeapon().getName() );
		
		JSONArray firstAxis = new JSONArray();
		firstAxis.put( player.getFirst().get().get( Trait.LAWFUL ) );
		firstAxis.put( player.getFirst().get().get( Trait.NEUTRAL1 ) );
		firstAxis.put( player.getFirst().get().get( Trait.CHAOTIC ) );
		
		JSONArray secondAxis = new JSONArray();
		secondAxis.put( player.getSecond().get().get( Trait.GOOD ) );
		secondAxis.put( player.getSecond().get().get( Trait.NEUTRAL2 ) );
		secondAxis.put( player.getSecond().get().get( Trait.EVIL ) );
		
		p.put( "name", player.getName() );
		p.put( "armor", armor );
		p.put( "weapon", weapon );
		p.put( "firstAxis", firstAxis );
		p.put( "secondAxis", secondAxis );
		
		JSONObject missions = new JSONObject();
		for( int i = 0; i < HomeRoom.getInstance().getMissions().size(); i++ ) {
			JSONObject entry = new JSONObject();
			entry.put( "room", HomeRoom.getInstance().getMissions().get(i).getClass().toGenericString() );
			entry.put( "description", HomeRoom.getInstance().getMissionStrings().get(i) );
			missions.put( "mission" + (i+1), entry );
		}
		
		game.put( "player", p );
		game.put( "missions", missions );
		
		try {
			file = new FileWriter( fileName );
			file.write( game.toString(4) );
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {
			try {
				file.flush();
				file.close();
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}

