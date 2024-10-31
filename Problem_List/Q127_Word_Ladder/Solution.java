package Problem_List.Q127_Word_Ladder;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // Перетворюємо список слів у множину для швидкого пошуку
        if (!wordSet.contains(endWord)) {
            return 0; // Якщо endWord відсутнє у wordList, повертаємо 0
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1; // Початковий крок, що містить початкове слово

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps; // Якщо знайшли endWord, повертаємо кількість кроків
                }

                // Перебір всіх можливих перетворень одного символу
                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Уникнення повторних відвідувань
                        }
                    }
                    wordChars[j] = originalChar; // Відновлюємо початковий символ
                }
            }
            steps++; // Збільшуємо кількість кроків після завершення рівня
        }

        return 0; // Якщо не знайдено шляху до endWord
    }
}

