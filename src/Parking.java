
import java.util.*;

public class Parking {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int A = in.nextInt();
	int B = in.nextInt();
	int C = in.nextInt();
	
	int[] costs = {A,B,C};
	
	int[] time = new int[101];
	for(int i=0; i<101; i++){
	    time[i] = 0;
	}
	
	int c11 = in.nextInt();
	int c12 = in.nextInt();
	int c21 = in.nextInt();
	int c22 = in.nextInt();
	int c31 = in.nextInt();
	int c32 = in.nextInt();
	
	for(int i=c11; i<c12; i++){
	    time[i]++;
	}
	for(int i=c21; i<c22; i++){
	    time[i]++;
	}
	for(int i=c31; i<c32; i++){
	    time[i]++;
	}
	int cost = 0;
	for(int i=0; i<101; i++){
	    if(time[i] != 0){
		cost += costs[time[i]-1]*time[i];
	    }
	}
	System.out.println(cost);
	
    }

}
