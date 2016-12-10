
import java.util.*;

public class Oddities {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int numTerms = in.nextInt();

	for (int i = 0; i < numTerms; i++) {
	    int num = in.nextInt();

	    if (num % 2 == 0) {
		System.out.println(num + " is even");
	    } else {
		System.out.println(num + " is odd");
	    }
	}

    }

}
