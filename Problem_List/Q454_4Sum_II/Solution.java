package Problem_List.Q454_4Sum_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Add all possible sums of nums1 + nums2 to a hashmap
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Step 2: For each sum of nums3 + nums4, look for -(sum) in the hashmap
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                count += map.getOrDefault(-sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println("Example 1 (Expected: 2): " + sol.fourSumCount(nums1, nums2, nums3, nums4));

        int[] nums5 = {0};
        int[] nums6 = {0};
        int[] nums7 = {0};
        int[] nums8 = {0};

        System.out.println("Example 2 (Expected: 1): " + sol.fourSumCount(nums5, nums6, nums7, nums8));
    }
}
