package Problem_List.Q655_Print_Binary_Tree;

import java.util.*;

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
	public List<List<String>> printTree(TreeNode root) {
		int height = getHeight(root);
		int m = height + 1;
		int n = (int) Math.pow(2, m) - 1;
		
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			List<String> row = new ArrayList<>(Collections.nCopies(n, ""));
			res.add(row);
		}
		
		fill(res, root, 0, (n - 1) / 2, height);
		return res;
	}
	
	private int getHeight(TreeNode node) {
		if (node == null) return -1;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	private void fill(List<List<String>> res, TreeNode node, int row, int col, int height) {
		if (node == null) return;
		res.get(row).set(col, String.valueOf(node.val));
		
		int offset = (int) Math.pow(2, height - row - 1);
		if (node.left != null) {
			fill(res, node.left, row + 1, col - offset, height);
		}
		if (node.right != null) {
			fill(res, node.right, row + 1, col + offset, height);
		}
	}
}

