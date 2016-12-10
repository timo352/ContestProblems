
import java.util.*;

public class Easiest {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int N = in.nextInt();
	while(N != 0){
	    
	    int sumP = 0;
	    int sumN = getSum(N);	    
	    int p = 11;
	    while(sumP != sumN){
		sumP = getSum(N*p);
		p++;
	    }
	    System.out.println(p-1);
	    N = in.nextInt();
	}
    }
    
    public static int getSum(int N){
	String str = String.valueOf(N);
	int sum = 0;
	for(int i=0; i<str.length(); i++){
	    sum += str.charAt(i)-'0';
	}
	return sum;
    }

}
