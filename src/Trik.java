
import java.util.*;

public class Trik {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String line = in.nextLine();

	int[] p = {1, 0, 0};
	int temp;
	for (int i = 0; i < line.length(); i++) {
	    switch (line.charAt(i)) {
		case 'A':
		    temp = p[0];
		    p[0] = p[1];
		    p[1] = temp;
		    break;
		case 'B':
		    temp = p[1];
		    p[1] = p[2];
		    p[2] = temp;
		    break;
		case 'C':
		    temp = p[0];
		    p[0] = p[2];
		    p[2] = temp;
		    break;
	    }
	}
	int out;
	
	if(p[0] == 1) out = 1;
	else if(p[1] == 1) out = 2;
	else out = 3;
	
	System.out.println(out);
    }

}
