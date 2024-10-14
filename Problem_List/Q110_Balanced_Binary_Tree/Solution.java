package Problem_List.Q110_Balanced_Binary_Tree;

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
        TreeNode root1 = new TreeNode ( 3 );
        root1.left = new TreeNode ( 9 );
        root1.right = new TreeNode ( 20 );
        root1.right.left = new TreeNode ( 15 );
        root1.right.right = new TreeNode ( 7 );
        System.out.println ( solution.isBalanced ( root1 ) ); // Output: true

        // Example 2
        TreeNode root2 = new TreeNode ( 1 );
        root2.left = new TreeNode ( 2 );
        root2.right = new TreeNode ( 2 );
        root2.left.left = new TreeNode ( 3 );
        root2.left.right = new TreeNode ( 3 );
        root2.left.left.left = new TreeNode ( 4 );
        root2.left.left.right = new TreeNode ( 4 );
        System.out.println ( solution.isBalanced ( root2 ) ); // Output: false

        // Example 3
        TreeNode root3 = null;
        System.out.println ( solution.isBalanced ( root3 ) ); // Output: true
    }

    public boolean isBalanced ( TreeNode root ) {
        return checkHeight ( root ) != -1;
    }

    private int checkHeight ( TreeNode node ) {
        if ( node == null ) {
            return 0;
        }

        int leftHeight = checkHeight ( node.left );
        if ( leftHeight == -1 ) {
            return -1;
        }

        int rightHeight = checkHeight ( node.right );
        if ( rightHeight == -1 ) {
            return -1;
        }

        if ( Math.abs ( leftHeight - rightHeight ) > 1 ) {
            return -1;
        }

        return Math.max ( leftHeight, rightHeight ) + 1;
    }
}

