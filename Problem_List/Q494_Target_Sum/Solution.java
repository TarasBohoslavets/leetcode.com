package Problem_List.Q494_Target_Sum;

import java.util.Arrays;

public class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum(); // Швидкий підрахунок суми масиву
        int zeroCount = 0;

        int result = sum - Math.abs(target);
        if (result < 0 || result % 2 != 0) return 0;

        result /= 2; // Виконуємо поділ окремо для кращої читабельності
        int[] dp = new int[result + 1];
        dp[0] = 1;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            for (int j = result; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[result] << zeroCount; // Врахування нульових елементів
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target)); // Очікуваний результат: 5
    }
}


