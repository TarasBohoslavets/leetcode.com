package Problem_List.Contains_Duplicate_II_219;

import java.util.HashMap;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println ( solution.containsNearbyDuplicate ( nums1, k1 ) ); // Expected output: true

        // Test case 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println ( solution.containsNearbyDuplicate ( nums2, k2 ) ); // Expected output: true

        // Test case 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println ( solution.containsNearbyDuplicate ( nums3, k3 ) ); // Expected output: false
    }

    public boolean containsNearbyDuplicate ( int[] nums, int k ) {
        HashMap<Integer, Integer> map = new HashMap<> ( );

        for (int i = 0; i < nums.length; i++) {
            if ( map.containsKey ( nums[i] ) ) {
                int previousIndex = map.get ( nums[i] );
                if ( i - previousIndex <= k ) {
                    return true;
                }
            }
            map.put ( nums[i], i );
        }

        return false;
    }
}
