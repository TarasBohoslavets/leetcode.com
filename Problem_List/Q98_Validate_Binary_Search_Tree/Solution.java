package Problem_List.Q98_Validate_Binary_Search_Tree;

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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // Базовий випадок: досягли кінця дерева
        if (node == null) {
            return true;
        }

        // Якщо поточне значення вузла не входить в дозволений діапазон
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        // Рекурсивно перевіряємо ліве піддерево (оновлюємо верхню межу)
        // і праве піддерево (оновлюємо нижню межу)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root1)); // Виведе true

        // Приклад 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        System.out.println(solution.isValidBST(root2)); // Виведе false
    }
}
