package Problem_List.Q242_Valid_Anagram;

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        System.out.println ( solution.isAnagram ( "anagram", "nagaram" ) ); // true
        System.out.println ( solution.isAnagram ( "rat", "car" ) );         // false
    }

    //    public boolean isAnagram ( String s, String t ) {
//        if ( s.length ( ) != t.length ( ) ) {
//            return false;
//        }
//
//        Map<Character, Integer> countMap = new HashMap<> ( );
//
//        for (char c : s.toCharArray ( )) {
//            countMap.put ( c, countMap.getOrDefault ( c, 0 ) + 1 );
//        }
//
//        for (char c : t.toCharArray ( )) {
//            if ( !countMap.containsKey ( c ) ) {
//                return false;
//            }
//            countMap.put ( c, countMap.get ( c ) - 1 );
//            if ( countMap.get ( c ) == 0 ) {
//                countMap.remove ( c );
//            }
//        }
//
//        return countMap.isEmpty ( );
//    }
//    public boolean isAnagram ( String s, String t ) {
//        if ( s.length ( ) != t.length ( ) ) {
//            return false;
//        }
//        int[] table = new int[26];
//        for (int i = 0; i < s.length ( ); i++) {
//            table[s.charAt ( i ) - 'a']++;
//        }
//        for (int i = 0; i < t.length ( ); i++) {
//            table[t.charAt ( i ) - 'a']--;
//            if ( table[t.charAt ( i ) - 'a'] < 0 ) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isAnagram ( String s, String t ) {
        if ( s.length ( ) != t.length ( ) ) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length ( ); i++) {
            count[s.charAt ( i ) - 'a']++;
            count[t.charAt ( i ) - 'a']--;
        }
        for (int c : count) {
            if ( c != 0 ) {
                return false;
            }
        }
        return true;
    }
}
