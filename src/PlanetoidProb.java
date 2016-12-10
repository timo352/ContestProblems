import java.util.*;

public class PlanetoidProb {

	public static int xSize, ySize, zSize;
	public static int t;

	public static int mod(int x, int y) {
		int result = x % y;
		if (result < 0) {
			result += y;
		}
		return result;
	}

	public static class PlanetComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			Planetoid p1 = (Planetoid) o1;
			Planetoid p2 = (Planetoid) o2;

			if (p2.mass == p1.mass) {
				if (p2.x == p1.x) {
					if (p2.y == p1.y) {
						return Integer.compare(p1.z, p2.z);
					}
					return Integer.compare(p1.y, p2.y);
				}
				return Integer.compare(p1.x, p2.x);
			}
			return Integer.compare(p2.mass, p1.mass);
		}

	}

	public static class Planetoid {

		int mass;
		int x, y, z;
		int v_x, v_y, v_z;

		public Planetoid(int m, int x, int y, int z, int v_x, int v_y, int v_z) {
			this.mass = m;
			this.x = x;
			this.y = y;
			this.z = z;
			this.v_x = v_x;
			this.v_y = v_y;
			this.v_z = v_z;
		}

		public static boolean willCollide(Planetoid p1, Planetoid p2) {
			
			int start_x = mod(p2.x - p1.x, xSize);
			int start_y = mod(p2.y - p1.y, ySize);
			int start_z = mod(p2.z - p1.z, zSize);
			
			int vel_x = p2.v_x - p1.v_x;
			int vel_y = p2.v_y - p1.v_y;
			int vel_z = p2.v_z - p1.v_z;
			
			int x = start_x;
			int y = start_y;
			int z = start_z;
			
			int count_x = 0;
			int count_y = 0;
			
			while(x != 0){
				x = mod(x + vel_x, xSize);
				y = mod(y + vel_y, ySize);
				z = mod(z + vel_z, zSize);
				
				count_x++;
				
				if(x == start_x){
					return false;
				}			
			}
			if(count_x == 0) count_x = 1;
			while(y != 0){
				y = mod(y + (count_x)*vel_y, ySize);
				z = mod(z + (count_x)*vel_z, zSize);
				
				count_y++;
				
				if(y == start_y){
					return false;
				}
			}
			if(count_y == 0) count_y = 1;
			
			while(z != 0){
				z = mod(z + count_x*count_y*vel_z, zSize);
				
				if(z == start_z){
					return false;
				}
			}
			
			return true;		
			
			
			
			
			/*t = 0;
			// check x position
			int x_vel = p1.v_x - p2.v_x;
			int x_start = mod((p1.x - p2.x) + x_vel * t,xSize);
			int x_rel = xSize;

			while (x_start != 0 && x_rel != 0 && x_rel != x_start) {
				t++;
				x_rel = mod((x_vel * t + x_start),xSize);
			}
			if (x_rel == x_start) {
				return false;
			}

			// check y position
			int y_vel = p1.v_y - p2.v_y;
			int y_start = mod((p1.y - p2.y) + y_vel * t,ySize);
			int y_rel = ySize;

			while (y_start != 0 && y_rel != 0 && y_rel != y_start) {
				t++;
				y_rel = mod((y_vel * t + y_start),ySize);
			}
			if (y_rel == y_start) {
				return false;
			}

			// check z position
			int z_vel = p1.v_z - p2.v_z;
			int z_start = mod((p1.z - p2.z) + z_vel * t,zSize);
			int z_rel = zSize;

			while (z_start != 0 && z_rel != 0 && z_rel != z_start) {
				t++;
				z_rel = mod((z_vel * t + z_start), zSize);
			}
			return z_rel != z_start;
			*/
		}
	}

	public static boolean collisionsStillPossible(ArrayList<Planetoid> planets) {

		for (int i = 0; i < planets.size(); i++) {
			for (int j = i + 1; j < planets.size(); j++) {
				if (Planetoid.willCollide(planets.get(i), planets.get(j))) {
					return true;
				}
			}
		}
		return false;
	}

	public static ArrayList<Planetoid> calculateNewPosition(ArrayList<Planetoid> planets, int time) {
		for (Planetoid p : planets) {
			p.x = mod(p.v_x*time + p.x, xSize);
			p.y = mod(p.v_y*time + p.y, ySize);
			p.z = mod(p.v_z*time + p.z, zSize);
		}
		return planets;
	}
	
	public static ArrayList<Planetoid> doCollisions(ArrayList<Planetoid> planets){
		ArrayList<ArrayList<Integer>> indexes = new ArrayList();
		for(int i=0; i<planets.size(); i++){
			indexes.add(new ArrayList());
			for(int j=0; j<planets.size(); j++){
				if(planets.get(i).x == planets.get(j).x && planets.get(i).y == planets.get(j).y && planets.get(i).z == planets.get(j).z){
					indexes.get(i).add(j);
				}
			}
		}
		int x = 0;
		ArrayList<Integer> toRemove = new ArrayList();
		for(int i=0; i<indexes.size(); i++){
			ArrayList<Integer> a = indexes.get(i);			
			for(int j = i+1; j<indexes.size(); j++){
				ArrayList<Integer> b = indexes.get(j);
				if(a.equals(b) && !toRemove.contains(j)){
					toRemove.add(j);
				}
			}
		}
		
		for(int i=toRemove.size()-1; i>=0; i--){
			indexes.remove((int)toRemove.get(i));
		}
		
		ArrayList<Planetoid> newPlanets = new ArrayList();
		for(ArrayList<Integer> a : indexes){
			int mass = 0, v_x = 0, v_y = 0, v_z = 0;
			int x_new = planets.get(a.get(0)).x;
			int y_new = planets.get(a.get(0)).y;
			int z_new = planets.get(a.get(0)).z;
			
			for(int i=0; i<a.size(); i++){
				mass += planets.get(a.get(i)).mass;
				v_x += planets.get(a.get(i)).v_x;
				v_y += planets.get(a.get(i)).v_y;
				v_z += planets.get(a.get(i)).v_z;
			}
			
			Planetoid p = new Planetoid(mass, x_new, y_new, z_new, v_x/a.size(), v_y/a.size(), v_z/a.size());
			newPlanets.add(p);
		}
		
		return newPlanets;		
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int numPlanets = in.nextInt();
		xSize = in.nextInt();
		ySize = in.nextInt();
		zSize = in.nextInt();

		ArrayList<Planetoid> planets = new ArrayList();

		for (int i = 0; i < numPlanets; i++) {
			planets.add(new Planetoid(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
		}

		while (collisionsStillPossible(planets)) {
			planets = calculateNewPosition(planets, 1);			
			planets = doCollisions(planets);
		}

		planets.sort(new PlanetComparator());
		System.out.println(planets.size());
		for (int i = 0; i < planets.size(); i++) {
			Planetoid p = planets.get(i);
			System.out.println("P" + i + ": " + p.mass + " " + p.x + " " + p.y + " " + p.z + " " + p.v_x + " " + p.v_y + " " + p.v_z);
		}
	}
}
