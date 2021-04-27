
import java.io.FileWriter;
import java.io.IOException;

import org.json.*;
import org.json.JSONObject;

import org.json.simple.parser.ParseException;
public class Main {
	public static Player player;
	public static Room currentRoom;
	private static String fileName;
	private static FileWriter file;
	
	
	public static void main( String[] args ) {
		fileName = "saveData.json";
		RoomInit.init();
//		HomeRoom.getInstance().addMission( new Room4(), "Go to the place you saw in your dream. (Recommended Level: 3)");
//		HomeRoom.getInstance().addMission( new Room4a(), "Find more of Echo's siblings. (Recommended Level: 4)");
//		player = new Player( "test" );
//		Room.addTraitPoint( Trait.CHAOTIC, 11);
//		Room.addTraitPoint( Trait.EVIL, 5 );
//		player.setLevel( 2 );
//		player.getSkills().get(0).augment();
////		try {
////			Loader.loadGame( fileName );
////		} catch (IOException | ParseException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
//		
//		
//		
//		try {
//			HomeRoom.getInstance().play();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		}
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
		firstAxis.put( player.getFirst().get().get( Trait.CHAOTIC ) );
		
		JSONArray secondAxis = new JSONArray();
		secondAxis.put( player.getSecond().get().get( Trait.GOOD ) );
		secondAxis.put( player.getSecond().get().get( Trait.EVIL ) );
		
		JSONArray cmissions = new JSONArray();
		for( int i = 0; i < player.completedMissions().size(); i++ ) {
			cmissions.put(  player.completedMissions().get(i).getClass().toGenericString() );
		}
		
		p.put( "name", player.getName() );
		p.put( "level", player.getLevel());
		p.put( "currency", player.getCurrency());
		p.put( "armor", armor );
		p.put( "weapon", weapon );
		p.put( "firstAxis", firstAxis );
		p.put( "secondAxis", secondAxis );
		p.put( "completed", cmissions );
		
		JSONArray skillAugments = new JSONArray();
		for( int i = 0; i < player.getSkills().size(); i++ ) {
			
			if( player.getSkills().get( i ).isAugmented() )
				skillAugments.put( 1 );
			else
				skillAugments.put( 0 );
		}
		p.put( "augs", skillAugments );
		
		JSONArray missions = new JSONArray();
		for( int i = 0; i < HomeRoom.getInstance().getMissions().size(); i++ ) {
			JSONObject entry = new JSONObject();
			entry.put( "room", HomeRoom.getInstance().getMissions().get(i).getClass().toGenericString() );
			entry.put( "description", HomeRoom.getInstance().getMissionStrings().get(i) );
			missions.put( entry );
		}
		
		game.put( "player", p );
		game.put( "completed missions", missions );
		
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
		System.out.println( "Saved game.");
		
	}
	
}

