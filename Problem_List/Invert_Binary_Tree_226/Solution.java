package Problem_List.Invert_Binary_Tree_226;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // Example usage
        Solution solution = new Solution ( );

        // Example 1
        TreeNode root1 = new TreeNode ( 4,
                new TreeNode ( 2, new TreeNode ( 1 ), new TreeNode ( 3 ) ),
                new TreeNode ( 7, new TreeNode ( 6 ), new TreeNode ( 9 ) )
        );
        TreeNode invertedRoot1 = solution.invertTree ( root1 );
        printTree ( invertedRoot1 ); // Expected Output: [4, 7, 2, 9, 6, 3, 1]

        // Example 2
        TreeNode root2 = new TreeNode ( 2, new TreeNode ( 1 ), new TreeNode ( 3 ) );
        TreeNode invertedRoot2 = solution.invertTree ( root2 );
        printTree ( invertedRoot2 ); // Expected Output: [2, 3, 1]

        // Example 3
        TreeNode root3 = null;
        TreeNode invertedRoot3 = solution.invertTree ( root3 );
        printTree ( invertedRoot3 ); // Expected Output: []
    }

    private static void printTree ( TreeNode root ) {
        if ( root == null ) {
            System.out.println ( "[]" );
            return;
        }


        List<Integer> result = new ArrayList<> ( );

        Queue<TreeNode> queue = new LinkedList<> ( );
        queue.add ( root );
        while (!queue.isEmpty ( )) {
            TreeNode current = queue.poll ( );
            if ( current != null ) {
                result.add ( current.val );
                queue.add ( current.left );
                queue.add ( current.right );
            } else {
                result.add ( null );
            }
        }

        // Remove trailing nulls
        int lastNonNullIndex = result.size ( ) - 1;
        while (lastNonNullIndex >= 0 && result.get ( lastNonNullIndex ) == null) {
            lastNonNullIndex--;
        }

        System.out.println ( result.subList ( 0, lastNonNullIndex + 1 ) );
    }

    public TreeNode invertTree ( TreeNode root ) {
        if ( root == null ) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree ( root.left );
        TreeNode right = invertTree ( root.right );

        // Swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }
}
