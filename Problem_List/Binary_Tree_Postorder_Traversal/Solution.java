package Problem_List.Binary_Tree_Postorder_Traversal;



import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal ( TreeNode root ) {
        List<Integer> result = new ArrayList<> ( );
        postorderHelper ( root, result );
        return result;
    }

    private void postorderHelper ( TreeNode node, List<Integer> result ) {
        if ( node == null ) {
            return;
        }
        postorderHelper ( node.left, result );
        postorderHelper ( node.right, result );
        result.add ( node.val );
    }
}

