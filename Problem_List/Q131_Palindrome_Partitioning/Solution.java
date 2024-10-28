package Problem_List.Q131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // Рекурсивна функція backtrack для побудови всіх можливих розбиттів
    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // Якщо досягли кінця рядка, додаємо поточне розбиття в результат
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Проходимо від індексу start до кінця рядка
        for (int end = start; end < s.length(); end++) {
            // Перевіряємо, чи є підрядок від start до end паліндромом
            if (isPalindrome(s, start, end)) {
                // Додаємо паліндром у поточний список
                currentPartition.add(s.substring(start, end + 1));
                // Викликаємо backtrack для наступної частини рядка
                backtrack(s, end + 1, currentPartition, result);
                // Видаляємо останній елемент для перевірки інших варіантів розбиття
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Функція для перевірки, чи є підрядок паліндромом
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
