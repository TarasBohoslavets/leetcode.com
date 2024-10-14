package Problem_List.Q101_Symmetric_Tree;

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
        TreeNode root1 = new TreeNode ( 1,
                new TreeNode ( 2, new TreeNode ( 3 ), new TreeNode ( 4 ) ),
                new TreeNode ( 2, new TreeNode ( 4 ), new TreeNode ( 3 ) ) );
        System.out.println ( solution.isSymmetric ( root1 ) ); // Output: true

        // Example 2
        TreeNode root2 = new TreeNode ( 1,
                new TreeNode ( 2, null, new TreeNode ( 3 ) ),
                new TreeNode ( 2, null, new TreeNode ( 3 ) ) );
        System.out.println ( solution.isSymmetric ( root2 ) ); // Output: false
    }

    public boolean isSymmetric ( TreeNode root ) {
        return isMirror ( root, root );
    }

    private boolean isMirror ( TreeNode t1, TreeNode t2 ) {
        if ( t1 == null && t2 == null ) return true;
        if ( t1 == null || t2 == null ) return false;
        return (t1.val == t2.val)
                && isMirror ( t1.right, t2.left )
                && isMirror ( t1.left, t2.right );
    }
}

