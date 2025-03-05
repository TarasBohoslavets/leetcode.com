package Problem_List.Q376_Wiggle_Subsequence;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        // Edge case: if the array length is less than 2, it's trivially a wiggle sequence
        if (nums.length < 2) {
            return nums.length;
        }

        // Initialize two variables to keep track of the longest wiggle subsequences
        int up = 1, down = 1;

        // Iterate through the array to fill up and down
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // If current element is greater than the previous one, it extends a downward subsequence
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                // If current element is smaller, it extends an upward subsequence
                down = up + 1;
            }
        }

        // The answer will be the maximum of up and down sequences
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        WiggleSubsequence solution = new WiggleSubsequence();

        // Example 1:
        int[] nums1 = {1, 7, 4, 9, 2, 5};
        System.out.println(solution.wiggleMaxLength(nums1)); // Output: 6

        // Example 2:
        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(solution.wiggleMaxLength(nums2)); // Output: 7

        // Example 3:
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution.wiggleMaxLength(nums3)); // Output: 2
    }
}