package Problem_List.Q472_Concatenated_Words;

import java.util.*;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) continue; // пропускаємо пусті слова, якщо такі є
            wordSet.remove(word); // щоб не використовувати саме слово при перевірці
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word); // додаємо слово назад для наступних ітерацій
        }

        return result;
    }

    // Метод перевіряє, чи можна скласти слово word з інших слів у wordSet
    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) return false;

        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true; // порожній префікс завжди можна скласти

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] = true означає, що слово можна скласти до позиції j
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> res = sol.findAllConcatenatedWordsInADict(words);
        System.out.println(res); // ["catsdogcats","dogcatsdog","ratcatdogcat"]
    }
}
