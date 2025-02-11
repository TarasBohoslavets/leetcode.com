package Problem_List.Q329_Longest_Increasing_Path_in_a_Matrix;

class Solution {
    // Масив напрямків для руху (вгору, вниз, вліво, вправо)
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] dp; // Кеш для збереження довжин шляхів
    private int rows, cols; // Кількість рядків і стовпців у матриці

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0; // Перевірка на порожню матрицю

        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols]; // Ініціалізація кешу

        int maxLength = 0; // Змінна для збереження максимальної довжини шляху

        // Запускаємо DFS для кожної клітинки
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j)); // Оновлюємо максимальний шлях
            }
        }

        return maxLength; // Повертаємо найдовший знайдений шлях
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j]; // Якщо вже обчислювали цю клітинку — повертаємо кешоване значення

        int maxLength = 1; // Мінімальна довжина шляху — це сама клітинка

        // Перебираємо всі можливі напрямки
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1]; // Нові координати

            // Перевіряємо, чи можемо рухатися (не виходимо за межі + наступне значення більше)
            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && matrix[ni][nj] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, ni, nj)); // Оновлюємо максимальний шлях
            }
        }

        dp[i][j] = maxLength; // Запам'ятовуємо обчислене значення в кеш
        return maxLength; // Повертаємо довжину найдовшого шляху для поточної клітинки
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix1 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(sol.longestIncreasingPath(matrix1)); // Виведе 4

        int[][] matrix2 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(sol.longestIncreasingPath(matrix2)); // Виведе 4

        int[][] matrix3 = {{1}};
        System.out.println(sol.longestIncreasingPath(matrix3)); // Виведе 1
    }
}

