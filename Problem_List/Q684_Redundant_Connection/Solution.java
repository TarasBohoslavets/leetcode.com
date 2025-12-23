package Problem_List.Q684_Redundant_Connection;

class Solution {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			if (find(parent, u) == find(parent, v)) {
				return edge; // цикл знайдено
			} else {
				union(parent, u, v);
			}
		}
		return new int[0];
	}
	
	private int find(int[] parent, int x) {
		if (parent[x] != x) {
			parent[x] = find(parent, parent[x]); // path compression
		}
		return parent[x];
	}
	
	private void union(int[] parent, int x, int y) {
		int rootX = find(parent, x);
		int rootY = find(parent, y);
		if (rootX != rootY) {
			parent[rootX] = rootY;
		}
	}
}