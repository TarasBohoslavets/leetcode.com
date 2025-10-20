package Problem_List.Q623_Add_One_Row_to_Tree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode() {
	}
	
	TreeNode(int val) {
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
class Solution {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			return new TreeNode(val, root, null);
		}
		
		insert(root, val, 1, depth);
		return root;
	}
	
	private void insert(TreeNode node, int val, int currentDepth, int targetDepth) {
		if (node == null) return;
		
		if (currentDepth == targetDepth - 1) {
			node.left = new TreeNode(val, node.left, null);
			node.right = new TreeNode(val, null, node.right);
		} else {
			insert(node.left, val, currentDepth + 1, targetDepth);
			insert(node.right, val, currentDepth + 1, targetDepth);
		}
	}
}