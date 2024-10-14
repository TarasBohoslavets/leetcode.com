package Problem_List.Q228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println ( solution.summaryRanges ( nums1 ) ); // Output: ["0->2", "4->5", "7"]

        // Example 2
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println ( solution.summaryRanges ( nums2 ) ); // Output: ["0", "2->4", "6", "8->9"]
    }

    public List<String> summaryRanges ( int[] nums ) {
        List<String> result = new ArrayList<> ( );
        if ( nums == null || nums.length == 0 ) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if ( nums[i] == end + 1 ) {
                end = nums[i];
            } else {
                if ( start == end ) {
                    result.add ( String.valueOf ( start ) );
                } else {
                    result.add ( start + "->" + end );
                }
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range
        if ( start == end ) {
            result.add ( String.valueOf ( start ) );
        } else {
            result.add ( start + "->" + end );
        }

        return result;
    }
}
