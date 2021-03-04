import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room1a implements Room {
	private static Room thisRoom;
	public static Room init() {
		thisRoom = new Room1a();
		getOptions();
		return thisRoom;
	}
	public static void getOptions() {
		int i = 1;
		List<Method> options = new ArrayList<Method>();
		for( Class<?> cls : Room1a.class.getDeclaredClasses() ) {
			try {
				@SuppressWarnings("deprecation")
				Object obj = cls.newInstance();
				Method getOption = cls.getDeclaredMethod( "getOption" );
				getOption.setAccessible(true);
				System.out.println( i + " -> " + getOption.invoke(obj, null) );
				options.add( getOption );
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			
		}
		Scanner kbd = new Scanner( System.in );
		int selection = kbd.nextInt();
		if( selection > options.size() ) { System.out.println( "Please enter a valid number." ); Room1a.getOptions();}
		try {
			options.get( selection -1 ).invoke( thisRoom, null );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
