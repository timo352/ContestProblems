

import java.util.Scanner;

public class _2048 {
	
	public static final int LEFT = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
			
		int[][] board = new int[4][4];
		boolean[][] adjustBoard = new boolean[4][4];
		int direction;
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				board[i][j] = in.nextInt();
			}
		}
		direction = in.nextInt();
		
		for(int i=0; i<4; i++){
			for(int j=1; j<4; j++){
				for(int k=j; k>0; k--){
					
					int row = i, col = k;
					
					if(direction == LEFT){

						// if they are the same, combine them into double the value
						if(board[row][col] == board[row][col-1] && !adjustBoard[row][col-1] && !adjustBoard[row][col] && board[row][col] != 0){
							board[row][col-1] *= 2;
							adjustBoard[row][col-1] = true;
							board[row][col] = 0;
						}

						// if it's blank, move it over
						if(board[row][col-1] == 0){
							board[row][col-1] = board[row][col];
							board[row][col] = 0;
						}			
					}
					
					if(direction == UP){
						
						// if they are the same, combine them into double the value
						if(board[col][row] == board[col-1][row] && !adjustBoard[col-1][row] && !adjustBoard[col][row] && board[col][row] != 0){
							board[col-1][row] *= 2;
							adjustBoard[col-1][row] = true;
							board[col][row] = 0;
						}

						// if it's blank, move it over
						if(board[col-1][row] == 0){
							board[col-1][row] = board[col][row];
							board[col][row] = 0;
						}	
						
						
					}
					
					if(direction == RIGHT){

						// if they are the same, combine them into double the value
						if(board[row][4-col-1] == board[row][4-col] &&  !adjustBoard[row][4-col] && !adjustBoard[row][4-col-1] && board[row][4-1-col] != 0){
							board[row][4-col] *= 2;
							adjustBoard[row][4-col] = true;
							board[row][4-col-1] = 0;
						}

						// if it's blank, move it over
						if(board[row][4-col] == 0){
							board[row][4-col] = board[row][4-col-1];
							board[row][4-col-1] = 0;
						}			
					}
					
					if(direction == DOWN){
						
						// if they are the same, combine them into double the value
						if(board[4-col-1][row] == board[4-col][row] && !adjustBoard[4-col][row] && !adjustBoard[4-col-1][row] && board[4-col-1][row] != 0){
							board[4-col][row] *= 2;
							adjustBoard[4-col][row] = true;
							board[4-col-1][row] = 0;
						}

						// if it's blank, move it over
						if(board[4-col][row] == 0){
							board[4-col][row] = board[4-col-1][row];
							board[4-col-1][row] = 0;
						}	
						
						
					}
				}
			}			
		}
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(board[i][j]);
				if(j!=3){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
}
