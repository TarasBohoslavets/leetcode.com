package Problem_List.Q508_Most_Frequent_Subtree_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Integer, Integer> count = new HashMap<>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);

        List<Integer> result = new ArrayList<>();
        for (int sum : count.keySet()) {
            if (count.get(sum) == maxFreq) {
                result.add(sum);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;

        int left = postOrder(node.left);
        int right = postOrder(node.right);
        int sum = left + right + node.val;

        count.put(sum, count.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, count.get(sum));

        return sum;
    }
}
