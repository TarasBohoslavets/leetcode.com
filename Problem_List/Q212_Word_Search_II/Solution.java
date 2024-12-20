package Problem_List.Q212_Word_Search_II;

//import java.util.*;
//
//public class Solution {
//
//    // Клас TrieNode для представлення вузла у Trie
//    class TrieNode {
//        TrieNode[] children = new TrieNode[26];
//        String word; // Зберігає слово, якщо вузол є кінцем слова
//    }
//
//    // Додавання слова до Trie
//    public void addWord(TrieNode root, String word) {
//        TrieNode current = root;
//        for (char c : word.toCharArray()) {
//            if (current.children[c - 'a'] == null) {
//                current.children[c - 'a'] = new TrieNode();
//            }
//            current = current.children[c - 'a'];
//        }
//        current.word = word; // Позначає вузол як кінець слова
//    }
//
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> result = new ArrayList<>();
//        TrieNode root = new TrieNode();
//
//        // Додаємо всі слова до Trie
//        for (String word : words) {
//            addWord(root, word);
//        }
//
//        // Виконуємо пошук для кожної комірки на дошці
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                dfs(board, i, j, root, result);
//            }
//        }
//
//        return result;
//    }
//
//    // Рекурсивний DFS для пошуку слів
//    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
//        char c = board[i][j];
//        if (c == '#' || node.children[c - 'a'] == null) {
//            return; // Вихід, якщо комірка вже відвідана або символ не знаходиться у Trie
//        }
//
//        node = node.children[c - 'a'];
//        if (node.word != null) { // Якщо знайдено слово
//            result.add(node.word);
//            node.word = null; // Уникнення дублювання
//        }
//
//        board[i][j] = '#'; // Позначаємо комірку як відвідану
//        // Рухаємося в чотирьох напрямках
//        if (i > 0) dfs(board, i - 1, j, node, result);
//        if (j > 0) dfs(board, i, j - 1, node, result);
//        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
//        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
//        board[i][j] = c; // Відновлюємо комірку
//    }
//}

import java.util.ArrayList;
import java.util.List;

class Solution {

    // Визначаємо структуру Trie (префіксного дерева)
    class Trie {
        Trie[] next = new Trie[26]; // Масив дочірніх вузлів для літер 'a' до 'z'
        String word; // Слово, якщо вузол є кінцевою точкою слова
    }

    // Метод для створення Trie з набору слів
    public Trie buildTrie(String[] words) {
        Trie root = new Trie(); // Створюємо корінь Trie
        for (String str : words) { // Проходимо через кожне слово
            Trie node = root;
            for (char c : str.toCharArray()) { // Проходимо через кожну літеру слова
                int index = c - 'a'; // Обчислюємо індекс літери (0 для 'a', 25 для 'z')
                if (node.next[index] == null) {
                    node.next[index] = new Trie(); // Створюємо новий вузол, якщо ще не існує
                }
                node = node.next[index]; // Переходимо до наступного вузла
            }
            node.word = str; // Зберігаємо слово в кінцевому вузлі
        }
        return root; // Повертаємо корінь Trie
    }

    // Основний метод для знаходження слів на дошці
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words); // Створюємо Trie з переданого списку слів
        List<String> ans = new ArrayList<>(); // Список для збереження знайдених слів
        for (int x = 0; x < board.length; x++) { // Проходимо через кожну клітинку дошки
            for (int y = 0; y < board[0].length; y++) {
                helper(board, x, y, root, ans); // Запускаємо пошук слів із кожної клітинки
            }
        }
        return ans; // Повертаємо список знайдених слів
    }

    // Допоміжний метод для виконання пошуку
    public void helper(char[][] board, int x, int y, Trie node, List<String> ans) {
        char c = board[x][y]; // Поточний символ на дошці
        if (c == '#' || node.next[c - 'a'] == null) return; // Якщо комірка вже відвідана або символа немає в Trie

        node = node.next[c - 'a']; // Переходимо до наступного вузла Trie

        if (node.word != null) { // Якщо знайдено слово
            ans.add(node.word); // Додаємо слово до результатів
            node.word = null; // Видаляємо слово з Trie, щоб уникнути дублювання
        }

        board[x][y] = '#'; // Позначаємо клітинку як відвідану

        // Рекурсивно досліджуємо сусідні клітинки
        if (x > 0) helper(board, x - 1, y, node, ans); // Вгору
        if (y > 0) helper(board, x, y - 1, node, ans); // Вліво
        if (x < board.length - 1) helper(board, x + 1, y, node, ans); // Вниз
        if (y < board[0].length - 1) helper(board, x, y + 1, node, ans); // Вправо

        board[x][y] = c; // Відновлюємо клітинку після завершення пошуку
    }
}

