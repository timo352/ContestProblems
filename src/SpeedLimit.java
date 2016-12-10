
import java.util.*;

public class SpeedLimit {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	int n = in.nextInt();
	while(n != -1){
	    int distance = 0;
	    int lastTime = 0;
	    for(int i=0; i<n; i++){
		int speed = in.nextInt();
		int tot = in.nextInt();
		distance += speed * (tot - lastTime);
		lastTime = tot;
	    }
	    System.out.println(distance + " miles");
	    n = in.nextInt();
	}
	
    }

}
