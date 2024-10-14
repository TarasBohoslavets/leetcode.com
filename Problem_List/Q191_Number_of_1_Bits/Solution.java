package Problem_List.Q191_Number_of_1_Bits;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        int test1 = 11; // Binary: 1011
        int test2 = 128; // Binary: 10000000
        int test3 = 2147483645; // Binary: 1111111111111111111111111111101

        System.out.println ( solution.hammingWeight ( test1 ) ); // Output: 3
        System.out.println ( solution.hammingWeight ( test2 ) ); // Output: 1
        System.out.println ( solution.hammingWeight ( test3 ) ); // Output: 30
    }

    // Function to count the number of set bits (1 bits) in the binary representation of a number
    public int hammingWeight ( int n ) {
        int count = 0;

        // Iterate until n becomes 0
        while (n != 0) {
            // Increment count if the LSB is 1
            count += (n & 1);
            // Right shift n by 1 bit to process the next bit
            n >>>= 1; // Use unsigned right shift operator
        }

        return count;
    }
}

