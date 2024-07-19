package Problem_List.Ransom_Note_383;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        System.out.println ( solution.canConstruct ( "a", "b" ) ); // false
        System.out.println ( solution.canConstruct ( "aa", "ab" ) ); // false
        System.out.println ( solution.canConstruct ( "aa", "aab" ) ); // true
    }

    public boolean canConstruct ( String ransomNote, String magazine ) {
        // Create a map to count the frequency of characters in the magazine
        Map<Character, Integer> magazineCount = new HashMap<> ( );

        // Fill the map with the counts of each character in the magazine
        for (char c : magazine.toCharArray ( )) {
            magazineCount.put ( c, magazineCount.getOrDefault ( c, 0 ) + 1 );
        }

        // Check each character in the ransomNote
        for (char c : ransomNote.toCharArray ( )) {
            if ( magazineCount.getOrDefault ( c, 0 ) <= 0 ) {
                return false; // If the character is not present or used up
            }
            magazineCount.put ( c, magazineCount.get ( c ) - 1 ); // Use one instance of the character
        }

        return true; // All characters in ransomNote can be constructed from magazine
    }
}

