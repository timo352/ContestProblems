
import java.util.*;
import java.io.*;

public class HappyPrime{

    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(System.in);

	int numCases = in.nextInt();

	for (int n = 0; n < numCases; n++) {
	    in.nextInt();
	    int num = in.nextInt();
	    String out = (isHappy(num) && isPrime(num))? "YES" : "NO";
	    System.out.println((n + 1) + " " + num + " " + out);
	}
    }

    static boolean isHappy(int num) {
	HashMap<Integer, Boolean> m = new HashMap();
	int s = sumDigsSquare(num);
	while(!m.containsKey(s) && s != 1){
	    m.put(s, true);
	    s = sumDigsSquare(s);
	}
	
	return s == 1;
    }
    
    static boolean isPrime(int num){

	for(int i=2; i<Math.sqrt(num)+1; i++){
	    if(num%i == 0){
		return false;
	    }
	}
	return num != 1;
    }
    
    static int sumDigsSquare(int num){
	String s = String.valueOf(num);
	int sum = 0;
	for(int i=0; i<s.length(); i++){
	    sum += (s.charAt(i) - '0')*(s.charAt(i) - '0');
	}
	return sum;
    }
}
