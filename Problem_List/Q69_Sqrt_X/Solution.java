package Problem_List.Q69_Sqrt_X;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        int x1 = 4;
        int result1 = solution.mySqrt ( x1 );
        System.out.println ( "Example 1:" );
        System.out.println ( "Output: " + result1 ); // Output should be 2

        // Example 2
        int x2 = 8;
        int result2 = solution.mySqrt ( x2 );
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Output: " + result2 ); // Output should be 2
    }

    public int mySqrt ( int x ) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
