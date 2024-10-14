package Problem_List.Q222_Count_Complete_Tree_Nodes;

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

class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Test case 1
        TreeNode root1 = new TreeNode ( 1,
                new TreeNode ( 2,
                        new TreeNode ( 4 ),
                        new TreeNode ( 5 ) ),
                new TreeNode ( 3,
                        new TreeNode ( 6 ),
                        null ) );
        System.out.println ( solution.countNodes ( root1 ) ); // Expected output: 6

        // Test case 2
        TreeNode root2 = null;
        System.out.println ( solution.countNodes ( root2 ) ); // Expected output: 0

        // Test case 3
        TreeNode root3 = new TreeNode ( 1 );
        System.out.println ( solution.countNodes ( root3 ) ); // Expected output: 1
    }

    public int countNodes ( TreeNode root ) {
        if ( root == null ) {
            return 0;
        }

        int leftDepth = getDepth ( root.left );
        int rightDepth = getDepth ( root.right );

        if ( leftDepth == rightDepth ) {
            // The left subtree is a perfect binary tree
            return (1 << leftDepth) + countNodes ( root.right );
        } else {
            // The right subtree is a perfect binary tree
            return (1 << rightDepth) + countNodes ( root.left );
        }
    }

    private int getDepth ( TreeNode node ) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
}
