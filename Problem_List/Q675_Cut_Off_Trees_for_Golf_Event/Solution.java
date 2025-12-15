package Problem_List.Q675_Cut_Off_Trees_for_Golf_Event;

import java.util.*;

class Solution {
	public int cutOffTree(List<List<Integer>> forest) {
		int m = forest.size();
		int n = forest.get(0).size();
		
		// Зібрати всі дерева
		List<int[]> trees = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int h = forest.get(i).get(j);
				if (h > 1) {
					trees.add(new int[]{h, i, j});
				}
			}
		}
		
		// Сортувати за висотою
		trees.sort(Comparator.comparingInt(a -> a[0]));
		
		int totalSteps = 0;
		int startX = 0, startY = 0;
		
		for (int[] tree : trees) {
			int targetX = tree[1], targetY = tree[2];
			int steps = bfs(forest, startX, startY, targetX, targetY);
			if (steps == -1) return -1;
			totalSteps += steps;
			startX = targetX;
			startY = targetY;
		}
		
		return totalSteps;
	}
	
	// BFS для пошуку найкоротшого шляху
	private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
		if (sx == tx && sy == ty) return 0;
		
		int m = forest.size();
		int n = forest.get(0).size();
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{sx, sy, 0});
		visited[sx][sy] = true;
		
		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1], d = cur[2];
			
			for (int[] dir : dirs) {
				int nx = x + dir[0], ny = y + dir[1];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
						!visited[nx][ny] && forest.get(nx).get(ny) != 0) {
					if (nx == tx && ny == ty) return d + 1;
					visited[nx][ny] = true;
					queue.offer(new int[]{nx, ny, d + 1});
				}
			}
		}
		
		return -1; // недосяжно
	}
}
