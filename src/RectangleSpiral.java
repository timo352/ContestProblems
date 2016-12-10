
import java.util.*;

public class RectangleSpiral {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int numCases = in.nextInt();
	
	for (int i = 0; i < numCases; i++) {
	    in.nextInt();
	    
	    int x = in.nextInt();
	    int y = in.nextInt();
	    
	    if(y > x){
		System.out.println((i+1) + " " + 2 + " " + x + " " + y);
	    } else if(y < 4 || x <3){
		System.out.println((i+1) + " NO PATH");
	    } else{
		System.out.println((i+1) + " " + 6 + " " + 1 + " " + 2 + " " + 3 + " " + (x-y+5) + " " + (x+2) + " " + (x+3));
	    }
	}
    }
}
