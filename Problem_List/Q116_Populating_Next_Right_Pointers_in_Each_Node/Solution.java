package Problem_List.Q116_Populating_Next_Right_Pointers_in_Each_Node;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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

        // Якщо лівий нащадок існує, потрібно заповнити вказівники `next`
        if (root.left != null) {
            root.left.next = root.right; // Лівий вузол вказує на правий

            // Якщо існує вузол наступного рівня, з'єднуємо правий з сусіднім лівим
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        // Рекурсивно обробляємо ліве та праве піддерево
        connect(root.left);
        connect(root.right);

        return root; // Повертаємо корінь після обробки
    }
}

