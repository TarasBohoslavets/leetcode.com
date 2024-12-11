package Problem_List.Q199_Binary_Tree_Right_Side_View;

import java.util.*;

class TreeNode {
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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Якщо дерево порожнє, повертаємо порожній список
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Додаємо кореневий вузол до черги

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Кількість вузлів на поточному рівні
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Забираємо вузол з черги

                // Якщо це останній вузол рівня, додаємо його до результату
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Додаємо дочірні вузли до черги
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result; // Повертаємо список видимих значень
    }

    // Приклади використання
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4))
        );
        System.out.println("Приклад 1: " + solution.rightSideView(root1)); // Виведе: [1, 3, 4]

        // Приклад 2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3)
        );
        System.out.println("Приклад 2: " + solution.rightSideView(root2)); // Виведе: [1, 3, 4]

        // Приклад 3
        TreeNode root3 = new TreeNode(1, null, new TreeNode(3));
        System.out.println("Приклад 3: " + solution.rightSideView(root3)); // Виведе: [1, 3]

        // Приклад 4
        TreeNode root4 = null;
        System.out.println("Приклад 4: " + solution.rightSideView(root4)); // Виведе: []
    }
}

