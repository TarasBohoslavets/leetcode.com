package Problem_List.Q211_Design_Add_and_Search_Words_Data_Structure;

// Клас TrieNode представляє вузол у префіксному дереві (Trie).
public class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Масив дочірніх вузлів для 26 літер англійського алфавіту.
    boolean endOfWord = false; // Прапорець, що вказує, чи є вузол кінцем слова.
}

// Основний клас для реалізації WordDictionary.
class WordDictionary {

    public TrieNode root; // Кореневий вузол префіксного дерева.

    // Конструктор ініціалізує об'єкт із пустим деревом.
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Додає слово в дерево.
     * @param word слово, яке додається.
     */
    public void addWord(String word) {
        TrieNode current = root; // Починаємо з кореневого вузла.
        for (char c : word.toCharArray()) { // Перебираємо всі символи в слові.
            if (current.children[c - 'a'] == null) { // Якщо для символу немає вузла:
                current.children[c - 'a'] = new TrieNode(); // Створюємо новий вузол.
            }
            current = current.children[c - 'a']; // Переходимо до наступного вузла.
        }
        current.endOfWord = true; // Встановлюємо прапорець кінця слова.
    }

    /**
     * Шукає слово в дереві, враховуючи можливі замінники '.'.
     * @param word слово для пошуку.
     * @return true, якщо слово знайдено, інакше false.
     */
    public boolean search(String word) {
        return dfs(word, 0, root); // Викликаємо пошук із використанням DFS.
    }

    /**
     * Рекурсивний метод для пошуку з урахуванням символу '.'.
     * @param word слово для пошуку.
     * @param j індекс поточного символу в слові.
     * @param root поточний вузол дерева.
     * @return true, якщо слово знайдено, інакше false.
     */
    public boolean dfs(String word, int j, TrieNode root) {
        TrieNode current = root; // Починаємо з поточного вузла.
        for (int i = j; i < word.length(); i++) { // Перебираємо символи від індексу j.
            char c = word.charAt(i); // Поточний символ.
            if (c == '.') { // Якщо символ — замінник '.'.
                // Перебираємо всіх дочірніх вузлів.
                for (TrieNode child : current.children) {
                    // Рекурсивно шукаємо наступні символи.
                    if (child != null && dfs(word, i + 1, child)) {
                        return true; // Якщо знайдено, повертаємо true.
                    }
                }
                return false; // Якщо жоден вузол не підійшов, повертаємо false.
            } else {
                // Якщо символ не '.', переходимо до відповідного дочірнього вузла.
                if (current.children[c - 'a'] == null) { // Якщо вузол відсутній:
                    return false; // Слово не знайдено.
                }
                current = current.children[c - 'a']; // Переходимо до наступного вузла.
            }
        }
        return current.endOfWord; // Повертаємо true, якщо дійшли до кінця слова.
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
}
