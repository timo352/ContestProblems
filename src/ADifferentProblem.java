

import java.util.Scanner;

public class ADifferentProblem {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);		
		
		while(in.hasNextLong()){
			long a = in.nextLong();
			long b = in.nextLong();
			
			long c = Math.abs(a-b);
			System.out.println(c);
		}		
	}	
}
