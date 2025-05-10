package Problem_List.Q453_Minimum_Moves_to_Equal_Array_Elements;

public class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        return sum - min * nums.length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 1, 1};
        int[] nums3 = {5, 6, 8, 8, 5};

        System.out.println("Example 1 (Expected: 3): " + sol.minMoves(nums1));
        System.out.println("Example 2 (Expected: 0): " + sol.minMoves(nums2));
        System.out.println("Example 3: " + sol.minMoves(nums3));
    }
}

