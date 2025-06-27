package Problem_List.Q513_Find_Bottom_Left_Tree_Value;


import java.util.LinkedList;
import java.util.Queue;


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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeft = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();
            bottomLeft = queue.peek().val;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return bottomLeft;
    }
}
