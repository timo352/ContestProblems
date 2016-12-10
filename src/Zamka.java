
import java.util.*;

public class Zamka {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int currPlayer = in.nextInt();
		
		int questions = in.nextInt();
		int time = 0;
		for(int i=0; i<questions; i++){
			
			time += in.nextInt();
			String result = in.nextLine().trim();
			
			if(time >= 210){
				System.out.println(currPlayer);
				i=questions;
			}
			
			if(result.equals("T")){
				currPlayer++;
				
				if(currPlayer == 9) currPlayer = 1;
			}
			
		}
		
		
	}
}
