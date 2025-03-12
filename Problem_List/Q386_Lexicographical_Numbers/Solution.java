package Problem_List.Q386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Метод повертає список чисел від 1 до n у лексикографічному порядку.
     *
     * @param n Верхня межа чисел.
     * @return Список чисел у лексикографічному порядку.
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        // Починаємо обхід з кожної цифри від 1 до 9 (оскільки 0 не є допустимим початковим числом)
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result); // Викликаємо DFS для побудови чисел
        }

        return result;
    }

    /**
     * Метод DFS для побудови чисел у лексикографічному порядку.
     *
     * @param num Поточне число, з якого починається рекурсія.
     * @param n   Верхня межа, щоб не виходити за межі.
     * @param result Список, у який додаємо результати.
     */
    private void dfs(int num, int n, List<Integer> result) {
        if (num > n) return; // Якщо число перевищує n, припиняємо рекурсію

        result.add(num); // Додаємо поточне число в список

        // Додаємо наступні числа, розширюючи поточне число на один розряд (тобто додаючи 0-9)
        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i; // Формуємо наступне число (наприклад, 1 → 10, 11, 12 і т. д.)
            if (next > n) return; // Якщо нове число більше за n, зупиняємо цикл
            dfs(next, n, result); // Рекурсивно обходимо наступний рівень
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lexicalOrder(13)); // Очікуваний результат: [1,10,11,12,13,2,3,4,5,6,7,8,9]
        System.out.println(solution.lexicalOrder(2));  // Очікуваний результат: [1,2]
    }
}


