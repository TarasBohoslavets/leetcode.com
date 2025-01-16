package Problem_List.Q279_Perfect_Squares;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        // Масив для збереження мінімальної кількості квадратів для кожного числа
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 потребує 0 ідеальних квадратів

        // Перебір усіх чисел від 1 до n
        for (int i = 1; i <= n; i++) {
            // Перевірка всіх ідеальних квадратів, менших або рівних i
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}