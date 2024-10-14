package Problem_List.Q94_Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        // Example 1
        TreeNode root1 = new TreeNode ( 1, null, new TreeNode ( 2, new TreeNode ( 3 ), null ) );
        System.out.println ( new Solution ( ).inorderTraversal ( root1 ) ); // Output: [1, 3, 2]

        // Example 2
        TreeNode root2 = null;
        System.out.println ( new Solution ( ).inorderTraversal ( root2 ) ); // Output: []

        // Example 3
        TreeNode root3 = new TreeNode ( 1 );
        System.out.println ( new Solution ( ).inorderTraversal ( root3 ) ); // Output: [1]
    }

    public List<Integer> inorderTraversal ( TreeNode root ) {
        List<Integer> result = new ArrayList<> ( );
        Stack<TreeNode> stack = new Stack<> ( );
        TreeNode current = root;

        while (current != null || !stack.isEmpty ( )) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push ( current );
                current = current.left;
            }
            // Process the node
            current = stack.pop ( );
            result.add ( current.val );
            // Traverse the right subtree
            current = current.right;
        }

        return result;
    }
}
