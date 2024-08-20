package Problem_List.Q44_Wildcard_Matching;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1 = "aa";
        String p1 = "a";
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("Output: " + sol.isMatch(s1, p1));  // Очікуваний результат: false
        System.out.println();

        // Example 2
        String s2 = "aa";
        String p2 = "*";
        System.out.println("Example 2:");
        System.out.println("Input: s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("Output: " + sol.isMatch(s2, p2));  // Очікуваний результат: true
        System.out.println();

        // Example 3
        String s3 = "cb";
        String p3 = "?a";
        System.out.println("Example 3:");
        System.out.println("Input: s = \"" + s3 + "\", p = \"" + p3 + "\"");
        System.out.println("Output: " + sol.isMatch(s3, p3));  // Очікуваний результат: false
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // Динамічний масив для збереження проміжних результатів
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // Заповнення першого рядка, враховуючи випадки, коли шаблон починається з '*'
        for (int i = 1; i <= pLen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // Заповнення решти таблиці
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == sChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[sLen][pLen];
    }
}