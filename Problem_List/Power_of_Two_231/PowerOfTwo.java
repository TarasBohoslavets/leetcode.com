package Problem_List.Power_of_Two_231;

public class PowerOfTwo {
    public static void main ( String[] args ) {
        PowerOfTwo solution = new PowerOfTwo ( );

        // Example 1
        int n1 = 1;
        System.out.println ( solution.isPowerOfTwo ( n1 ) ); // Output: true

        // Example 2
        int n2 = 16;
        System.out.println ( solution.isPowerOfTwo ( n2 ) ); // Output: true

        // Example 3
        int n3 = 3;
        System.out.println ( solution.isPowerOfTwo ( n3 ) ); // Output: false
    }

    public boolean isPowerOfTwo ( int n ) {
        // Check if n is positive and n & (n - 1) is zero
        return n > 0 && (n & (n - 1)) == 0;
    }
}
