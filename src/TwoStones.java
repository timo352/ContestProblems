
import java.util.*;

public class TwoStones {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int n = in.nextInt();
	String name;
	if(n % 2 == 0){
	    name = "Bob";
	} else{
	    name = "Alice";
	}
	
	System.out.println(name);
    }

}
