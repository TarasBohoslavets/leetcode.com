package Problem_List.Q563_Binary_Tree_Tilt;

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
	private int totalTilt = 0;
	
	public int findTilt(TreeNode root) {
		dfs(root);
		return totalTilt;
	}
	
	// Повертає суму значень піддерева і паралельно накопичує нахил
	private int dfs(TreeNode node) {
		if (node == null) return 0;
		
		int leftSum = dfs(node.left);
		int rightSum = dfs(node.right);
		
		int tilt = Math.abs(leftSum - rightSum);
		totalTilt += tilt;
		
		return leftSum + rightSum + node.val;
	}
}
