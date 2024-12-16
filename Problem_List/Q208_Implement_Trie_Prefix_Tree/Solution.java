package Problem_List.Q208_Implement_Trie_Prefix_Tree;
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {

    // Внутрішній клас для вузлів Trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Містить 26 місць для символів англійського алфавіту
        boolean isEndOfWord; // Позначає, чи закінчується тут слово
    }

    private final TrieNode root;

    // Конструктор для ініціалізації Trie
    public Trie() {
        root = new TrieNode();
    }

    // Метод для вставки слова у Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Розрахунок індексу символу
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Додавання нового вузла, якщо його немає
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Позначаємо кінець слова
    }

    // Метод для перевірки наявності слова у Trie
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord; // Слово знайдено, якщо вузол існує і це кінець слова
    }

    // Метод для перевірки наявності префікса у Trie
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null; // Повертаємо true, якщо вузол для префікса існує
    }

    // Допоміжний метод для пошуку вузла за словом або префіксом
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a'; // Розрахунок індексу символу
            if (node.children[index] == null) {
                return null; // Якщо вузол не знайдений
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}
