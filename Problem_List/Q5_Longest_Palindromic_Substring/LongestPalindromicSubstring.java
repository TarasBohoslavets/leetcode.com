package Problem_List.Q5_Longest_Palindromic_Substring;

public class LongestPalindromicSubstring {
    public static void main ( String[] args ) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring ( );

        // Приклади для перевірки
        String s1 = "babad";
        System.out.println ( solution.longestPalindrome ( s1 ) ); // Вихід: "bab" або "aba"

        String s2 = "cbbd";
        System.out.println ( solution.longestPalindrome ( s2 ) ); // Вихід: "bb"
    }

    public String longestPalindrome ( String s ) {
        if ( s == null || s.length ( ) < 1 ) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length ( ); i++) {
            int len1 = expandAroundCenter ( s, i, i ); // для непарного паліндрома
            int len2 = expandAroundCenter ( s, i, i + 1 ); // для парного паліндрома
            int len = Math.max ( len1, len2 );
            if ( len > end - start ) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring ( start, end + 1 );
    }

    private int expandAroundCenter ( String s, int left, int right ) {
        int L = left, R = right;
        while (L >= 0 && R < s.length ( ) && s.charAt ( L ) == s.charAt ( R )) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

