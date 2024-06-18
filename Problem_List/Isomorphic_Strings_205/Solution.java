package Problem_List.Isomorphic_Strings_205;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test case 1
        String s1 = "egg";
        String t1 = "add";
        System.out.println ( solution.isIsomorphic ( s1, t1 ) ); // Expected output: true

        // Test case 2
        String s2 = "foo";
        String t2 = "bar";
        System.out.println ( solution.isIsomorphic ( s2, t2 ) ); // Expected output: false

        // Test case 3
        String s3 = "paper";
        String t3 = "title";
        System.out.println ( solution.isIsomorphic ( s3, t3 ) ); // Expected output: true
    }

    public boolean isIsomorphic ( String s, String t ) {
        if ( s.length ( ) != t.length ( ) ) {
            return false;
        }

        Map<Character, Character> sToTMap = new HashMap<> ( );
        Map<Character, Character> tToSMap = new HashMap<> ( );

        for (int i = 0; i < s.length ( ); i++) {
            char sChar = s.charAt ( i );
            char tChar = t.charAt ( i );

            // Check if there is a mismatch in the mapping from s to t
            if ( sToTMap.containsKey ( sChar ) ) {
                if ( sToTMap.get ( sChar ) != tChar ) {
                    return false;
                }
            } else {
                sToTMap.put ( sChar, tChar );
            }

            // Check if there is a mismatch in the mapping from t to s
            if ( tToSMap.containsKey ( tChar ) ) {
                if ( tToSMap.get ( tChar ) != sChar ) {
                    return false;
                }
            } else {
                tToSMap.put ( tChar, sChar );
            }
        }

        return true;
    }
}

/*
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap();
        Map<Character, Character> map1 = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (map1.containsKey(t.charAt(i))) {
                if (map1.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
                map1.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
* */

