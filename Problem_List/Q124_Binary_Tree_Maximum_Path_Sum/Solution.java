package Problem_List.Q124_Binary_Tree_Maximum_Path_Sum;

// Визначення класу TreeNode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Конструктор за замовчуванням
    TreeNode() {
    }

    // Конструктор з одним параметром
    TreeNode(int val) {
        this.val = val;
    }

    // Конструктор з параметрами для встановлення дочірніх вузлів
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Глобальна змінна для зберігання максимальної суми шляху
    private int maxSum = Integer.MIN_VALUE;

    // Головний метод для обчислення максимальної суми шляху
    public int maxPathSum(TreeNode root) {
        // Викликаємо допоміжний метод для розрахунку максимальної суми шляху через кожен вузол
        maxGain(root);
        // Повертаємо глобальну змінну, що містить максимальну суму шляху
        return maxSum;
    }

    // Допоміжний метод для розрахунку максимальної суми шляху для кожного вузла
    private int maxGain(TreeNode node) {
        // Якщо вузол порожній, повертаємо 0
        if (node == null) {
            return 0;
        }

        // Розраховуємо максимальний шлях у лівій піддереві (ігноруючи негативні значення)
        int leftGain = Math.max(maxGain(node.left), 0);

        // Розраховуємо максимальний шлях у правій піддереві (ігноруючи негативні значення)
        int rightGain = Math.max(maxGain(node.right), 0);

        // Розраховуємо поточну максимальну суму шляху через цей вузол (включаючи лівий і правий нащадки)
        int currentMaxPath = node.val + leftGain + rightGain;

        // Оновлюємо максимальну суму, якщо поточний шлях більший
        maxSum = Math.max(maxSum, currentMaxPath);

        // Повертаємо максимальну суму шляху, що може продовжуватися через батьківський вузол
        return node.val + Math.max(leftGain, rightGain);
    }
}

