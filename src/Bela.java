
import java.util.*;

public class Bela {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] vals = {{11, 4, 3, 2, 10, 0, 0, 0}, {11, 4, 3, 20, 10, 14, 0, 0}};

		int n = in.nextInt();
		String str = in.nextLine();
		str = str.trim();
		char trump = str.charAt(0);
		int count = 0;
		for (int i = 0; i < 4 * n; i++) {
			str = in.nextLine();
			int d = 0, e=0;
			if (str.charAt(1) == trump) {
				d = 1;
			}

			switch (str.charAt(0)) {
				case 'A':
					e = 0;
					break;
				case 'K':
					e = 1;
					break;
				case 'Q':
					e = 2;
					break;
				case 'J':
					e = 3;
					break;
				case 'T':
					e = 4;
					break;
				case '9':
					e = 5;
					break;
				case '8':
					e = 6;
					break;
				case '7':
					e=7;
					break;
			}
				
			count += vals[d][e];
		}

		System.out.println(count);
	}
}
