package Problem_List.Q240_Search_a_2D_Matrix_II;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Починаємо з правого верхнього кута
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Знайдено цільове значення
            } else if (matrix[row][col] > target) {
                col--; // Рухаємося вліво
            } else {
                row++; // Рухаємося вниз
            }
        }

        return false; // Цільове значення не знайдено
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(solution.searchMatrix(matrix, 5));  // Output: true
        System.out.println(solution.searchMatrix(matrix, 20)); // Output: false
    }
}

