package Problem_List.Path_Sum;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode ( int val ) {
        this.val = val;
    }

    TreeNode ( int val, TreeNode left, TreeNode right ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        TreeNode root1 = new TreeNode ( 5 );
        root1.left = new TreeNode ( 4 );
        root1.right = new TreeNode ( 8 );
        root1.left.left = new TreeNode ( 11 );
        root1.left.left.left = new TreeNode ( 7 );
        root1.left.left.right = new TreeNode ( 2 );
        root1.right.left = new TreeNode ( 13 );
        root1.right.right = new TreeNode ( 4 );
        root1.right.right.right = new TreeNode ( 1 );
        System.out.println ( solution.hasPathSum ( root1, 22 ) ); // Output: true

        // Example 2
        TreeNode root2 = new TreeNode ( 1 );
        root2.left = new TreeNode ( 2 );
        root2.right = new TreeNode ( 3 );
        System.out.println ( solution.hasPathSum ( root2, 5 ) ); // Output: false

        // Example 3
        TreeNode root3 = null;
        System.out.println ( solution.hasPathSum ( root3, 0 ) ); // Output: false
    }

    public boolean hasPathSum ( TreeNode root, int targetSum ) {
        if ( root == null ) {
            return false;
        }

        // If we're at a leaf node, check if the current value equals the target sum
        if ( root.left == null && root.right == null ) {
            return root.val == targetSum;
        }

        // Recursively check the left and right subtrees
        int newTargetSum = targetSum - root.val;
        return hasPathSum ( root.left, newTargetSum ) || hasPathSum ( root.right, newTargetSum );
    }
}

