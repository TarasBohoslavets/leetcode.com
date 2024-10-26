package Problem_List.Q129_Sum_Root_to_Leaf_Numbers;

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
    public int sumNumbers(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively sum the left and right subtrees
        return sumRootToLeaf(node.left, currentSum) + sumRootToLeaf(node.right, currentSum);
    }
}

