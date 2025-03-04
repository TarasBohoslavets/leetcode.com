package Problem_List.Q375_Guess_Number_Higher_or_Lower_II;

class Solution {
    public int getMoneyAmount(int n) {
        // Створюємо DP-таблицю розміром (n+1) x (n+1)
        int[][] dp = new int[n + 1][n + 1];

        // Заповнюємо DP-таблицю для всіх можливих довжин діапазону
        for (int len = 2; len <= n; len++) {  // Довжина діапазону
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE; // Ініціалізуємо максимальним значенням

                // Перебираємо всі можливі варіанти вибору `k`
                for (int k = start; k <= end; k++) {
                    // Розраховуємо витрати, якщо ми виберемо `k`
                    int cost = k + Math.max(
                            (k - 1 >= start ? dp[start][k - 1] : 0), // Ліва частина [start, k-1]
                            (k + 1 <= end ? dp[k + 1][end] : 0) // Права частина [k+1, end]
                    );

                    // Оновлюємо мінімальну вартість
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return dp[1][n]; // Повертаємо мінімальну вартість для діапазону [1, n]
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 10;
        int result1 = solution.getMoneyAmount(n1);
        System.out.println("Вхід: " + n1 + " -> Мінімальна сума: " + result1); // Очікуваний результат: 16

        int n2 = 1;
        int result2 = solution.getMoneyAmount(n2);
        System.out.println("Вхід: " + n2 + " -> Мінімальна сума: " + result2); // Очікуваний результат: 0

        int n3 = 2;
        int result3 = solution.getMoneyAmount(n3);
        System.out.println("Вхід: " + n3 + " -> Мінімальна сума: " + result3); // Очікуваний результат: 1
    }
}

