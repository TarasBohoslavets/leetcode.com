package Problem_List.Q230_Kth_Smallest_Element_in_a_BST;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//
//        while (current != null || !stack.isEmpty()) {
//            // Спускаємось вліво
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//
//            // Візит вузла
//            current = stack.pop();
//            k--;
//            if (k == 0) {
//                return current.val;
//            }
//
//            // Переходимо до правого піддерева
//            current = current.right;
//        }
//
//        return -1; // На випадок, якщо не знайдено (завжди знайдеться, якщо вхідні дані правильні)
//   }

    private int ans; // Поле для збереження результату

    private void dfs(TreeNode root, int[] k) {
        if (root == null) {
            return; // Базовий випадок
        }
        dfs(root.left, k); // Обходимо ліве піддерево
        if (--k[0] == 0) { // Зменшуємо лічильник k, перевіряємо
            ans = root.val;
            return; // Ранній вихід
        }
        dfs(root.right, k); // Обходимо праве піддерево
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] kRef = {k}; // Використовуємо масив для передачі по посиланню
        dfs(root, kRef);
        return ans; // Повертаємо знайдене значення
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(root, 1)); // Виведе: 1
    }
}

