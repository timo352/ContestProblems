
import java.util.*;

public class Pot {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int numTerms = in.nextInt();
	in.nextLine();
	long sum = 0;
	for (int i = 0; i < numTerms; i++) {
	    long term = getVal(in.nextLine());
	    sum += term;
	}

	System.out.println(sum);
    }

    public static long getVal(String str){
	int pow = str.charAt(str.length()-1) - '0';
	
	int base = Integer.valueOf(str.substring(0, str.length()-1));
	
	return (long)Math.pow(base, pow);
    }
    
}
