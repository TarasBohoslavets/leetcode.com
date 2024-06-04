package Problem_List.Majority_Element_169;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test cases
        int[] nums1 = {3, 2, 3};
        System.out.println ( "Input: [3, 2, 3] -> Output: " + solution.majorityElement ( nums1 ) + " (Expected: 3)" );

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println ( "Input: [2, 2, 1, 1, 1, 2, 2] -> Output: " + solution.majorityElement ( nums2 ) + " (Expected: 2)" );

        // Additional test cases
        int[] nums3 = {1};
        System.out.println ( "Input: [1] -> Output: " + solution.majorityElement ( nums3 ) + " (Expected: 1)" );

        int[] nums4 = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3};
        System.out.println ( "Input: [1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3] -> Output: " + solution.majorityElement ( nums4 ) + " (Expected: 3)" );
    }

    public int majorityElement ( int[] nums ) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if ( count == 0 ) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

