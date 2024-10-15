package Problem_List.Q113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>(); // Створюємо список для збереження всіх шляхів
        List<Integer> currentPath = new ArrayList<>();  // Список для поточного шляху

        // Викликаємо допоміжний метод для пошуку всіх можливих шляхів
        findPaths(root, targetSum, currentPath, result);

        return result; // Повертаємо список шляхів, які дорівнюють targetSum
    }

    // Допоміжний метод для пошуку шляхів
    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return; // Якщо вузол порожній, повертаємося

        currentPath.add(node.val); // Додаємо поточне значення вузла до поточного шляху

        // Перевіряємо, чи є цей вузол листком та чи дорівнює сума шляху targetSum
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath)); // Якщо так, додаємо цей шлях до результату
        } else {
            // Продовжуємо пошук в лівому і правому піддереві
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1); // Після обробки вузла видаляємо його зі списку, щоб повернутися назад
    }
}

