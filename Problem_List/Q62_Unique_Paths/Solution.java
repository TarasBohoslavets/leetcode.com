package Problem_List.Q62_Unique_Paths;

class Solution {
    public int uniquePaths(int m, int n) {
        // Створюємо 2D масив для збереження кількості шляхів
        int[][] dp = new int[m][n];

        // Ініціалізуємо перший рядок і перший стовпець
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // Лише один спосіб досягти кожної клітинки першого стовпця
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // Лише один спосіб досягти кожної клітинки першого рядка
        }

        // Заповнюємо решту таблиці
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // Рух зверху і зліва
            }
        }

        // Повертаємо кількість шляхів до нижнього правого кута
        return dp[m-1][n-1];
    }
}