package Problem_List.Q498_Diagonal_Traverse;

import java.util.Arrays;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n]; // Масив для збереження результату
        int row = 0, col = 0, index = 0;
        boolean upward = true; // Напрям руху: вверх чи вниз

        while (index < m * n) {
            result[index++] = mat[row][col]; // Додаємо поточний елемент в результат

            if (upward) {
                // Якщо ми рухаємося вверх
                if (col == n - 1) {
                    row++; upward = false; // Досягли правого краю → рух вниз
                } else if (row == 0) {
                    col++; upward = false; // Досягли верхнього краю → рух вниз
                } else {
                    row--; col++; // Рух вверх по діагоналі
                }
            } else {
                // Якщо ми рухаємося вниз
                if (row == m - 1) {
                    col++; upward = true; // Досягли нижнього краю → рух вверх
                } else if (col == 0) {
                    row++; upward = true; // Досягли лівого краю → рух вверх
                } else {
                    row++; col--; // Рух вниз по діагоналі
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse solver = new DiagonalTraverse();
        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(solver.findDiagonalOrder(mat1))); // [1,2,4,7,5,3,6,8,9]

        int[][] mat2 = {{1,2},{3,4}};
        System.out.println(Arrays.toString(solver.findDiagonalOrder(mat2))); // [1,2,3,4]
    }
}


