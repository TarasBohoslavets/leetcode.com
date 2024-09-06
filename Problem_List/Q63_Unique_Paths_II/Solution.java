package Problem_List.Q63_Unique_Paths_II;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Якщо початкова або кінцева клітинка містить перешкоду, повертаємо 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        // Ініціалізуємо 2D масив для збереження кількості шляхів
        int[][] dp = new int[m][n];

        // Початкова позиція
        dp[0][0] = 1;

        // Заповнюємо перший рядок
        for (int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i-1];
        }

        // Заповнюємо перший стовпець
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }

        // Заповнюємо решту таблиці
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // Якщо перешкода
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; // Сума шляхів зверху і зліва
                }
            }
        }

        // Повертаємо кількість шляхів до нижнього правого кута
        return dp[m-1][n-1];
    }
}