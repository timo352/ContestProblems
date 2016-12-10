
import java.util.*;
import java.io.*;

public class HeightOrdering {

    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(System.in);

	int numCases = in.nextInt();

	for (int n = 0; n < numCases; n++) {

	    ArrayList<Integer> list = new ArrayList();
	    in.nextInt();

	    list.add(in.nextInt());

	    int count = 0;
	    for (int i = 1; i < 20; i++) {
		int temp = in.nextInt();
		int j;
		for (j = 0; j < list.size(); j++) {
		    if (temp < list.get(j)) {
			count += list.size() - j;
			break;
		    }
		}
		list.add(j, temp);

	    }

	    System.out.println((n + 1) + " " + count);
	}
    }

}
