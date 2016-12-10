
import java.util.*;
import java.io.*;

public class FareySum {

    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(System.in);

	int numCases = in.nextInt();

	for (int n = 0; n < numCases; n++) {
	    // junk K number
	    in.nextInt();
	    int order = in.nextInt();

	    ArrayList<Integer> m = new ArrayList();
	    
	    int a = 0;
	    int b = 1;
	    int c = 1;
	    int d = order;
	    
	    m.add(b);
	    while(c <= order){
		int k = (order+b)/d;
		int t1 = a, t2 = b;
		a = c;
		b = d;
		c = k*c - t1;
		d = k*d - t2;
		m.add(b);
	    }	    
	    
	    String sum = calcFareySum(m);
	    System.out.println((n + 1) + " " + (sum));
	}
    }

    static String calcFareySum(ArrayList<Integer> m) {
	long x = 0, y = 1;

	for (int i = 0; i < m.size() - 1; i++) {
	    x = x*m.get(i+1) + y*m.get(i);
	    y = y*m.get(i+1);
	    
	    long g = gcd(x,y);
	    x /= g;
	    y /= g;
	}

	return x + "/" + y;
    }

    static long gcd(long a, long b) {
	if (a % b == 0) {
	    return b;
	} else {
	    return gcd(b, a % b);
	}
    }
}
