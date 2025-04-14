package Problem_List.Q421_Maximum_XOR_of_Two_Numbers_in_an_Array;

class Solution {

    // Вузол Trie (має два нащадки: для біта 0 і біта 1)
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // children[0] — для біта 0, children[1] — для біта 1
    }

    TrieNode root = new TrieNode(); // корінь Trie

    // Метод вставляє число у Trie
    private void insert(int num) {
        TrieNode node = root;
        // Перебираємо біти числа від старшого (31) до молодшого (0)
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1; // отримуємо i-й біт числа
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode(); // створюємо новий вузол, якщо відсутній
            }
            node = node.children[bit]; // переходимо до відповідного біта
        }
    }

    // Метод знаходить найкраще число в Trie для максимального XOR з поточним
    private int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = 1 - bit; // шукаємо протилежний біт (0 -> 1, 1 -> 0), бо XOR дає 1 тільки при різних бітах

            // Якщо такий біт є у Trie, він краще для максимального XOR
            if (node.children[oppositeBit] != null) {
                maxXor |= (1 << i); // додаємо 1 на відповідну позицію
                node = node.children[oppositeBit];
            } else {
                // Інакше беремо наявний біт
                node = node.children[bit];
            }
        }
        return maxXor;
    }

    // Основний метод — вставляємо всі числа і знаходимо максимальний XOR
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num); // будуємо Trie
        }

        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, findMaxXOR(num)); // для кожного шукаємо максимум
        }

        return maxResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {3, 10, 5, 25, 2, 8};
        System.out.println("Максимальний XOR (приклад 1): " + solution.findMaximumXOR(nums1));
        // Очікувано: 28 (5 ^ 25)

        int[] nums2 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        System.out.println("Максимальний XOR (приклад 2): " + solution.findMaximumXOR(nums2));
        // Очікувано: 127

        int[] nums3 = {0, 0};
        System.out.println("Максимальний XOR (приклад 3): " + solution.findMaximumXOR(nums3));
        // Очікувано: 0 (0 ^ 0)
    }
}
