package Problem_List.Q446_Arithmetic_Slices_II_Subsequence;

import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] dp = new HashMap[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j]; // Use long to avoid overflow
                int countAtJ = dp[j].getOrDefault(diff, 0);
                int countAtI = dp[i].getOrDefault(diff, 0);

                dp[i].put(diff, countAtI + countAtJ + 1); // +1 for the pair (j, i)
                result += countAtJ; // Count only sequences of length ≥ 3
            }
        }

        return result;
    }
}
