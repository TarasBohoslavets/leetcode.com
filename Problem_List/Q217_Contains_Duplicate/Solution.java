package Problem_List.Q217_Contains_Duplicate;

import java.util.HashSet;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println ( solution.containsDuplicate ( nums1 ) ); // Expected output: true

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println ( solution.containsDuplicate ( nums2 ) ); // Expected output: false

        // Test case 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println ( solution.containsDuplicate ( nums3 ) ); // Expected output: true
    }

    public boolean containsDuplicate ( int[] nums ) {
        HashSet<Integer> set = new HashSet<> ( );

        for (int num : nums) {
            if ( !set.add ( num ) ) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
    }
}
