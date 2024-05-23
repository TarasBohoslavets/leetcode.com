package Problem_List.Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println ( solution.minDepth ( root1 ) ); // Output: 2

        // Example 2
        TreeNode root2 = new TreeNode ( 2 );
        root2.right = new TreeNode ( 3 );
        root2.right.right = new TreeNode ( 4 );
        root2.right.right.right = new TreeNode ( 5 );
        root2.right.right.right.right = new TreeNode ( 6 );
        System.out.println ( solution.minDepth ( root2 ) ); // Output: 5
    }

    public int minDepth ( TreeNode root ) {
        if ( root == null ) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<> ( );
        queue.add ( root );
        int depth = 1;

        while (!queue.isEmpty ( )) {
            int size = queue.size ( );
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll ( );

                // Check if this node is a leaf node
                if ( current.left == null && current.right == null ) {
                    return depth;
                }

                // Add left and right children to the queue
                if ( current.left != null ) {
                    queue.add ( current.left );
                }
                if ( current.right != null ) {
                    queue.add ( current.right );
                }
            }
            depth++;
        }

        return depth;
    }
}

