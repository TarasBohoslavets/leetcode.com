package Problem_List.Palindrome_Number;
/*
Given an integer x, return true if x is a palindrome , and false otherwise.
  */
public class Palindrome_Number {
    public static class Solution {
        public static void main ( String[] args ) {
            Solution solution = new Solution ( );

            int x1 = 121;
            System.out.println ( "Input: x = " + x1 );
            System.out.println ( "Expected Output: true" );
            System.out.println ( "Actual Output: " + solution.isPalindrome ( x1 ) ); // Повинно вивести true
            System.out.println ( );

            int x2 = -121;
            System.out.println ( "Input: x = " + x2 );
            System.out.println ( "Expected Output: false" );
            System.out.println ( "Actual Output: " + solution.isPalindrome ( x2 ) ); // Повинно вивести false
            System.out.println ( );

            int x3 = 10;
            System.out.println ( "Input: x = " + x3 );
            System.out.println ( "Expected Output: false" );
            System.out.println ( "Actual Output: " + solution.isPalindrome ( x3 ) ); // Повинно вивести false
        }

        public boolean isPalindrome ( int x ) {
            // Convert the integer to a string
            String str = String.valueOf ( x );
            // Use two pointers to check if the string is a palindrome
            int left = 0;
            int right = str.length ( ) - 1;
            while (left < right) {
                // If characters at current positions don't match, it's not a palindrome
                if ( str.charAt ( left ) != str.charAt ( right ) ) {
                    return false;
                }
                left++;
                right--;
            }
            // If the loop completes, the string is a palindrome
            return true;
        }
    }
}