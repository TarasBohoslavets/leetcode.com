package Problem_List.Q202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test cases
        System.out.println ( solution.isHappy ( 19 ) ); // Output: true
        System.out.println ( solution.isHappy ( 2 ) );  // Output: false
    }

    public boolean isHappy ( int n ) {
        Set<Integer> seenNumbers = new HashSet<> ( );

        while (n != 1 && !seenNumbers.contains ( n )) {
            seenNumbers.add ( n );
            n = getNext ( n );
        }

        return n == 1;
    }

    private int getNext ( int n ) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }
}
