package Problem_List.Q59_Spiral_Matrix_II;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {
            // Заповнюємо верхній рядок зліва направо
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // переміщуємо верхню границю вниз

            // Заповнюємо правий стовпець зверху вниз
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // переміщуємо праву границю вліво

            // Заповнюємо нижній рядок справа наліво
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--; // переміщуємо нижню границю вверх
            }

            // Заповнюємо лівий стовпець знизу вверх
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++; // переміщуємо ліву границю вправо
            }
        }

        return matrix;
    }
}

