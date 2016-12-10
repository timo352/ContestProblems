
import java.util.*;

public class Apaxiaans {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String str = in.nextLine();
		String out = "";
		char prev = '0';
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) != prev){
				prev = str.charAt(i);
				out += prev;
			}
		}
		
		System.out.println(out);
	}	
}
