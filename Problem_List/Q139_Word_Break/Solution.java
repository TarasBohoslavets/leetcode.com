package Problem_List.Q139_Word_Break;

import java.util.*;

class Solution {


    public boolean wordBreak(String s, List<String> wordDict) {
        // Створюємо множину для зберігання слів зі словника
        Set<String> wordSet = new HashSet<>(wordDict);

        // Масив для відстеження можливості розділення строки
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Порожня строка завжди може бути розділена

        // Перебираємо кожну позицію у рядку
        for (int i = 1; i <= s.length(); i++) {
            // Перевіряємо всі можливі слова, що закінчуються в цій позиції
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Зупиняємося, якщо знайшли відповідне слово
                }
            }
        }

        // Повертаємо, чи можна розділити рядок на слова зі словника
        return dp[s.length()];
    }
}

