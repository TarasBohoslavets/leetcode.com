package Problem_List.Q290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        System.out.println ( solution.wordPattern ( "abba", "dog cat cat dog" ) ); // Output: true
        System.out.println ( solution.wordPattern ( "abba", "dog cat cat fish" ) ); // Output: false
        System.out.println ( solution.wordPattern ( "aaaa", "dog cat cat dog" ) ); // Output: false
    }

    public boolean wordPattern ( String pattern, String s ) {
        String[] words = s.split ( " " );
        if ( pattern.length ( ) != words.length ) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<> ( );
        Map<String, Character> wordToChar = new HashMap<> ( );

        for (int i = 0; i < pattern.length ( ); i++) {
            char c = pattern.charAt ( i );
            String word = words[i];

            if ( charToWord.containsKey ( c ) ) {
                if ( !charToWord.get ( c ).equals ( word ) ) {
                    return false;
                }
            } else {
                charToWord.put ( c, word );
            }

            if ( wordToChar.containsKey ( word ) ) {
                if ( wordToChar.get ( word ) != c ) {
                    return false;
                }
            } else {
                wordToChar.put ( word, c );
            }
        }

        return true;
    }
}
