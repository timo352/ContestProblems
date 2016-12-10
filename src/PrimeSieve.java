

import java.util.BitSet;
import java.util.Scanner;

public class PrimeSieve {
	
	public static int num;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		num = in.nextInt();
		int q = in.nextInt();

		BitSet primes = new BitSet(num+1);
		
		int count = getPrimes(primes);
		
		System.out.println(count);

		for (int i = 0; i < q; i++) {
			int x = in.nextInt();
			if (primes.get(x)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
	
	public static int getPrimes(BitSet sieve) {
		int limitSqrt = (int) Math.sqrt((double) num + 1);
		
		int count = 0;
		
		sieve.set(2);
		sieve.set(3);

		count = 2;
		
		for (int x = 1; x <= limitSqrt; x++) {
			for (int y = 1; y <= limitSqrt; y++) {
				// first quadratic using m = 12 and r in R1 = {r : 1, 5}
				int n = (4 * x * x) + (y * y);
				if (n < num + 1 && (n % 12 == 1 || n % 12 == 5)) {
					sieve.flip(n);
					if(sieve.get(n)){
						count++;
					} else {
						count--;
					}
				}
				// second quadratic using m = 12 and r in R2 = {r : 7}
				n = (3 * x * x) + (y * y);
				if (n < num+1 && (n % 12 == 7)) {
					sieve.flip(n);
					if(sieve.get(n)){
						count++;
					} else {
						count--;
					}
				}
				// third quadratic using m = 12 and r in R3 = {r : 11}
				n = (3 * x * x) - (y * y);
				if (x > y && n < num+1 && (n % 12 == 11)) {
					sieve.flip(n);
					if(sieve.get(n)){
						count++;
					} else {
						count--;
					}
				}
			}
		}
		for (int n = 5; n <= limitSqrt; n++) {
			if (sieve.get(n)) {
				int x = n * n;
				for (int i = x; i < num+1; i += x) {
					if(sieve.get(i)){
						count--;
					}
					sieve.clear(i);
				}
			}
		}
		
		return count;
	}
}
