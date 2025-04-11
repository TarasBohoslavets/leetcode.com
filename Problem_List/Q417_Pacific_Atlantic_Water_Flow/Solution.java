package Problem_List.Q417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Запускаємо DFS з узбережжя Тихого океану
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, cols - 1, atlantic, heights[i][cols - 1]);
        }

        // Запускаємо DFS з узбережжя Атлантичного океану
        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, rows - 1, j, atlantic, heights[rows - 1][j]);
        }

        // Додаємо до результату лише клітинки, які reachable з обох DFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return;

        visited[r][c] = true;

        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            dfs(heights, newRow, newCol, visited, heights[r][c]);
        }
    }
}
