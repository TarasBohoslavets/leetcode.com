package Problem_List.Q397_Integer_Replacement;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    // Використовуємо Map для збереження вже обчислених значень (мемоізація)
    private Map<Long, Integer> memo = new HashMap<>();

    // Основний метод, який викликає рекурсивну функцію
    public int integerReplacement(int n) {
        return helper((long) n);
    }

    // Рекурсивний метод для знаходження мінімальної кількості операцій
    private int helper(long n) {
        if (n == 1) return 0; // Якщо n == 1, ми досягли мети
        if (memo.containsKey(n)) return memo.get(n); // Якщо вже обчислено, повертаємо збережене значення

        int steps;
        if (n % 2 == 0) {
            // Якщо число парне, просто ділимо його на 2
            steps = 1 + helper(n / 2);
        } else {
            // Якщо число непарне, пробуємо два варіанти: n + 1 або n - 1
            // Вибираємо мінімальну кількість кроків з обох варіантів
            steps = 1 + Math.min(helper(n + 1), helper(n - 1));
        }

        // Зберігаємо результат у мапі, щоб уникнути повторних обчислень
        memo.put(n, steps);
        return steps;
    }

    public static void main(String[] args) {
        IntegerReplacement solution = new IntegerReplacement();
        System.out.println(solution.integerReplacement(8));  // Output: 3
        System.out.println(solution.integerReplacement(7));  // Output: 4
        System.out.println(solution.integerReplacement(4));  // Output: 2
    }
}