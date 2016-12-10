
import java.util.*;

public class Everywhere {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numCases = in.nextInt();
		
		for(int i=0; i<numCases; i++){
			
			int numTrips = in.nextInt();
			in.nextLine();
			HashMap<String, String> trips = new HashMap();
			
			for(int j=0; j<numTrips; j++){
			
				String str = in.nextLine();
				if(!trips.containsKey(str)){
					trips.put(str, str);
				}
			}
			System.out.println(trips.size());			
		}
	}	
}
