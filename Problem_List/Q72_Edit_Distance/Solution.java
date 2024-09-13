package Problem_List.Q72_Edit_Distance;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Створюємо dp-таблицю розміром (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Ініціалізація базових випадків
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // Видалення всіх символів з word1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // Вставка всіх символів з word2
        }

        // Основний алгоритм
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Якщо символи збігаються, то не потрібна заміна
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Вибираємо мінімум з трьох операцій: вставка, видалення, заміна
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        // Повертаємо мінімальну кількість операцій для перетворення word1 в word2
        return dp[m][n];
    }
}