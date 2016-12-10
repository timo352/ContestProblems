

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Rings {

	public static class TreeLocation{
		public int age;
		public int x;
		public int y;
		
		public TreeLocation(){
			age = 0;
			x = 0;
			y = 0;
		}
	}
	
	public static class TreeComparator implements Comparator{

		public int compare(Object o1, Object o2) {
			
			return Integer.compare(((TreeLocation)o1).age, ((TreeLocation)o2).age);
			
		}
		
	}
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int maxRings = 0;
		int height = in.nextInt();
		int width = in.nextInt();
		in.nextLine();
		TreeLocation[][] tree = new TreeLocation[height+2][width+2];
		
		for(int i=0; i<height+2; i++){
			for(int j=0; j<width+2; j++){
				tree[i][j] = new TreeLocation();
				tree[i][j].age = 0;
				tree[i][j].x = j;
				tree[i][j].y = i;
			}
		}
		
		TreeComparator comp = new TreeComparator();
		PriorityQueue<TreeLocation> q = new PriorityQueue<TreeLocation>(comp);
		
		for(int i=0; i<height+2; i++){
			
			String line = "HELLO!!";
			
			if(i<height+1 && i>0){
				line = in.nextLine();
			}
			
			for(int j=0; j<width+2; j++){
				
				if(j<width+1 && j>0 && i>0 && i<height+1){
					if(line.charAt(j-1) == 'T'){
						tree[i][j].age = -1;
					} else {
						q.add(tree[i][j]);
					}
				} else {
					q.add(tree[i][j]);
				}
			}
		}
		
		
		while(!q.isEmpty()){
			TreeLocation t = q.poll();
			
			// check above
			if(t.y > 0 && tree[t.y-1][t.x].age == -1){
				tree[t.y-1][t.x].age = t.age + 1;
				q.add(tree[t.y-1][t.x]);
			}
			// check below
			if(t.y+1 < height+2 && tree[t.y+1][t.x].age == -1){
				tree[t.y+1][t.x].age = t.age + 1;
				q.add(tree[t.y+1][t.x]);
			}
			// check left
			if(t.x > 0 && tree[t.y][t.x-1].age == -1){
				tree[t.y][t.x-1].age = t.age + 1;
				q.add(tree[t.y][t.x-1]);
			}
			// check right
			if(t.x+1 < width+2 && tree[t.y][t.x+1].age == -1){
				tree[t.y][t.x+1].age = t.age + 1;
				q.add(tree[t.y][t.x+1]);
			}
			
			if(q.isEmpty()){
				maxRings = t.age;
			}
		}
		
		for(int i=1; i<height+1; i++){
			for(int j=1; j<width+1; j++){
				
				String dots;
				if(maxRings >= 10){
					dots = "..";
				} else{
					dots = ".";
				}
				if(tree[i][j].age >= 10){
					dots = ".";
				}
				System.out.print(dots);
				if(tree[i][j].age == 0){
					if(dots.equals(".") && maxRings >= 10){
						System.out.print("..");
					} else {
						System.out.print(".");
					}
				}else{					
					System.out.print(tree[i][j].age);
				}
			}
			System.out.println();
		}
				
	}
}
