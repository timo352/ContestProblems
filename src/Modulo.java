
import java.util.*;

public class Modulo {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	ArrayList<Integer> c = new ArrayList();
	for (int i = 0; i < 10; i++) {
	    int num = in.nextInt();
	    if(!c.contains(num % 42)){
		c.add(num%42);
	    }
	}
	
	System.out.println(c.size());
    }

}
