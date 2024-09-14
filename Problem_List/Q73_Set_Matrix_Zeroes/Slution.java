package Problem_List.Q73_Set_Matrix_Zeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Перевіряємо, чи потрібно встановити перший рядок і стовпець в 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Використовуємо перший рядок і стовпець для позначення
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Встановлюємо нулі на основі маркерів
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Якщо перший рядок повинен бути нульовим
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Якщо перший стовпець повинен бути нульовим
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

/*
class Solution {
    public void setZeroes(int[][] matrix) {
        // use first col and row to mark whether it should be 0
        boolean needMarkFirstRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {// 0,0 means first row or col to mark? need to use 1st row only for col so use needMarkFirstRow for 1st row.
                        needMarkFirstRow = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }

        // skip first row since we need it to mark cols
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {// need mark row as 0
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {// need mark col as 0
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (needMarkFirstRow) {
            Arrays.fill(matrix[0], 0);
        }

    }
}
* */
