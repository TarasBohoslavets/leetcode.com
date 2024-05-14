package Problem_List.Climbing_Stairs;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int n1 = 2;
        int result1 = solution.climbStairs ( n1 );
        System.out.println ( "Example 1:" );
        System.out.println ( "Output: " + result1 ); // Output should be 2

        // Example 2
        int n2 = 3;
        int result2 = solution.climbStairs ( n2 );
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Output: " + result2 ); // Output should be 3

        // Example 3
        int n3 = 4;
        int result3 = solution.climbStairs ( n3 );
        System.out.println ( "\nExample 3:" );
        System.out.println ( "Output: " + result3 ); // Output should be 5
    }

    public int climbStairs ( int n ) {
        if ( n <= 1 ) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

