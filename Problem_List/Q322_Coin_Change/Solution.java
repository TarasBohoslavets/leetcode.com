package Problem_List.Q322_Coin_Change;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        // Масив для збереження мінімальної кількості монет для кожної суми від 0 до amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Заповнюємо значенням, яке явно більше за можливий мінімум
        dp[0] = 0; // Базовий випадок: для суми 0 потрібно 0 монет

        // Перебираємо всі можливі суми
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Якщо значення не змінилося, то неможливо скласти суму з даних монет
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Метод main для тестування
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(sol.coinChange(coins1, amount1)); // Очікуваний результат: 3 (5+5+1)

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(sol.coinChange(coins2, amount2)); // Очікуваний результат: -1 (неможливо)

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(sol.coinChange(coins3, amount3)); // Очікуваний результат: 0 (сума 0)

        int[] coins4 = {186, 419, 83, 408};
        int amount4 = 6249;
        System.out.println(sol.coinChange(coins4, amount4)); // Очікуваний результат: 20
    }
}
