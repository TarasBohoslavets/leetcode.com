package Problem_List.Q470_Implement_Rand10_Using_Rand7;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 *
 * @return a random integer in the range 1 to 7
 */

// Це базовий клас, який вже реалізовано в системі:
class SolBase {
    public int rand7() {
        // Повертає випадкове ціле число в діапазоні від 1 до 7 (включно).
        // Реалізацію ви не бачите — вона вже є в системі.

        return 0;
    }
}

class Solution extends SolBase {
    public int rand10() {
        while (true) {
            // Генеруємо рівномірне число від 1 до 49
            int num = (rand7() - 1) * 7 + rand7(); // значення в діапазоні [1, 49]

            // Використовуємо тільки перші 40 чисел, бо 40 % 10 == 0 (рівномірність)
            if (num <= 40) {
                return 1 + (num - 1) % 10; // Перетворюємо на [1, 10]
            }
            // Якщо num > 40, пропускаємо і пробуємо знову
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 0; i < 100; i++) {
            System.out.print(sol.rand10() + " ");
        }
    }
}


