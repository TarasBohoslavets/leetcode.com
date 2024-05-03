package Problem_List.Longest_Common_Prefix;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test 1
        String[] strs1 = {"flower", "flow", "flight"};
        String result1 = solution.longestCommonPrefix ( strs1 );
        System.out.println ( "Expected: \"fl\", Actual: \"" + result1 + "\"" );

        // Test 2
        String[] strs2 = {"dog", "racecar", "car"};
        String result2 = solution.longestCommonPrefix ( strs2 );
        System.out.println ( "Expected: \"\", Actual: \"" + result2 + "\"" );
    }

    public String longestCommonPrefix ( String[] strs ) {
        if ( strs == null || strs.length == 0 ) {
            return "";
        }
        for (int i = 0; i < strs[0].length ( ); i++) {
            char c = strs[0].charAt ( i );
            for (int j = 1; j < strs.length; j++) {
                if ( i == strs[j].length ( ) || strs[j].charAt ( i ) != c )
                    return strs[0].substring ( 0, i );
            }
        }
        return strs[0];
    }

}
