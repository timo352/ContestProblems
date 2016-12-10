
import java.util.*;

public class Pet {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int[] scores = {0, 0, 0, 0, 0};
	int top = -1;
	int score = -1;

	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 4; j++) {
		scores[i] += in.nextInt();
	    }
	}

	for (int i = 0; i < 5; i++) {
	    if (scores[i] > score) {
		score = scores[i];
		top = i + 1;
	    }
	}

	System.out.println(top + " " + score);
    }

}
