package Problem_List.Ugly_Number_263;

public class Solution {
    public static void main ( String[] args ) {
        Solution sol = new Solution ( );
        System.out.println ( sol.isUgly ( 6 ) );  // Output: true
        System.out.println ( sol.isUgly ( 1 ) );  // Output: true
        System.out.println ( sol.isUgly ( 14 ) ); // Output: false
        System.out.println ( sol.isUgly ( -6 ) ); // Output: false
        System.out.println ( sol.isUgly ( 0 ) );  // Output: false
    }

    public boolean isUgly ( int n ) {
        if ( n <= 0 ) {
            return false;
        }
        if ( n == 1 ) {
            return true;
        }

        // Continuously divide n by 2, 3, and 5
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        // If n becomes 1, it means it had no other prime factors
        return n == 1;
    }
}

