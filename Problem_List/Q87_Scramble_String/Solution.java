package Problem_List.Q87_Scramble_String;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Кеш для зберігання результатів
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Якщо строки однакові, вони автоматично є "перемішаними"
        if (s1.equals(s2)) {
            return true;
        }

        // Створюємо унікальний ключ для поточної пари строк
        String key = s1 + "," + s2;
        // Перевіряємо, чи вже обчислювали для цієї пари
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Перевіряємо, чи строки мають однаковий набір символів
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();
        // Рекурсивно перевіряємо всі можливі варіанти розбиття строк
        for (int i = 1; i < n; i++) {
            // Варіант 1: без перестановки частин
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Варіант 2: з перестановкою частин
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        // Якщо жоден варіант не підходить, зберігаємо false у кеш і повертаємо результат
        memo.put(key, false);
        return false;
    }
}
