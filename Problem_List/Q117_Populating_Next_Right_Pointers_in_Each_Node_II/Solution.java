package Problem_List.Q117_Populating_Next_Right_Pointers_in_Each_Node_II;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null; // Якщо дерева немає, повертаємо null
        }

        Node current = root; // поточний вузол
        Node dummy = new Node(0); // допоміжний вузол для з'єднання рівнів
        Node prev = dummy; // вказує на попередній оброблений вузол

        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left; // з'єднуємо попередній з лівим
                    prev = prev.next;
                }
                if (current.right != null) {
                    prev.next = current.right; // з'єднуємо попередній з правим
                    prev = prev.next;
                }
                current = current.next; // переходимо до наступного вузла на поточному рівні
            }
            current = dummy.next; // переходимо на наступний рівень
            dummy.next = null; // скидаємо допоміжний вузол
            prev = dummy; // оновлюємо prev для наступного рівня
        }

        return root;
    }
}

