package Problem_List.Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;


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
        // Використовуємо властивості BST:
        // Якщо обидва значення менші за значення кореня, продовжуємо пошук в лівому піддереві
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // Якщо обидва значення більші за значення кореня, продовжуємо пошук в правому піддереві
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Якщо значення розділилися (одне менше, інше більше або одне з них дорівнює root.val),
        // поточний вузол є LCA
        return root;
    }
}
