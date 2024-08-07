package Problem_List.Q31_Next_Permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find the largest index `i` where `nums[i] < nums[i + 1]`
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Find the largest index `j` after `i` where `nums[i] < nums[j]`
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // Step 3: Swap `nums[i]` and `nums[j]`
            swap(nums, i, j);
        }

        // Step 4: Reverse the array from `i + 1` to the end
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println("Expected: [1, 3, 2], Actual: " + Arrays.toString(nums1));

        // Example 2
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println("Expected: [1, 2, 3], Actual: " + Arrays.toString(nums2));

        // Example 3
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println("Expected: [1, 5, 1], Actual: " + Arrays.toString(nums3));
    }
}
