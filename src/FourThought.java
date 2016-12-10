import java.util.*;
import java.io.*;
import java.math.*;


public class FourThought {
	
	public static int test(char c, char d, char e){
		char[] f = {c,d,e};
		ArrayList<Character> priority = new ArrayList();
		priority.add(c);
		priority.add(d);
		priority.add(e);
		
		ArrayList<Character> operators = new ArrayList(priority);
		ArrayList<Integer> operands = new ArrayList();
		for(int i=0; i<4; i++){
			operands.add(4);
		}
		
		int i=0;
		for(char j: priority){
			if(j == '*' || j == '/'){
				priority.set(i, '1');
			} else{
				priority.set(i, '2');
			}
			i++;
		}
		
		int result = 0;
		while(priority.contains('1')){
			int k = priority.indexOf('1');
			
			if(operators.get(k) == '*'){
				operands.set(k, operands.get(k) * operands.get(k+1));
				
				operands.remove(k+1);
				operators.remove(k);
				priority.remove(k);
				
				result = operands.get(k);
			} else if(priority.indexOf('1') >= 0 && operators.get(k) == '/'){
				operands.set(k, operands.get(k) / operands.get(k+1));
				
				operands.remove(k+1);
				operators.remove(k);
				priority.remove(k);
				
				result = operands.get(k);
			}
		}
		
		while(priority.contains('2')){
			int g = priority.indexOf('2');
			if(operators.get(g) == '+'){
				operands.set(g, operands.get(g) + operands.get(g+1));
				
				operands.remove(g+1);
				operators.remove(g);
				priority.remove(g);
				
				result = operands.get(g);
			} else if(operators.get(g) == '-'){
				operands.set(g, operands.get(g) - operands.get(g+1));
				
				operands.remove(g+1);
				operators.remove(g);
				priority.remove(g);
				
				result = operands.get(g);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		
		char[] opers = {'+','-','*','/'};
		int numCases = in.nextInt();
		
		for(int currCase=0; currCase<numCases; currCase++){
			int solution = in.nextInt();
			boolean sol = false;
			
			loop:
			for(char c:opers){
				for(char d:opers){
					for(char e:opers){
						if(test(c,d,e) == solution){
							System.out.println("4 " + c + " 4 " + d + " 4 " + e + " 4 = " + solution);
							sol = true;
							break loop;
						}
					}
				}
			}
			if(!sol) System.out.println("no solution");
		}
		
	}
	
}
