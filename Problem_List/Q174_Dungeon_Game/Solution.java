package Problem_List.Q174_Dungeon_Game;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // DP масив для збереження мінімального здоров'я
        int[][] dp = new int[m][n];

        // Початкова позиція (в нижньому правому куті)
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);

        // Заповнюємо останній рядок
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }

        // Заповнюємо останній стовпчик
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
        }

        // Заповнюємо решту таблиці
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealth = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, minHealth - dungeon[i][j]);
            }
        }

        // Мінімальне здоров'я для старту
        return dp[0][0];
    }
}

