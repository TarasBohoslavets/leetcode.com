package Problem_List.Q593_Valid_Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[][] points = {p1, p2, p3, p4};
		List<Integer> dists = new ArrayList<>();
		
		// Compute all pairwise squared distances
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				dists.add(distanceSquared(points[i], points[j]));
			}
		}
		
		// Sort distances
		Collections.sort(dists);
		
		// A square has:
		// - 4 equal sides (smallest 4 distances)
		// - 2 equal diagonals (largest 2 distances)
		// - All distances > 0
		return dists.get(0) > 0 &&
				dists.get(0).equals(dists.get(1)) &&
				dists.get(1).equals(dists.get(2)) &&
				dists.get(2).equals(dists.get(3)) &&
				dists.get(4).equals(dists.get(5));
	}
	
	private int distanceSquared(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		return dx * dx + dy * dy;
	}
}
