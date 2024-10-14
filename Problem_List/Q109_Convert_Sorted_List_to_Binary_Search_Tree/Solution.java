package Problem_List.Q109_Convert_Sorted_List_to_Binary_Search_Tree;

class Solution {
    // Внутрішній клас для вузла однозв'язного списку
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Внутрішній клас для вузла дерева
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Метод для перетворення відсортованого однозв'язного списку в дерево пошуку
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null; // Якщо список порожній, повертаємо null
        return buildTree(head, null);  // Викликаємо метод побудови дерева
    }

    // Метод для побудови дерева за допомогою двох вказівників
    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) return null; // Якщо список порожній, повертаємо null

        // Знаходимо середній елемент списку
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Створюємо корінь дерева з середнього елемента
        TreeNode root = new TreeNode(slow.val);

        // Рекурсивно будуємо ліве і праве піддерево
        root.left = buildTree(head, slow);  // Ліва частина списку
        root.right = buildTree(slow.next, tail);  // Права частина списку

        return root;  // Повертаємо корінь дерева
    }
}

