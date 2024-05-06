package Problem_List.Remove_Duplicates_from_Sorted_Array;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Example 1:");
        System.out.println("Output: " + k1); // Output should be 2
        printArray(nums1, k1);

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("\nExample 2:");
        System.out.println("Output: " + k2); // Output should be 5
        printArray(nums2, k2);
    }

    // Helper method to print the array up to a given length
    private static void printArray(int[] nums, int length) {
        System.out.print("nums = [");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
