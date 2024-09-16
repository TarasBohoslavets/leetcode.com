package Problem_List.Q67_Add_Binary;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        String a1 = "11";
        String b1 = "1";
        String result1 = solution.addBinary ( a1, b1 );
        System.out.println ( "Example 1:" );
        System.out.println ( "Output: " + result1 ); // Output should be "100"

        // Example 2
        String a2 = "1010";
        String b2 = "1011";
        String result2 = solution.addBinary ( a2, b2 );
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Output: " + result2 ); // Output should be "10101"
    }

    public String addBinary ( String a, String b ) {
        StringBuilder result = new StringBuilder ( );
        int carry = 0;
        int i = a.length ( ) - 1;
        int j = b.length ( ) - 1;

        // Iterate from the least significant digit to the most significant digit
        while (i >= 0 || j >= 0 || carry > 0) {
            // Extract the current digits from both strings, or 0 if already reached the end
            int digitA = i >= 0 ? a.charAt ( i ) - '0' : 0;
            int digitB = j >= 0 ? b.charAt ( j ) - '0' : 0;

            // Calculate the sum of the current digits and the carry
            int sum = digitA + digitB + carry;

            // Update the carry if the sum exceeds 1
            carry = sum / 2;

            // Append the least significant digit of the sum to the result string
            result.append ( sum % 2 );

            // Move to the next digit towards the most significant digit
            i--;
            j--;
        }

        // Reverse the result string to get the correct order of digits
        return result.reverse ( ).toString ( );
    }
}
