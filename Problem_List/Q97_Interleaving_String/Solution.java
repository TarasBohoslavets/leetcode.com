package Problem_List.Q97_Interleaving_String;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();

        // Якщо довжина s1 та s2 разом не дорівнює довжині s3
        if (m + n != l) {
            return false;
        }

        // dp[i][j] означає, чи можна скласти перші i символів з s1 і перші j символів з s2, щоб отримати перші i + j символів з s3
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Ініціалізація dp: порожні рядки
        dp[0][0] = true;

        // Заповнюємо перший стовпець (s1 проти s3)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Заповнюємо перший рядок (s2 проти s3)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Основна логіка: заповнюємо dp на основі попередніх результатів
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Якщо символ s1[i-1] збігається з s3[i+j-1], перевіряємо чи можливо сформувати попередній підрядок
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                // Якщо символ s2[j-1] збігається з s3[i+j-1], перевіряємо чи можливо сформувати попередній підрядок
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        // Відповідь у правому нижньому куті матриці dp
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3)); // Виведе true

        // Приклад 2
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println(solution.isInterleave(s1, s2, s3)); // Виведе false

        // Приклад 3
        s1 = "";
        s2 = "";
        s3 = "";
        System.out.println(solution.isInterleave(s1, s2, s3)); // Виведе true
    }
}

