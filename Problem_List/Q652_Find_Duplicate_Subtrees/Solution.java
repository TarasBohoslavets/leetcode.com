package Problem_List.Q652_Find_Duplicate_Subtrees;

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
	Map<String, Integer> count;
	List<TreeNode> result;
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		count = new HashMap<>();
		result = new ArrayList<>();
		serialize(root);
		return result;
	}
	
	private String serialize(TreeNode node) {
		if (node == null) return "#"; // позначаємо null
		
		String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);
		
		int freq = count.getOrDefault(serial, 0);
		if (freq == 1) {
			// якщо зустріли вдруге → додаємо у результат
			result.add(node);
		}
		count.put(serial, freq + 1);
		
		return serial;
	}
}
