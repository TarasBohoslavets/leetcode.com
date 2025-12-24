package Problem_List.Q685_Redundant_Connection_II;

class Solution {
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];
		int[] candA = null, candB = null;
		
		// Крок 1: перевірка на два батьки
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			if (parent[v] == 0) {
				parent[v] = u;
			} else {
				// v має двох батьків
				candA = new int[]{parent[v], v};
				candB = new int[]{u, v};
				edge[1] = 0; // позначаємо candB як "видалене"
			}
		}
		
		// Крок 2: Union-Find для перевірки циклу
		for (int i = 1; i <= n; i++) parent[i] = i;
		
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			if (v == 0) continue; // пропускаємо candB
			
			int pu = find(parent, u);
			int pv = find(parent, v);
			if (pu == pv) {
				// цикл знайдено
				if (candA == null) return edge; // немає двох батьків
				return candA; // є два батьки → видаляємо перше ребро
			}
			parent[pu] = pv;
		}
		
		return candB; // якщо немає циклу → видаляємо друге ребро
	}
	
	private int find(int[] parent, int x) {
		if (parent[x] != x) parent[x] = find(parent, parent[x]);
		return parent[x];
	}
}
