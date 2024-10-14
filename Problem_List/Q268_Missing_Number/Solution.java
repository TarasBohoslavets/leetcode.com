package Problem_List.Q268_Missing_Number;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test cases
        System.out.println ( solution.missingNumber ( new int[]{3, 0, 1} ) ); // Output: 2
        System.out.println ( solution.missingNumber ( new int[]{0, 1} ) ); // Output: 2
        System.out.println ( solution.missingNumber ( new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1} ) ); // Output: 8
        System.out.println ( solution.missingNumber ( new int[]{9, 6, 4, 2, 3, 8, 7, 0, 1} ) ); // Output: 5
        System.out.println ( solution.missingNumber ( new int[]{9, 6, 4, 2, 3, 5, 8, 0, 1} ) ); // Output: 7
    }

    public int missingNumber ( int[] nums ) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

