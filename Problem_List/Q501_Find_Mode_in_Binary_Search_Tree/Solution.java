package Problem_List.Q501_Find_Mode_in_Binary_Search_Tree;

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
    private Integer prev = null; // Зберігає попереднє значення вузла
    private int maxCount = 0; // Максимальна кількість повторень знайденого числа
    private int currentCount = 0; // Лічильник повторень поточного числа
    private List<Integer> modes = new ArrayList<>(); // Список для збереження мод

    public int[] findMode(TreeNode root) {
        inOrder(root); // Запускаємо обхід дерева в порядку in-order
        return modes.stream().mapToInt(i -> i).toArray(); // Перетворюємо список у масив
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left); // Обхід лівого піддерева

        // Оновлення лічильників для визначення моди
        if (prev == null || node.val != prev) {
            currentCount = 1; // Починаємо підрахунок нового числа
        } else {
            currentCount++; // Збільшуємо лічильник для повторюваного числа
        }

        // Якщо знайшли нову модальність
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        prev = node.val; // Оновлюємо попереднє значення

        inOrder(node.right); // Обхід правого піддерева
    }
}

