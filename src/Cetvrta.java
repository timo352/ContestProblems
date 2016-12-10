import java.util.*;

public class Cetvrta {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int s1, s2, s3, s4;
		int e1, e2, e3, e4;
		
		s1 = in.nextInt();
		e1 = in.nextInt();
		
		s2 = in.nextInt();
		e2 = in.nextInt();
		
		s3 = in.nextInt();
		e3 = in.nextInt();
		
		if(s1 == s2){
			s4 = s3;
		} else if(s1 == s3){
			s4 = s2;
		} else{
			s4 = s1;
		}
		
		
		if(e1 == e2){
			e4 = e3;
		} else if(e1 == e3){
			e4 = e2;
		} else{
			e4 = e1;
		}
		
		System.out.println(s4 + " " + e4);
		
	}	
}
