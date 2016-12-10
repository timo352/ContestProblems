
import java.util.*;

public class Compass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		
		if(n1 > n2){
			n2 += 360;
		}
		
		int dir = n2-n1;
		
		if(dir > 180){
			dir -= 360;
		}
		
		System.out.println(dir);
	}	
}
