package Problem_List.Q304_Range_Sum_Query_2D_Immutable;

class NumMatrix {
    private int[][] prefixSums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        prefixSums = new int[m + 1][n + 1];

        // Заповнюємо prefixSums: кожна клітинка містить суму елементів від (0,0) до (i-1,j-1)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSums[i][j] = matrix[i - 1][j - 1]
                        + prefixSums[i - 1][j]
                        + prefixSums[i][j - 1]
                        - prefixSums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSums[row2 + 1][col2 + 1]
                - prefixSums[row1][col2 + 1]
                - prefixSums[row2 + 1][col1]
                + prefixSums[row1][col1];
    }

    public static void main(String[] args) {
        // Приклад з завдання
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Виведе 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Виведе 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Виведе 12
    }
}

