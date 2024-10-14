package Problem_List.Q345_Reverse_Vowels_of_a_String;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test cases
        String s1 = "hello";
        System.out.println ( "Input: \"hello\" -> Output: \"" + solution.reverseVowels ( s1 ) + "\" (Expected: \"holle\")" );

        String s2 = "leetcode";
        System.out.println ( "Input: \"leetcode\" -> Output: \"" + solution.reverseVowels ( s2 ) + "\" (Expected: \"leotcede\")" );

        // Additional test cases
        String s3 = "aA";
        System.out.println ( "Input: \"aA\" -> Output: \"" + solution.reverseVowels ( s3 ) + "\" (Expected: \"Aa\")" );

        String s4 = "";
        System.out.println ( "Input: \"\" -> Output: \"" + solution.reverseVowels ( s4 ) + "\" (Expected: \"\")" );

        String s5 = "abcde";
        System.out.println ( "Input: \"abcde\" -> Output: \"" + solution.reverseVowels ( s5 ) + "\" (Expected: \"ebcda\")" );
    }

    public String reverseVowels ( String s ) {
        Set<Character> vowels = new HashSet<> ( );
        vowels.add ( 'a' );
        vowels.add ( 'e' );
        vowels.add ( 'i' );
        vowels.add ( 'o' );
        vowels.add ( 'u' );
        vowels.add ( 'A' );
        vowels.add ( 'E' );
        vowels.add ( 'I' );
        vowels.add ( 'O' );
        vowels.add ( 'U' );

        char[] chars = s.toCharArray ( );
        int left = 0, right = chars.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains ( chars[left] )) {
                left++;
            }
            while (left < right && !vowels.contains ( chars[right] )) {
                right--;
            }
            if ( left < right ) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String ( chars );
    }
}

