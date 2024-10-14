package Problem_List.Q190_Reverse_Bits;

/*
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
 */

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test cases
        int test1 = 0b00000010100101000001111010011100;
        int test2 = 0b11111111111111111111111111111101;


        System.out.println ( solution.reverseBits ( test1 ) ); // Output: 964176192
        System.out.println ( solution.reverseBits ( test2 ) ); // Output: 3221225471
    }

    // Function to reverse bits of a given 32-bit unsigned integer
    public int reverseBits ( int n ) {
        int result = 0;

        // Iterate over each bit in the 32-bit integer
        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit of n
            int bit = (n >> i) & 1;
            // Place the extracted bit in the correct position in the result
            result |= (bit << (31 - i));
        }

        return result;
    }
}
