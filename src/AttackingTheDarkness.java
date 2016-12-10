

public class AttackingTheDarkness {

	public static int arraySize = 6*20*2+1;
	public static int basePointer = 6*20;
	
	public static int[] add(int[] pdf, int dieVal) {
		
		int[] temp = new int[pdf.length];
		int base, end;
		// add new values to pdf
		if(dieVal < 0){
			base = dieVal;
			end = -1;
		} else{
			base = 1;
			end = dieVal;
		}
		for (int j = base; j <= end; j++) {
			for (int i = 0; i < arraySize; i++) {
				if (pdf[i] > 0) {
					temp[i + j]++;
				}
			}
		}
		
		
		
		return temp;
	}
	
	public static int[] addFirst(int[] pdf, int dieVal){
		
		for(int i=1; i<=dieVal; i++){
			pdf[i+basePointer]++;
		}
		
		return pdf;
	}

	public static String calculateProb(int[] pdf, int goal){
		
		int goalNum = 0, totNum =0;
		
		for(int i=0; i<pdf.length; i++){
			if(i-basePointer>=goal){
				goalNum += pdf[i];
			}
			totNum += pdf[i];
		}
		
		int gcd = GCD(goalNum, totNum);
		
		if(totNum == 0){			
			return (goal >= 0)? "1" : "0";
		} else if(goalNum == 0){
			return "0";
		} else if(gcd == totNum){
			return "1";
		} else{
			return (goalNum/gcd) + "/" + (totNum/gcd);
		}
	}
	
	public static int GCD(int a, int b){
		if(b == 0){
			return a;
		} else{
			return GCD(b, a%b);
		}
	}
	
	public static void main(String[] args) {

		int[] pdf = new int[arraySize];
		int goal;
		
		goal = 65;
		pdf = addFirst(pdf, 20);
		pdf = add(pdf, 20);
		pdf = add(pdf, 20);
		pdf = add(pdf, 20);
		pdf = add(pdf, 20);
		pdf = add(pdf, 20);
		System.out.println(calculateProb(pdf, goal));
		
				
		
		for (int i = 0; i < pdf.length; i++) {
			System.out.println((i-basePointer) + " : " + pdf[i]);
		}
		System.out.println();
	}
}
