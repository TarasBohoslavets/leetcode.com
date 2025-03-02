package Problem_List.Q372_Super_Pow;

class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int result = 1;

        // Проходимо по кожній цифрі масиву b
        for (int digit : b) {
            // Спочатку підносимо поточний result до степеня 10
            result = powMod(result, 10) * powMod(a, digit) % MOD;
        }

        return result;
    }

    // Функція для швидкого піднесення до степеня за модулем
    private int powMod(int a, int b) {
        int res = 1;
        a %= MOD;

        while (b > 0) {
            // Якщо останній біт у степені 1 (b непарне), множимо результат на a
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            // Підносимо a в квадрат
            a = a * a % MOD;
            // Ділимо степінь навпіл (зсуваємо біти вправо)
            b >>= 1;
        }

        return res;
    }

      public static void main(String[] args) {
        Solution solution = new Solution();

        int a1 = 2; int[] b1 = {3};
        System.out.println("Example 1: " + solution.superPow(a1, b1)); // Очікуваний результат: 8

        int a2 = 2; int[] b2 = {1,0};
        System.out.println("Example 2: " + solution.superPow(a2, b2)); // Очікуваний результат: 1024

        int a3 = 1; int[] b3 = {4,3,3,8,5,2};
        System.out.println("Example 3: " + solution.superPow(a3, b3)); // Очікуваний результат: 1
    }
}