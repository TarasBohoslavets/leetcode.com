package Problem_List.Q483_Smallest_Good_Base;

class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // Максимальна можлива довжина "всі одиниці" — log2(n+1)
        for (int m = (int)(Math.log(num + 1) / Math.log(2)); m >= 1; m--) {
            long left = 2, right = (long) Math.pow(num, 1.0 / m);

            while (left <= right) {
                long k = left + (right - left) / 2;
                long sum = 1, current = 1;

                // Обчислюємо геометричну суму 1 + k + k^2 + ... + k^m
                for (int i = 1; i <= m; i++) {
                    current *= k;
                    sum += current;

                    // Якщо переповнення — виходимо
                    if (sum > num) break;
                }

                if (sum == num) return String.valueOf(k);
                else if (sum < num) left = k + 1;
                else right = k - 1;
            }
        }

        // Якщо не знайдено, тоді найменша основа — n-1 (тобто 11 у цій основі)
        return String.valueOf(num - 1);
    }
}

