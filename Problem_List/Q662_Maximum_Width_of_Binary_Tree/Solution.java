package Problem_List.Q662_Maximum_Width_of_Binary_Tree;

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
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		
		Queue<AbstractMap.SimpleEntry<TreeNode, Long>> queue = new LinkedList<>();
		queue.offer(new AbstractMap.SimpleEntry<>(root, 0L));
		
		int maxWidth = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			long minIndex = queue.peek().getValue(); // індекс першого вузла на рівні
			long first = 0, last = 0;
			
			for (int i = 0; i < size; i++) {
				AbstractMap.SimpleEntry<TreeNode, Long> entry = queue.poll();
				TreeNode node = entry.getKey();
				long index = entry.getValue() - minIndex; // нормалізація, щоб уникнути переповнення
				
				if (i == 0) first = index;
				if (i == size - 1) last = index;
				
				if (node.left != null) {
					queue.offer(new AbstractMap.SimpleEntry<>(node.left, 2 * index));
				}
				if (node.right != null) {
					queue.offer(new AbstractMap.SimpleEntry<>(node.right, 2 * index + 1));
				}
			}
			
			maxWidth = Math.max(maxWidth, (int)(last - first + 1));
		}
		
		return maxWidth;
	}
}

