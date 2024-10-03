package Problem_List.Q95_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Перебираємо всі можливі варіанти кореня від start до end
        for (int i = start; i <= end; i++) {
            // Рекурсивно отримуємо всі можливі ліві піддерева
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            // Рекурсивно отримуємо всі можливі праві піддерева
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Поєднуємо кожен варіант лівого та правого піддерева з поточним коренем
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }

        return allTrees;
    }

    // Визначення класу вузла дерева
    public static class TreeNode {
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int n1 = 3;
        List<TreeNode> result1 = solution.generateTrees(n1);
        System.out.println("Кількість унікальних BST для n = 3: " + result1.size());

        // Приклад 2
        int n2 = 1;
        List<TreeNode> result2 = solution.generateTrees(n2);
        System.out.println("Кількість унікальних BST для n = 1: " + result2.size());
    }
}
