package Problem_List.Power_of_Three_326;

public class Solution {
    public static void main ( String[] args ) {
        Solution sol = new Solution ( );
        System.out.println ( sol.isPowerOfThree ( 27 ) ); // true
        System.out.println ( sol.isPowerOfThree ( 0 ) );  // false
        System.out.println ( sol.isPowerOfThree ( -1 ) ); // false
    }

    public boolean isPowerOfThree ( int n ) {
        if ( n <= 0 ) return false;
        int maxPowerOfThree = 1162261467; // 3^19, the largest power of 3 within the range of an integer
        return maxPowerOfThree % n == 0;
    }
}

