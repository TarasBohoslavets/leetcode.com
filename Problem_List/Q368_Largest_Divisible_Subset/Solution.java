package Problem_List.Q368_Largest_Divisible_Subset;

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 0, lastIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (lastIndex != -1) {
            result.add(nums[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestDivisibleSubset(new int[]{1, 2, 3}));  // [1,2] or [1,3]
        System.out.println(sol.largestDivisibleSubset(new int[]{1, 2, 4, 8}));  // [1,2,4,8]
    }
}
