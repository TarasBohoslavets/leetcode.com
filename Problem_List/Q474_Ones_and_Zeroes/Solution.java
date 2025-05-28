package Problem_List.Q474_Ones_and_Zeroes;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            // Оновлюємо знизу вгору, щоб не перезаписати попередні значення
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)); // 4
        System.out.println(sol.findMaxForm(
                new String[]{"10", "0", "1"}, 1, 1)); // 2
    }
}
