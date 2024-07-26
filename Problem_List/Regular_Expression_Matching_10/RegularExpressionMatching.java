package Problem_List.Regular_Expression_Matching_10;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // Create a DP table with dimensions (m+1) x (n+1)
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Initialize dp for patterns with '*' that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char patternChar = p.charAt(j - 1);
                char stringChar = s.charAt(i - 1);

                if (patternChar == stringChar || patternChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (patternChar == '*') {
                    dp[i][j] = dp[i][j - 2];  // '*' matches zero occurrence
                    if (p.charAt(j - 2) == stringChar || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();

        // Test cases
        System.out.println(rem.isMatch("aa", "a"));    // Output: false
        System.out.println(rem.isMatch("aa", "a*"));   // Output: true
        System.out.println(rem.isMatch("ab", ".*"));   // Output: true
        System.out.println(rem.isMatch("aab", "c*a*b")); // Output: true
    }
}

