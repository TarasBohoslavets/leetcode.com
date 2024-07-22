package Problem_List.Longest_Substring_Without_Repeating_Characters_3;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main ( String[] args ) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters ( );

        // Приклади для перевірки
        String s1 = "abcabcbb";
        System.out.println ( solution.lengthOfLongestSubstring ( s1 ) ); // Вихід: 3

        String s2 = "bbbbb";
        System.out.println ( solution.lengthOfLongestSubstring ( s2 ) ); // Вихід: 1

        String s3 = "pwwkew";
        System.out.println ( solution.lengthOfLongestSubstring ( s3 ) ); // Вихід: 3
    }

    public int lengthOfLongestSubstring ( String s ) {
        if ( s == null || s.length ( ) == 0 ) {
            return 0;
        }

        // Використовуємо HashMap для зберігання індексів символів
        HashMap<Character, Integer> map = new HashMap<> ( );
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length ( ); right++) {
            char currentChar = s.charAt ( right );

            // Якщо символ вже є у вікні, переміщуємо ліву межу вікна
            if ( map.containsKey ( currentChar ) ) {
                left = Math.max ( map.get ( currentChar ) + 1, left );
            }

            // Оновлюємо індекс символу в HashMap
            map.put ( currentChar, right );

            // Оновлюємо максимальну довжину
            maxLength = Math.max ( maxLength, right - left + 1 );
        }

        return maxLength;
    }
}
