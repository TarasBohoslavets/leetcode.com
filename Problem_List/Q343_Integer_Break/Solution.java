package Problem_List.Q343_Integer_Break;

//class Solution {
//    public int integerBreak(int n) {
//        if (n == 2) return 1;
//        if (n == 3) return 2;
//
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
//            }
//        }
//        return dp[n];
//    }
//}

class Solution {
    public int integerBreak(int n) {
        // Якщо n == 2, єдине можливе розбиття: 1 + 1 = 1 * 1 = 1
        if (n == 2) return 1;
        // Якщо n == 3, найкраще розбиття: 2 + 1 = 2 * 1 = 2
        if (n == 3) return 2;

        // Основний випадок: максимізуємо добуток через 3
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3); // Якщо n кратне 3, просто множимо всі 3
        }
        if (n % 3 == 1) {
            return (int) Math.pow(3, (n / 3) - 1) * 4; // Якщо залишок 1, перетворюємо 3+1 на 4
        }
        return (int) Math.pow(3, n / 3) * 2; // Якщо залишок 2, просто множимо його
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1: n = 2
        int n1 = 2;
        System.out.println("Input: " + n1);
        System.out.println("Output: " + solution.integerBreak(n1)); // Очікуваний результат: 1

        // Приклад 2: n = 10
        int n2 = 10;
        System.out.println("Input: " + n2);
        System.out.println("Output: " + solution.integerBreak(n2)); // Очікуваний результат: 36
    }
}

