import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Loader {

	
	public static void loadGame( String fileName ) throws FileNotFoundException, IOException, ParseException {
		JSONObject jo = (JSONObject) new JSONParser().parse( new FileReader( fileName ) );
		
		//get missions for loading later
		ArrayList<Room> missions = new ArrayList<Room>();
		ArrayList<String> missionStrings = new ArrayList<String>();
		JSONArray sm = jo.getJSONArray( "missions" );
		Iterator itr = sm.iterator();
		while( itr.hasNext() ) {
			JSONObject mission = (JSONObject) itr.next();
			missionStrings.add( mission.get( "description").toString() );
			switch( mission.get( "room" ).toString().split(" ")[2] ) {
				case "Room3":
					missions.add( new Room3());
					break;
				case "Room4":
					missions.add( new Room4() );
					break;
				case "Room4a":
					missions.add( new Room4a() );
			}
		}
		
		JSONObject p = jo.getJSONObject( "player" );
		//preload weapon
		JSONObject w = p.getJSONObject("weapon" );
		Weapon weapon = new Weapon( w.getInt("damage"), w.getString( "name" ), w.getString( "description" ));
		//preload armor
		JSONObject a = p.getJSONObject( "armor" );
		Armor armor = new Armor( a.getInt( "armorClassModifier" ), a.getString( "name" ), a.getString( "description" ));
		
		//Load first and second axes
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		JSONArray f = p.getJSONArray( "firstAxis" );
		JSONArray s = p.getJSONArray( "secondAxis" );
		//iterate first
		itr = f.iterator();
		while( itr.hasNext() ) {
			first.add( (Integer)itr.next() );
		}
		//iterate second
		itr = s.iterator();
		while( itr.hasNext() ) {
			first.add( (Integer)itr.next() );
		}
		
		//get augments
		JSONArray au = p.getJSONArray("augs" );
		ArrayList<Integer> augs = new ArrayList<Integer>();
		itr = au.iterator();
		while( itr.hasNext()) {
			augs.add( (Integer)itr.next());
		}
		
		
		String name = p.getString( "name" );
		int level = p.getInt( "level" );
		int currency = p.getInt( "currency" );
		
		ArrayList<Room> cmissions = new ArrayList<Room>();
		JSONArray cm = p.getJSONArray( "completed missions" );
		itr = cm.iterator();
		while( itr.hasNext() ) {
			switch( itr.next().toString().split(" ")[2] ) {
				case "Room4a":
					cmissions.add( new Room4a() );
			}
		}
		
		Main.player = new Player( name, level, currency, weapon, armor, first, second, augs, cmissions );
		for( int i = 0; i < missions.size(); i++ ) {
			HomeRoom.getInstance().addMission( missions.get( i ), missionStrings.get( i ));
		}
		
		
	}
}
