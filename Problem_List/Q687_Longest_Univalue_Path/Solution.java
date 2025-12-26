package Problem_List.Q687_Longest_Univalue_Path;

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
	private int maxPath = 0;
	
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return maxPath;
	}
	
	private int dfs(TreeNode node) {
		if (node == null) return 0;
		
		int left = dfs(node.left);
		int right = dfs(node.right);
		
		int leftPath = 0, rightPath = 0;
		
		if (node.left != null && node.left.val == node.val) {
			leftPath = left + 1;
		}
		if (node.right != null && node.right.val == node.val) {
			rightPath = right + 1;
		}
		
		// оновлюємо глобальний максимум
		maxPath = Math.max(maxPath, leftPath + rightPath);
		
		// повертаємо найдовший шлях вниз
		return Math.max(leftPath, rightPath);
	}
}
