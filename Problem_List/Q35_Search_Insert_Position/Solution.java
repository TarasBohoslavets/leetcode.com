package Problem_List.Q35_Search_Insert_Position;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int result1 = solution.searchInsert ( nums1, target1 );
        System.out.println ( "Example 1:" );
        System.out.println ( "Output: " + result1 ); // Output should be 2

        // Example 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int result2 = solution.searchInsert ( nums2, target2 );
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Output: " + result2 ); // Output should be 1

        // Example 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int result3 = solution.searchInsert ( nums3, target3 );
        System.out.println ( "\nExample 3:" );
        System.out.println ( "Output: " + result3 ); // Output should be 4
    }

    public int searchInsert ( int[] nums, int target ) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ( nums[mid] == target ) {
                return mid;
            } else if ( nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

