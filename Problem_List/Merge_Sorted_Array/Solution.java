package Problem_List.Merge_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int[] nums2_1 = {2, 5, 6};
        solution.merge ( nums1_1, 3, nums2_1, 3 );
        System.out.println ( "Example 1: " + Arrays.toString ( nums1_1 ) ); // Output: [1, 2, 2, 3, 5, 6]

        // Example 2
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        solution.merge ( nums1_2, 1, nums2_2, 0 );
        System.out.println ( "Example 2: " + Arrays.toString ( nums1_2 ) ); // Output: [1]

        // Example 3
        int[] nums1_3 = {0};
        int[] nums2_3 = {1};
        solution.merge ( nums1_3, 0, nums2_3, 1 );
        System.out.println ( "Example 3: " + Arrays.toString ( nums1_3 ) ); // Output: [1]
    }

    public void merge ( int[] nums1, int m, int[] nums2, int n ) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if ( nums1[p1] > nums2[p2] ) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements of nums2, if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }
    }
}

