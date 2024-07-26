package Problem_List.String_to_Integer_atoi_8;

public class Solution {
    // Main method for testing
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test cases
        System.out.println ( solution.myAtoi ( "42" ) );         // Output: 42
        System.out.println ( solution.myAtoi ( " -042" ) );     // Output: -42
        System.out.println ( solution.myAtoi ( "1337c0d3" ) );  // Output: 1337
        System.out.println ( solution.myAtoi ( "0-1" ) );       // Output: 0
        System.out.println ( solution.myAtoi ( "words and 987" ) ); // Output: 0

        // Edge cases
        System.out.println ( solution.myAtoi ( "" ) );          // Output: 0
        System.out.println ( solution.myAtoi ( "   " ) );       // Output: 0
        System.out.println ( solution.myAtoi ( "+2147483648" ) ); // Output: 2147483647 (overflow)
        System.out.println ( solution.myAtoi ( "-2147483649" ) ); // Output: -2147483648 (underflow)
    }

    public int myAtoi ( String s ) {
        // Constants for 32-bit signed integer limits
        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;

        // Edge case: empty or null string
        if ( s == null || s.length ( ) == 0 ) {
            return 0;
        }

        // Initialize variables
        int i = 0;
        int n = s.length ( );
        int sign = 1;
        int result = 0;

        // Ignore leading whitespaces
        while (i < n && s.charAt ( i ) == ' ') {
            i++;
        }

        // Check if the string is empty after removing whitespaces
        if ( i >= n ) {
            return 0;
        }

        // Check for the sign
        if ( i < n && (s.charAt ( i ) == '+' || s.charAt ( i ) == '-') ) {
            if ( s.charAt ( i ) == '-' ) {
                sign = -1;
            }
            i++;
        }

        // Convert digits to integer
        while (i < n && Character.isDigit ( s.charAt ( i ) )) {
            int digit = s.charAt ( i ) - '0';

            // Check for overflow before updating the result
            if ( result > (INT_MAX - digit) / 10 ) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        // Return the final result with the applied sign
        return result * sign;
    }
}
