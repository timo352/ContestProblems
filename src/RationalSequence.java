
import java.util.*;
import java.io.*;

public class RationalSequence {

    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(System.in);

	int numCases = in.nextInt();

	for (int n = 0; n < numCases; n++) {
	    // junk K number
	    in.nextInt();
	    String str = in.nextLine();
	    
	    // read in the fraction without that pesky /
	    // a/b
	    Scanner line = new Scanner(str.replace("/", " "));
	    int a = line.nextInt();
	    int b = line.nextInt();

	    // if the given node is the final child in a row
	    if (b == 1) {
		a++;
	    } // if the given node is the left child
	    else if (a < b) {
		a = b - a;
	    } // if the given sequence is the right child
	    else {		
		// mult = difference between a and b / b (number of while loop iterations)
		// cant get this to one line because of int truncating
		// algebra don't work in computers
		int mult = (a-b)/b + 1;		
		a = b*(mult+1) - (a - b*mult);

	    }
	    System.out.println((n + 1) + " " + b + "/" + a);
	}
    }
}
