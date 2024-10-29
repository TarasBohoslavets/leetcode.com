package Problem_List.Q126_Word_Ladder_II;

import java.util.*;


class Solution {
    private List<List<String>> allPaths;  // Список шляхів від beginWord до endWord
    private Map<String, Set<String>> predecessorsMap;  // Карта для відстеження попередників кожного слова

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        allPaths = new ArrayList<>(); // Ініціалізація списку шляхів
        Set<String> wordSet = new HashSet<>(wordList); // Перетворення wordList у множину для швидкого доступу
        if (!wordSet.contains(endWord)) {
            return allPaths; // Якщо endWord немає у списку, повертаємо порожній список
        }
        wordSet.remove(beginWord); // Видалення beginWord з множини для запобігання циклам
        Map<String, Integer> distanceMap = new HashMap<>(); // Карта для зберігання відстаней
        distanceMap.put(beginWord, 0); // Відстань до самого себе
        predecessorsMap = new HashMap<>(); // Ініціалізація карти попередників
        Queue<String> queue = new ArrayDeque<>(); // Черга для BFS
        queue.offer(beginWord); // Додаємо beginWord до черги
        boolean isEndWordFound = false; // Прапор для перевірки, чи знайдено endWord
        int steps = 0; // Лічильник кроків для BFS

        // Основний цикл BFS
        while (!queue.isEmpty() && !isEndWordFound) {
            ++steps; // Збільшуємо кількість кроків
            for (int i = queue.size(); i > 0; --i) {
                String currentWord = queue.poll(); // Витягуємо поточне слово
                char[] currentChars = currentWord.toCharArray(); // Перетворюємо слово на масив символів

                // Генерація всіх можливих варіантів слова
                for (int j = 0; j < currentChars.length; ++j) {
                    char originalChar = currentChars[j]; // Зберігаємо оригінальний символ
                    for (char c = 'a'; c <= 'z'; ++c) { // Пробуємо всі можливі зміни
                        currentChars[j] = c; // Змінюємо символ
                        String newWord = new String(currentChars); // Створюємо нове слово

                        // Якщо нове слово вже має відстань, це означає, що воно вже відвідувалося на цьому рівні
                        if (distanceMap.getOrDefault(newWord, 0) == steps) {
                            predecessorsMap.get(newWord).add(currentWord); // Додаємо поточне слово до попередників
                        }
                        // Якщо нове слово не в множині, пропускаємо
                        if (!wordSet.contains(newWord)) {
                            continue;
                        }
                        // Оновлюємо карти для нових слів
                        predecessorsMap.computeIfAbsent(newWord, key -> new HashSet<>()).add(currentWord);
                        wordSet.remove(newWord); // Видаляємо нове слово з множини
                        queue.offer(newWord); // Додаємо нове слово до черги
                        distanceMap.put(newWord, steps); // Оновлюємо відстань до нового слова
                        if (endWord.equals(newWord)) {
                            isEndWordFound = true; // Знайдено endWord, зупиняємо пошук
                        }
                    }
                    currentChars[j] = originalChar; // Відновлюємо оригінальний символ
                }
            }
        }
        if (isEndWordFound) { // Якщо endWord знайдено
            Deque<String> path = new ArrayDeque<>(); // Стек для відстеження шляхів
            path.add(endWord); // Додаємо endWord до шляху
            backtrackPath(path, beginWord, endWord); // Викликаємо DFS для збору всіх шляхів
        }
        return allPaths; // Повертаємо список всіх знайдених шляхів
    }

    // Метод для відстеження шляху назад
    private void backtrackPath(Deque<String> path, String beginWord, String currentWord) {
        if (currentWord.equals(beginWord)) { // Якщо досягли початкового слова
            allPaths.add(new ArrayList<>(path)); // Додаємо знайдений шлях
            return;
        }
        // Рекурсивно проходимо всіх попередників поточного слова
        for (String predecessor : predecessorsMap.get(currentWord)) {
            path.addFirst(predecessor); // Додаємо попередника до шляху
            backtrackPath(path, beginWord, predecessor); // Продовжуємо відстеження
            path.removeFirst(); // Відкочуємо шлях
        }
    }
}
