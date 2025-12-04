package Problem_List.Q669_Trim_a_Binary_Search_Tree;

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
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) return null;
		
		if (root.val < low) {
			// усе ліве піддерево < low → відкидаємо
			return trimBST(root.right, low, high);
		}
		if (root.val > high) {
			// усе праве піддерево > high → відкидаємо
			return trimBST(root.left, low, high);
		}
		
		// root.val у межах → обрізаємо дітей
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}
}
