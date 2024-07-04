package Problem_List.Move_Zeroes_283;

import java.util.Arrays;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes ( nums1 );
        System.out.println ( Arrays.toString ( nums1 ) ); // Output: [1, 3, 12, 0, 0]

        int[] nums2 = {0};
        solution.moveZeroes ( nums2 );
        System.out.println ( Arrays.toString ( nums2 ) ); // Output: [0]
    }

    public void moveZeroes ( int[] nums ) {
        int nonZeroIndex = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] != 0 ) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        // Fill remaining positions with zeros
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

