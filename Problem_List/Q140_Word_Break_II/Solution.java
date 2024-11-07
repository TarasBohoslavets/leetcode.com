package Problem_List.Q140_Word_Break_II;

import java.util.*;

class Solution {
    // Карта для зберігання результатів обчислень для вже розглянутих підстрок
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Викликаємо допоміжний метод для пошуку всіх можливих розділень слова s
        return backtrack(s, new HashSet<>(wordDict));
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        // Якщо вже обробили цю підстроку раніше, повертаємо результат з кешу
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        // Базовий випадок: якщо рядок порожній, додаємо порожній рядок у результат
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        // Проходимо по кожній позиції рядка, щоб перевірити всі можливі розділення
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i); // Витягуємо слово від початку до i

            // Якщо слово є в словнику, обробляємо решту рядка рекурсивно
            if (wordSet.contains(word)) {
                // Знаходимо всі можливі речення для решти рядка
                List<String> subSentences = backtrack(s.substring(i), wordSet);

                // Додаємо поточне слово до кожного речення
                for (String subSentence : subSentences) {
                    if (subSentence.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + subSentence);
                    }
                }
            }
        }

        // Зберігаємо результат для поточної підстроки в кеші
        memo.put(s, result);
        return result;
    }
}
