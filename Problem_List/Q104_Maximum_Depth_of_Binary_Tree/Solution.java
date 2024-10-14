package Problem_List.Q104_Maximum_Depth_of_Binary_Tree;


import java.util.LinkedList;
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

public class Solution {
    public static void main ( String[] args ) {
        Solution solution = new Solution ( );

        // Example 1
        TreeNode root1 = new TreeNode ( 3,
                new TreeNode ( 9 ),
                new TreeNode ( 20, new TreeNode ( 15 ), new TreeNode ( 7 ) ) );
        System.out.println ( solution.maxDepth ( root1 ) ); // Output: 3

        // Example 2
        TreeNode root2 = new TreeNode ( 1, null, new TreeNode ( 2 ) );
        System.out.println ( solution.maxDepth ( root2 ) ); // Output: 2
    }

    public int maxDepth ( TreeNode root ) {
        if ( root == null ) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<> ( );
        queue.add ( root );
        int depth = 0;

        while (!queue.isEmpty ( )) {
            int levelSize = queue.size ( );
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll ( );
                if ( node.left != null ) {
                    queue.add ( node.left );
                }
                if ( node.right != null ) {
                    queue.add ( node.right );
                }
            }
            depth++;
        }

        return depth;
    }
}
