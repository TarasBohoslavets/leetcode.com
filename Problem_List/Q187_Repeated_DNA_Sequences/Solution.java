package Problem_List.Q187_Repeated_DNA_Sequences;

import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Результат для збереження повторюваних послідовностей
        List<String> result = new ArrayList<>();
        // Хеш-сет для збереження унікальних 10-літерних підрядків
        Set<String> seen = new HashSet<>();
        // Хеш-сет для перевірки повторюваних послідовностей
        Set<String> repeated = new HashSet<>();

        // Перебираємо всі 10-літерні підрядки
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10); // Отримуємо підрядок довжиною 10
            // Якщо вже бачили підрядок, додаємо до повторюваних
            if (seen.contains(substring)) {
                repeated.add(substring);
            } else {
                seen.add(substring); // Інакше додаємо до унікальних
            }
        }

        // Додаємо всі повторювані послідовності до результату
        result.addAll(repeated);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.findRepeatedDnaSequences(s1)); // Очікується: ["AAAAACCCCC","CCCCCAAAAA"]

        // Приклад 2
        String s2 = "AAAAAAAAAAAAA";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.findRepeatedDnaSequences(s2)); // Очікується: ["AAAAAAAAAA"]
    }
}

