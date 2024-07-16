package Problem_List.Intersection_of_Two_Arrays_II_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main ( String[] args ) {
        // Example 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect ( nums1, nums2 );
        for (int num : result) {
            System.out.print ( num + " " );
        }
        System.out.println ( ); // Output: 2 2

        // Example 2
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        result = intersect ( nums3, nums4 );
        for (int num : result) {
            System.out.print ( num + " " );
        }
        System.out.println ( ); // Output: 4 9 or 9 4
    }

    public static int[] intersect ( int[] nums1, int[] nums2 ) {
        Map<Integer, Integer> countMap = new HashMap<> ( );
        for (int num : nums1) {
            countMap.put ( num, countMap.getOrDefault ( num, 0 ) + 1 );
        }
        List<Integer> result = new ArrayList<> ( );
        for (int num : nums2) {
            if ( countMap.containsKey ( num ) && countMap.get ( num ) > 0 ) {
                result.add ( num );
                countMap.put ( num, countMap.get ( num ) - 1 );
            }
        }
        int[] intersection = new int[result.size ( )];
        for (int i = 0; i < result.size ( ); i++) {
            intersection[i] = result.get ( i );
        }
        return intersection;
    }
}

