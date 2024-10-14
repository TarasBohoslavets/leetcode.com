package Problem_List.Q13_Roman_to_Integer;

import java.util.HashMap;

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test Example 1
        String s1 = "III";
        System.out.println ( "Input: " + s1 );
        System.out.println ( "Output: " + solution.romanToInt ( s1 ) ); // Expected output: 3
        System.out.println ( );

        // Test Example 2
        String s2 = "LVIII";
        System.out.println ( "Input: " + s2 );
        System.out.println ( "Output: " + solution.romanToInt ( s2 ) ); // Expected output: 58
        System.out.println ( );

        // Test Example 3
        String s3 = "MCMXCIV";
        System.out.println ( "Input: " + s3 );
        System.out.println ( "Output: " + solution.romanToInt ( s3 ) ); // Expected output: 1994
        System.out.println ( );
    }

    public int romanToInt ( String s ) {
        // Create a HashMap to store the integer values of Roman numerals
        HashMap<Character, Integer> romanValues = new HashMap<> ( );
        romanValues.put ( 'I', 1 );
        romanValues.put ( 'V', 5 );
        romanValues.put ( 'X', 10 );
        romanValues.put ( 'L', 50 );
        romanValues.put ( 'C', 100 );
        romanValues.put ( 'D', 500 );
        romanValues.put ( 'M', 1000 );

        int result = 0;
        int n = s.length ( );

        // Iterate through the Roman numeral string
        for (int i = 0; i < n; i++) {
            int currentValue = romanValues.get ( s.charAt ( i ) );

            // Check if subtractive value
            if ( i < n - 1 && currentValue < romanValues.get ( s.charAt ( i + 1 ) ) ) {
                result += romanValues.get ( s.charAt ( i + 1 ) ) - currentValue;
                i++; // Skip the next character
            } else {
                result += currentValue;
            }
        }

        return result;
    }
}
