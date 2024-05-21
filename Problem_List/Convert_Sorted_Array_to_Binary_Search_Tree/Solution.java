package Problem_List.Convert_Sorted_Array_to_Binary_Search_Tree;

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
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = solution.sortedArrayToBST ( nums1 );
        printInOrder ( root1 ); // Output: [-10, -3, 0, 5, 9]

        // Example 2
        int[] nums2 = {1, 3};
        TreeNode root2 = solution.sortedArrayToBST ( nums2 );
        printInOrder ( root2 ); // Output: [1, 3]
    }

    // Helper method to print the tree in-order (for testing purposes)
    private static void printInOrder ( TreeNode node ) {
        if ( node != null ) {
            printInOrder ( node.left );
            System.out.print ( node.val + " " );
            printInOrder ( node.right );
        }
    }

    public TreeNode sortedArrayToBST ( int[] nums ) {
        if ( nums == null || nums.length == 0 ) {
            return null;
        }
        return helper ( nums, 0, nums.length - 1 );
    }

    private TreeNode helper ( int[] nums, int left, int right ) {
        if ( left > right ) {
            return null;
        }

        // Middle element
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode ( nums[mid] );

        // Recursively build left and right subtrees
        node.left = helper ( nums, left, mid - 1 );
        node.right = helper ( nums, mid + 1, right );

        return node;
    }
}

