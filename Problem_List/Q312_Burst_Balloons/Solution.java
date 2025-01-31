package Problem_List.Q312_Burst_Balloons;

import java.util.*;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];  // Додаємо 1 на початок і кінець
        arr[0] = arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];  // DP масив

        // Перебираємо довжину підвідрізків
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                // Пробуємо останню кулю, що лопається
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            arr[left - 1] * arr[k] * arr[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }

        return dp[1][n];  // Відповідь у всьому масиві [1, n]
    }
}
