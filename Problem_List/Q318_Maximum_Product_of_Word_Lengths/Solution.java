package Problem_List.Q318_Maximum_Product_of_Word_Lengths;

import java.util.*;

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n]; // Маски бітів для кожного слова
        int[] lengths = new int[n]; // Довжини кожного слова
        int maxProduct = 0; // Максимальний добуток довжин слів

        // Створюємо побітові маски для кожного слова
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << (c - 'a')); // Встановлюємо відповідний біт для кожної літери
            }
            masks[i] = mask; // Зберігаємо маску слова
            lengths[i] = words[i].length(); // Зберігаємо довжину слова
        }

        // Перебираємо всі можливі пари слів
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) { // Якщо слова не мають спільних літер
                    maxProduct = Math.max(maxProduct, lengths[i] * lengths[j]); // Оновлюємо максимальний добуток
                }
            }
        }

        return maxProduct; // Повертаємо результат
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})); // 16
        System.out.println(solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})); // 4
        System.out.println(solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})); // 0
    }
}

