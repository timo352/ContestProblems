
import java.util.*;

public class ReverseBinary {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int n = in.nextInt();
	String str = Integer.toBinaryString(n);
	
	String out = "";
	
	for(int i=str.length()-1; i >=0; i--){
	    out += str.charAt(i);
	}
	
	System.out.println(Integer.valueOf(out, 2));
    }

}
