package Problem_List.Q257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main ( String[] args ) {
        // Test cases
        Solution sol = new Solution ( );

        // Example 1
        TreeNode root1 = new TreeNode ( 1 );
        root1.left = new TreeNode ( 2 );
        root1.right = new TreeNode ( 3 );
        root1.left.right = new TreeNode ( 5 );
        System.out.println ( sol.binaryTreePaths ( root1 ) ); // Output: ["1->2->5", "1->3"]

        // Example 2
        TreeNode root2 = new TreeNode ( 1 );
        System.out.println ( sol.binaryTreePaths ( root2 ) ); // Output: ["1"]
    }

    public List<String> binaryTreePaths ( TreeNode root ) {
        List<String> paths = new ArrayList<> ( );
        if ( root == null ) {
            return paths;
        }
        dfs ( root, "", paths );
        return paths;
    }

    private void dfs ( TreeNode node, String path, List<String> paths ) {
        if ( node == null ) {
            return;
        }
        // Build the path for the current node
        path += node.val;
        // If it's a leaf node, add the path to the list of paths
        if ( node.left == null && node.right == null ) {
            paths.add ( path );
        } else {
            // Continue the path with "->" if not a leaf
            path += "->";
            // Recursive DFS calls for left and right children
            dfs ( node.left, path, paths );
            dfs ( node.right, path, paths );
        }
    }
}

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
