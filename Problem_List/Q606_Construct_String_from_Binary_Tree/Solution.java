package Problem_List.Q606_Construct_String_from_Binary_Tree;

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
	public String tree2str(TreeNode root) {
		if (root == null) return "";
		
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}
	
	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) return;
		
		sb.append(node.val);
		
		// Якщо є хоча б один дочірній вузол
		if (node.left != null || node.right != null) {
			sb.append("(");
			buildString(node.left, sb);
			sb.append(")");
			
			// Якщо є правий, але немає лівого — потрібно явно вказати ()
			if (node.right != null) {
				sb.append("(");
				buildString(node.right, sb);
				sb.append(")");
			}
		}
	}
}