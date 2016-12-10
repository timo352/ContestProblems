import java.util.*;

public class SuperCompy {

    public static int[] mem;

    public static int count(int start, int end) {
	return count(getLeaf(start), getLeaf(end), 0);
    }

    public static int count(int start, int end, int n) {
	
	int i = getStartVal(n);
	int j = getEndVal(n);

	if (start <= i && end >= j) {
	    return mem[n];
	} else if (i > end || j < start) {
	    return 0;
	} else {
	    return count(start, end, leftChild(n)) + count(start, end, rightChild(n));
	}
    }

    public static int getStartVal(int n) {
	if(isLeaf(n)){
	    return n;
	}
	
	if (n == 0) {
	    return mem.length / 2;
	}

	if (isLeftChild(n)) {
	    return getStartVal(getParent(n));
	} else {

	    int count = 1;
	    int a = getParent(n);
	    while (a != 0) {
		a = getParent(a);
		count++;
	    }
	    int range = (int)Math.pow(2, Math.floor(Math.log10(mem.length)/Math.log10(2)) - count);

	    return getEndVal(getParent(n)) - range + 1;
	}
    }
    
    public static int getEndVal(int n){
	if(isLeaf(n)){
	    return n;
	}
	if(n == 0){
	    return mem.length-1;
	}
	
	if(isRightChild(n)){
	    return getEndVal(getParent(n));
	} else{	    
	    int count = 1;
	    int a = getParent(n);
	    while (a != 0) {
		a = getParent(a);
		count++;
	    }
	    int range = (int)Math.pow(2, Math.floor(Math.log10(mem.length)/Math.log10(2)) - count);

	    return getStartVal(getParent(n)) + range - 1;	    
	}
    }

    public static void flip(int n) {
	mem[getLeaf(n)] = (mem[getLeaf(n)] + 1) % 2;
	recurseAdjust(mem[getLeaf(n)], getParent(getLeaf(n)));
    }

    public static void recurseAdjust(int flip, int n) {
	mem[n] += (flip == 0) ? -1 : 1;
	if (n != 0) {
	    recurseAdjust(flip, getParent(n));
	}
    }
    
    public static boolean isLeaf(int n){
	return leftChild(n) >= mem.length;
    }

    public static int getLeaf(int n) {
	return (mem.length+1) / 2 + n - 1;

    }

    public static int getParent(int n) {
	return (n - 1) / 2;
    }

    public static int leftChild(int n) {
	return (n + 1) * 2 - 1;
    }

    public static boolean isLeftChild(int n) {
	return n % 2 != 0;
    }

    public static boolean isRightChild(int n) {
	return n % 2 == 0;
    }

    public static int rightChild(int n) {
	return (n + 1) * 2;
    }

    public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);

	int N = in.nextInt();
	int K = in.nextInt();
	in.nextLine();

	// log_2(X) = log_10(x) / log_10(2)
	int size = (int)(Math.log10(N) / Math.log10(2)) + 1;	
	mem = new int[(int)Math.pow(2, size+1) - 1];
	
	for (int i = 0; i < K; i++) {
	    String line = in.next();

	    if (line.charAt(0) == 'C') {
		// C (COUNT THE NUMBER OF BITS)
		int startBit = in.nextInt() - 1;
		int endBit = in.nextInt() - 1;
		
		int c = count(startBit, endBit);
		
		System.out.println(c);
	    } else {
		// F
		int bit = in.nextInt() - 1;
		flip(bit);
	    }
	    in.nextLine();
	}
    }
}