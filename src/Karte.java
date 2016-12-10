
import java.util.*;

public class Karte {

 
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String str = in.nextLine();
	
	int[] deck = new int[52];
	for(int i=0; i<52; i++){
	    deck[i] = 0;
	}
	
	
	for(int i=0; (i+3)<=str.length(); i+=3){
	    char c = str.charAt(i);
	    int mod = 5;
	    switch(c){
		case 'P':
		    mod = 0;
		    break;
		case 'K':
		    mod = 1;
		    break;
		case 'H':
		    mod = 2;
		    break;
		case 'T':
		    mod = 3;
		    break;
	    }
	    
	    int n = Integer.valueOf(str.substring(i+1, i+3));
	    
	    if(deck[mod*13 + n-1] == 0){
		deck[mod*13 + n-1] = 1;
	    } else{
		System.out.println("GRESKA");
		return;
	    }
	}
	
	for(int i=0; i<4; i++){
	    int sum = 0;
	    for(int j=0; j<13; j++){
		sum += deck[i*13 + j];
	    }
	    if(sum < 13){
		System.out.print(13-sum);
	    } else{
		System.out.print(0);
	    }
	    if(i != 3){
		System.out.print(" ");
	    }
	}
	
	System.out.println();
		
    }

}
