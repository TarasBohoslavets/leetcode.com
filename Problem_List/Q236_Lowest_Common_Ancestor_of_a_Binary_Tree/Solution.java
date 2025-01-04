package Problem_List.Q236_Lowest_Common_Ancestor_of_a_Binary_Tree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Якщо корінь порожній або дорівнює одному з шуканих вузлів
        if (root == null || root == p || root == q) {
            return root;
        }

        // Рекурсивний виклик для лівого та правого піддерев
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Якщо обидва піддерева повертають непорожній результат,
        // то root є найменшим спільним предком
        if (left != null && right != null) {
            return root;
        }

        // Інакше повертаємо непорожній результат
        return left != null ? left : right;
    }
}

