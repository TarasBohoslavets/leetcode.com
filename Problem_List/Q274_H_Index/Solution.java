package Problem_List.Q274_H_Index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        // Сортуємо масив у порядку зростання
        Arrays.sort(citations);
        int n = citations.length;

        // Перевіряємо кожен елемент для h-index
        for (int i = 0; i < n; i++) {
            int h = n - i; // Кількість статей із >= citations[i] цитувань
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0; // Якщо h-index не знайдено
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("h-index для [3, 0, 6, 1, 5]: " + solution.hIndex(citations1)); // Очікується: 3

        // Приклад 2
        int[] citations2 = {1, 3, 1};
        System.out.println("h-index для [1, 3, 1]: " + solution.hIndex(citations2)); // Очікується: 1

        // Додатковий приклад 1
        int[] citations3 = {10, 8, 5, 4, 3};
        System.out.println("h-index для [10, 8, 5, 4, 3]: " + solution.hIndex(citations3)); // Очікується: 4

        // Додатковий приклад 2
        int[] citations4 = {25, 8, 5, 3, 3};
        System.out.println("h-index для [25, 8, 5, 3, 3]: " + solution.hIndex(citations4)); // Очікується: 3

        // Додатковий приклад 3
        int[] citations5 = {0, 0, 0, 0};
        System.out.println("h-index для [0, 0, 0, 0]: " + solution.hIndex(citations5)); // Очікується: 0
    }
}

