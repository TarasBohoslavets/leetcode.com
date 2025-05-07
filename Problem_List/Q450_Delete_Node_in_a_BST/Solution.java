package Problem_List.Q450_Delete_Node_in_a_BST;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            // Шукаємо в лівому піддереві
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Шукаємо в правому піддереві
            root.right = deleteNode(root.right, key);
        } else {
            // Вузол знайдено
            if (root.left == null) return root.right; // Один або 0 нащадків
            else if (root.right == null) return root.left;

            // Вузол має двох дітей
            TreeNode minNode = findMin(root.right); // Знайти найменший у правому піддереві
            root.val = minNode.val; // Замінити значення
            root.right = deleteNode(root.right, minNode.val); // Видалити дублікат
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}

