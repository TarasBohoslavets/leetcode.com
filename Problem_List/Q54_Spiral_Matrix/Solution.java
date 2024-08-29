package Problem_List.Q54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Проходимо зліва направо по верхньому рядку
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Проходимо зверху вниз по правій колонці
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Проходимо справа наліво по нижньому рядку, якщо залишилось більше одного рядка
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Проходимо знизу вверх по лівій колонці, якщо залишилось більше однієї колонки
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Input: " + java.util.Arrays.deepToString(matrix1));
        System.out.println("Output: " + solution.spiralOrder(matrix1));
        // Очікуваний вихід: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Приклад 2
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("\nInput: " + java.util.Arrays.deepToString(matrix2));
        System.out.println("Output: " + solution.spiralOrder(matrix2));
        // Очікуваний вихід: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}

