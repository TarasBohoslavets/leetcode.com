package Problem_List.Q437_Path_Sum_III;

import java.util.HashMap;

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
    public int pathSum(TreeNode root, int targetSum) {
        // HashMap: сума -> скільки разів вона вже зустрічалась
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // для випадку коли currentSum == targetSum
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        currSum += node.val;
        int res = map.getOrDefault(currSum - target, 0); // шукаємо потрібну різницю

        // оновлюємо мапу
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // йдемо вглиб
        res += dfs(node.left, currSum, target, map);
        res += dfs(node.right, currSum, target, map);

        // відкат (backtrack)
        map.put(currSum, map.get(currSum) - 1);

        return res;
    }
}

