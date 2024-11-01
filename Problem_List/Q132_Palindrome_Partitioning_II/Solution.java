package Problem_List.Q132_Palindrome_Partitioning_II;

class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        // Ініціалізація масиву isPalindrome для визначення паліндромів
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = (len <= 2) || isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // Якщо підрядок s[0...i] є паліндромом, розрізів не потрібно
            } else {
                dp[i] = i; // Максимальна кількість розрізів (кожна літера відокремлена)
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1]; // Мінімальна кількість розрізів для рядка s
    }
}
