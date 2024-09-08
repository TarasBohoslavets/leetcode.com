package Problem_List.Q64_Minimum_Path_Sum;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Ініціалізуємо перший стовпець
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];  // Сума з попередньою клітинкою зверху
        }

        // Ініціалізуємо перший рядок
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];  // Сума з попередньою клітинкою зліва
        }

        // Заповнюємо решту сітки, обираючи мінімальний шлях зліва чи зверху
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        // Повертаємо результат — мінімальна сума шляху в правому нижньому куті
        return grid[m-1][n-1];
    }
}
