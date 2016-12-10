

import java.util.Scanner;

public class EightQueens {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		boolean occupied[][] = new boolean[8][8];
		boolean valid = true;
		String[] str = new String[8];
		int numQueens = 0;
		
		for(int i=0; i<8; i++){
			str[i] = in.nextLine();
		}
		
		code:
		for(int i=0; i<8; i++){
			String line = str[i];
			for(int j=0; j<8; j++){
				
				if(line.charAt(j) == '*'){
					
					for(int k=0; k<8; k++){
						if(occupied[i][k] || occupied[k][j]){
							// INVALID
							valid = false;
							break code;
						}
					}
					
					occupied[i][j] = true;
					numQueens++;
					
					int layer = i-1;
					int distance = 1;
					while(layer >= 0 && ((j - distance) >= 0 || (j+distance) < 8)){
						
						
						if((j-distance >=0 && occupied[layer][j-distance]) || (j+distance < 8 && occupied[layer][j+distance])){
							// INVALID
							valid = false;
							break code;
							
						}
						layer--;
						distance++;						
					}
				}
				
			}
		}
		
		if(valid && numQueens == 8){
			System.out.println("valid");
		} else{
			System.out.println("invalid");
		}
	}
}
