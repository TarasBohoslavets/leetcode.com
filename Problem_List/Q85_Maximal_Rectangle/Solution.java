package Problem_List.Q85_Maximal_Rectangle;

import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0; // Якщо матриця порожня, повертаємо 0

        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols]; // Масив для висот гістограми

        for (int i = 0; i < rows; i++) {
            // Оновлюємо висоти для гістограми
            for (int j = 0; j < cols; j++) {
                // Якщо матриця[j][i] == '1', збільшуємо висоту, інакше скидаємо до 0
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            // Обчислюємо максимальну площу для поточної рядки гістограми
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea; // Повертаємо максимальну площу
    }

    // Метод для обчислення максимальної площі в гістограмі
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Стек для зберігання індексів
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Визначаємо поточну висоту
            int h = (i == n ? 0 : heights[i]);

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // Якщо поточна висота менша за висоту на вершині стека
                int height = heights[stack.pop()]; // Висота поточного прямокутника
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Ширина прямокутника
                maxArea = Math.max(maxArea, height * width); // Оновлюємо максимальну площу
            }
            // Додаємо індекс в стек
            stack.push(i);
        }

        return maxArea; // Повертаємо максимальну площу прямокутника
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalRectangle(matrix)); // Output: 6
    }
}


//class Solution {
//    public int maximalRectangle(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return 0;
//        }
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[] heights = new int[cols];
//        int maxArea = 0;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == '1') {
//                    heights[j] += 1; // Increment height
//                } else {
//                    heights[j] = 0; // Reset height
//                }
//            }
//            maxArea = Math.max(maxArea, largestRectangleArea(heights));
//        }
//
//        return maxArea;
//    }
//
//    private int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i <= heights.length; i++) {
//            int currentHeight = (i == heights.length) ? 0 : heights[i];
//
//            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
//                int topIndex = stack.pop();
//                int height = heights[topIndex];
//                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
//                maxArea = Math.max(maxArea, height * width);
//            }
//            stack.push(i);
//        }
//
//        return maxArea;
//    }




