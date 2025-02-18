package Problem_List.Q337_House_Robber_III;

import java.util.HashMap;
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

    public int rob(TreeNode root) {
        return Math.max(robHelper(root, new HashMap<>())[0], robHelper(root, new HashMap<>())[1]);
    }

    private int[] robHelper(TreeNode node, Map<TreeNode, int[]> memo) {
        if (node == null) return new int[]{0, 0}; // Якщо вузла немає, нічого не грабуємо

        if (memo.containsKey(node)) return memo.get(node);

        int[] left = robHelper(node.left, memo);
        int[] right = robHelper(node.right, memo);

        // Грабуємо поточний вузол: додаємо його значення + не грабуємо дітей
        int robCurrent = node.val + left[1] + right[1];

        // Не грабуємо поточний вузол: вибираємо максимальне значення для кожного з дітей
        int skipCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        int[] result = new int[]{robCurrent, skipCurrent};
        memo.put(node, result); // Запам’ятовуємо результат для цього вузла

        return result;
    }

    /*
    class Solution {
    public int rob(TreeNode root) {
        int ans[] = f(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] f(TreeNode root) {
        if(root == null) return new int[2];
        int left [] = f(root.left);
        int right [] = f(root.right);
        int [] ans = new int[2];
        ans[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        ans[1] = root.val + left[0] + right[0];
        return ans;
    }
}
    * */
}
