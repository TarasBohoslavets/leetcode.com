package Problem_List.Q58_Length_of_Last_Word;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        String s1 = "Hello World";
        int length1 = solution.lengthOfLastWord ( s1 );
        System.out.println ( "Example 1:" );
        System.out.println ( "Output: " + length1 ); // Output should be 5

        // Example 2
        String s2 = "   fly me   to   the moon  ";
        int length2 = solution.lengthOfLastWord ( s2 );
        System.out.println ( "\nExample 2:" );
        System.out.println ( "Output: " + length2 ); // Output should be 4

        // Example 3
        String s3 = "luffy is still joyboy";
        int length3 = solution.lengthOfLastWord ( s3 );
        System.out.println ( "\nExample 3:" );
        System.out.println ( "Output: " + length3 ); // Output should be 6
    }

    public int lengthOfLastWord ( String s ) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim ( );

        // Initialize a variable to store the length of the last word
        int length = 0;

        // Iterate through the string from right to left
        for (int i = s.length ( ) - 1; i >= 0; i--) {
            // If a space character is encountered, break the loop
            if ( s.charAt ( i ) == ' ' ) {
                break;
            }
            // Increment the length of the last word
            length++;
        }

        return length;
    }
}

