package Problem_List.Q407_Trapping_Rain_Water_II;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0; // Якщо менше 3x3, вода не може зберігатися

        // Мін-купа для зберігання висот
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));
        boolean[][] visited = new boolean[m][n];

        // Додаємо всі граничні комірки у чергу
        for (int i = 0; i < m; i++) {
            for (int j : new int[]{0, n - 1}) { // Ліва і права межі
                minHeap.offer(new Cell(i, j, heightMap[i][j]));
                visited[i][j] = true;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i : new int[]{0, m - 1}) { // Верхня і нижня межі
                minHeap.offer(new Cell(i, j, heightMap[i][j]));
                visited[i][j] = true;
            }
        }

        // Напрямки руху (вгору, вниз, вліво, вправо)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int waterTrapped = 0;

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int[] d : directions) {
                int ni = cell.row + d[0], nj = cell.col + d[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n || visited[ni][nj]) continue;

                visited[ni][nj] = true;
                int newHeight = heightMap[ni][nj];
                if (newHeight < cell.height) {
                    waterTrapped += cell.height - newHeight;
                }
                minHeap.offer(new Cell(ni, nj, Math.max(cell.height, newHeight))); // Обновлюємо рівень води
            }
        }

        return waterTrapped;
    }

    static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] heightMap1 = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        System.out.println("Output: " + solution.trapRainWater(heightMap1)); // Очікуваний результат: 4

        int[][] heightMap2 = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        };
        System.out.println("Output: " + solution.trapRainWater(heightMap2)); // Очікуваний результат: 10
    }
}
