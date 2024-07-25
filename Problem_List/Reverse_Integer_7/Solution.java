package Problem_List.Reverse_Integer_7;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;

        System.out.println ( "Input: " + x1 + ", Output: " + solution.reverse ( x1 ) );
        System.out.println ( "Input: " + x2 + ", Output: " + solution.reverse ( x2 ) );
        System.out.println ( "Input: " + x3 + ", Output: " + solution.reverse ( x3 ) );
    }

    public int reverse ( int x ) {
        // Define the bounds of a 32-bit signed integer
        int INT_MAX = (int) Math.pow ( 2, 31 ) - 1;
        int INT_MIN = -(int) Math.pow ( 2, 31 );

        // Handle sign
        int sign = x < 0 ? -1 : 1;

        // Convert x to its absolute value for reversal
        long abs_x = Math.abs ( (long) x );

        // Reverse the digits
        long reversed_x = 0;
        while (abs_x != 0) {
            long digit = abs_x % 10;
            reversed_x = reversed_x * 10 + digit;
            abs_x /= 10;
        }

        // Check for overflow
        if ( reversed_x > INT_MAX || reversed_x < INT_MIN ) {
            return 0;
        }

        // Apply sign
        int result = (int) (sign * reversed_x);

        return result;
    }
}

