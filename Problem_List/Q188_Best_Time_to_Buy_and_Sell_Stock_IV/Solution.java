package Problem_List.Q188_Best_Time_to_Buy_and_Sell_Stock_IV;

class Solution {
    public int maxProfit(int k, int[] prices) {
        // Якщо масив цін порожній або днів менше за 1, то немає сенсу виконувати транзакції
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;

        // Якщо кількість транзакцій більша або дорівнює половині днів, то це еквівалентно
        // необмеженій кількості транзакцій (кожного разу купуємо і продаємо на максимум)
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // Динамічне програмування для обмеженої кількості транзакцій
        // dp[t][d] — максимальний прибуток при t транзакціях до d-го дня
        int[][] dp = new int[k + 1][n];

        // Для кожної кількості транзакцій
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0]; // Максимальна різниця для покупки
            for (int d = 1; d < n; d++) {
                // Максимальний прибуток: або залишаємося на попередньому дні, або продаємо сьогодні
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                // Оновлюємо maxDiff для наступного дня
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        // Відповідь — максимальний прибуток при k транзакціях до останнього дня
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int k1 = 2;
        int[] prices1 = {2, 4, 1};
        System.out.println("Example 1:");
        System.out.println("Input: k = " + k1 + ", prices = " + java.util.Arrays.toString(prices1));
        System.out.println("Output: " + solution.maxProfit(k1, prices1)); // Очікується: 2

        // Приклад 2
        int k2 = 2;
        int[] prices2 = {3, 2, 6, 5, 0, 3};
        System.out.println("Example 2:");
        System.out.println("Input: k = " + k2 + ", prices = " + java.util.Arrays.toString(prices2));
        System.out.println("Output: " + solution.maxProfit(k2, prices2)); // Очікується: 7

        // Приклад 3
        int k3 = 3;
        int[] prices3 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        System.out.println("Example 3:");
        System.out.println("Input: k = " + k3 + ", prices = " + java.util.Arrays.toString(prices3));
        System.out.println("Output: " + solution.maxProfit(k3, prices3)); // Очікується: 13
    }
}
