package Problem_List.Q107_Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Створюємо список для збереження результатів рівнів у зворотньому порядку
        List<List<Integer>> result = new LinkedList<>();

        // Якщо дерево порожнє, повертаємо порожній список
        if (root == null) return result;

        // Створюємо чергу для обходу дерева по рівнях
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Додаємо корінь дерева до черги

        // Виконуємо обхід дерева, поки черга не стане порожньою
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Кількість вузлів на поточному рівні
            List<Integer> currentLevel = new ArrayList<>(); // Список для збереження значень поточного рівня

            // Обробляємо всі вузли поточного рівня
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Беремо вузол з черги
                currentLevel.add(currentNode.val); // Додаємо значення вузла до поточного рівня

                // Якщо у вузла є лівий нащадок, додаємо його до черги
                if (currentNode.left != null) queue.offer(currentNode.left);

                // Якщо у вузла є правий нащадок, додаємо його до черги
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Додаємо список поточного рівня на початок результатів
            result.add(0, currentLevel);
        }

        // Повертаємо список рівнів у зворотньому порядку
        return result;
    }
}


