package Problem_List.Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;
import java.util.Map;

 class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
    TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


class Solution {
    private Map<Integer, Integer> inorderIndexMap;
    private int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderIndexMap.get(rootValue);

        // Спочатку будуємо праве піддерево, тому що обхід postorder має правий елемент раніше
        root.right = buildTreeHelper(inorder, postorder, inorderIndex + 1, inorderEnd);
        root.left = buildTreeHelper(inorder, postorder, inorderStart, inorderIndex - 1);

        return root;
    }
}

