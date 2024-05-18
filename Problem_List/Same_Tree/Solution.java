package Problem_List.Same_Tree;

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
        TreeNode p1 = new TreeNode ( 1, new TreeNode ( 2 ), new TreeNode ( 3 ) );
        TreeNode q1 = new TreeNode ( 1, new TreeNode ( 2 ), new TreeNode ( 3 ) );
        System.out.println ( solution.isSameTree ( p1, q1 ) ); // Output: true

        // Example 2
        TreeNode p2 = new TreeNode ( 1, new TreeNode ( 2 ), null );
        TreeNode q2 = new TreeNode ( 1, null, new TreeNode ( 2 ) );
        System.out.println ( solution.isSameTree ( p2, q2 ) ); // Output: false

        // Example 3
        TreeNode p3 = new TreeNode ( 1, new TreeNode ( 2 ), new TreeNode ( 1 ) );
        TreeNode q3 = new TreeNode ( 1, new TreeNode ( 1 ), new TreeNode ( 2 ) );
        System.out.println ( solution.isSameTree ( p3, q3 ) ); // Output: false
    }

    public boolean isSameTree ( TreeNode p, TreeNode q ) {
        // If both nodes are null, they are the same
        if ( p == null && q == null ) {
            return true;
        }
        // If one of the nodes is null, they are not the same
        if ( p == null || q == null ) {
            return false;
        }
        // If the values of the nodes are different, they are not the same
        if ( p.val != q.val ) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree ( p.left, q.left ) && isSameTree ( p.right, q.right );
    }
}

