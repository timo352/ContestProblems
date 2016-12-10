
import java.util.*;

public class Spavanac {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int H = in.nextInt();
	int M = in.nextInt();
	
	int newM = M - 45;
	if(newM < 0){
	    H--;
	    if(H < 0) H = 23;
	    newM += 60;
	}
	
	System.out.println(H + " " + newM);
    }

}
