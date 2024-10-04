package Problem_List.Q96_Unique_Binary_Search_Trees;

class Solution {
    public int numTrees(int n) {
        // Масив для зберігання кількості дерев для кожного n
        int[] dp = new int[n + 1];
        // Базові випадки
        dp[0] = 1; // Порожнє дерево
        dp[1] = 1; // Дерево з одним вузлом

        // Обчислюємо кількість дерев для кожного n від 2 до n
        for (int i = 2; i <= n; i++) {
            // Для кожного i знаходимо кількість дерев з коренем у i
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int n1 = 3;
        System.out.println("Кількість унікальних BST для n = 3: " + solution.numTrees(n1)); // Виведе 5

        // Приклад 2
        int n2 = 1;
        System.out.println("Кількість унікальних BST для n = 1: " + solution.numTrees(n2)); // Виведе 1
    }
}
