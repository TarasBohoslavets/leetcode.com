package Problem_List.Q313_Super_Ugly_Number;

import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];  // Масив dp для збереження суперпотворних чисел
        dp[0] = 1;  // Перше суперпотворне число - це 1

        int k = primes.length;
        int[] indexes = new int[k]; // Індекси для множення
        long[] factors = new long[k]; // Наступні потенційні значення

        // Ініціалізуємо фактори
        for (int j = 0; j < k; j++) {
            factors[j] = primes[j]; // Початкові значення – просто самі прості числа
        }

        for (int i = 1; i < n; i++) {
            // Знайдемо мінімальне число серед factors[]
            long minUgly = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                minUgly = Math.min(minUgly, factors[j]);
            }
            dp[i] = minUgly;  // Записуємо його в dp

            // Оновлюємо фактори для наступного суперпотворного числа
            for (int j = 0; j < k; j++) {
                if (factors[j] == minUgly) {
                    indexes[j]++;  // Пересуваємо індекс
                    if (indexes[j] < n) {
                        factors[j] = dp[indexes[j]] * primes[j];  // Оновлюємо наступне число
                    }
                }
            }
        }

        return (int) dp[n - 1];  // Перетворюємо `long` в `int`
    }
}

