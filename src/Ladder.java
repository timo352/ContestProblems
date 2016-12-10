
import java.util.*;

public class Ladder {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int h = in.nextInt();
	int v = in.nextInt();
	
	double l = h / Math.sin(v*Math.PI/180);
	System.out.println((int)Math.ceil(l));
    }
}
