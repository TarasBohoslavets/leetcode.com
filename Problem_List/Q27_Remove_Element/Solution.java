package Problem_List.Q27_Remove_Element;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement ( nums1, val1 );
        System.out.println ( "Example 1:" );
        System.out.println ( "Output: " + k1 ); // Output should be 2
        printArray ( nums1, k1 );

        // Example 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement ( nums2, val2 );
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Output: " + k2 ); // Output should be 5
        printArray ( nums2, k2 );
    }

    // Helper method to print the array up to a given length
    private static void printArray ( int[] nums, int length ) {
        System.out.print ( "nums = [" );
        for (int i = 0; i < length; i++) {
            System.out.print ( nums[i] );
            if ( i < length - 1 ) {
                System.out.print ( ", " );
            }
        }
        System.out.println ( "]" );
    }

    public int removeElement ( int[] nums, int val ) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if ( nums[fast] != val ) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}