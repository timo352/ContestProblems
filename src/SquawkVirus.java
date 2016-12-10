

import java.util.LinkedList;
import java.util.Scanner;

public class SquawkVirus {
	
	public static class Squawker{
		
		public long squawksToSend;
		public long squawksReceived;
		public LinkedList<Integer> connections;
		
		public Squawker(){
			squawksReceived = 0;
			squawksToSend = 0;
			connections = new LinkedList<Integer>();
		}
	}
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int numUsers = in.nextInt();
		int numLinks = in.nextInt();
		int infectedUser = in.nextInt();
		int numMinutes = in.nextInt();
		
		long numSquawks = 0;
		
		Squawker[] users = new Squawker[numUsers];
		for(int i=0; i<numUsers; i++){
			users[i] = new Squawker();
		}
		
		for(int i=0; i<numLinks; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			
			users[a].connections.add(b);
			users[b].connections.add(a);
		}
		
		users[infectedUser].squawksToSend = 1;
		
		for(int i=0; i<numMinutes; i++){
			numSquawks = 0;
			for(int j=0; j<numUsers; j++){
				for(int k=0; k<users[j].connections.size(); k++){
					users[users[j].connections.get(k)].squawksReceived += users[j].squawksToSend;
					numSquawks += users[j].squawksToSend;
				}
			}
			
			for(int j=0; j<numUsers; j++){
				users[j].squawksToSend = users[j].squawksReceived;
				users[j].squawksReceived = 0;
			}			
		}		
		
		System.out.println(numSquawks);
	}
}
