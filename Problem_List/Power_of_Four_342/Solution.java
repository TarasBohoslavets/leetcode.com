package Problem_List.Power_of_Four_342;

public class Solution {
    public static void main ( String[] args ) {
        int n1 = 16;
        int n2 = 5;
        int n3 = 1;

        System.out.println ( isPowerOfFour ( n1 ) ); // true
        System.out.println ( isPowerOfFour ( n2 ) ); // false
        System.out.println ( isPowerOfFour ( n3 ) ); // true
    }

    public static boolean isPowerOfFour ( int n ) {
        if ( n <= 0 ) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}

