

import java.util.Scanner;

public class WhatOnGrille {

	public static boolean[][] rotateGrille(boolean[][] g, int size) {

		boolean[][] temp = new boolean[size][size];

		// rotate and mirror
		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j >= 0; j--) {
				temp[i][j] = g[j][i];
			}
		}

		// unmirror
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size / 2; j++) {
				boolean t = temp[i][j];
				temp[i][j] = temp[i][size - j - 1];
				temp[i][size - j - 1] = t;
			}
		}

		return temp;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		
		// garbage line
		in.nextLine();
		
		String cipher;
		String[] temp = new String[size];
		boolean[][] grid = new boolean[size][size];
		boolean[][] filled = new boolean[size][size];
		char[][] answer = new char[size][size];
		
		int count = 0;
		boolean invalid = false;
		
		for (int i = 0; i < size; i++) {
			temp[i] = in.nextLine();
		}	

		cipher = in.nextLine();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = temp[i].charAt(j) == '.';
			}
		}
		
		fillGrille:
		for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (grid[j][k]) {
						answer[j][k] = cipher.charAt(count++);
						filled[j][k] = true;
					}
					
					if(count > cipher.length()){
						invalid = true;
						break fillGrille;
					}
				}
			}

			grid = rotateGrille(grid, size);
		}

		
		checkFull:
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!filled[i][j]) {
					invalid = true;					
					break checkFull;
				}
			}
		}

		if (invalid) {
			System.out.println("invalid grille");
		} 
		else {
			String str = "";
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					str += answer[i][j];
				}
			}
			System.out.println(str);
		}
	}
}
