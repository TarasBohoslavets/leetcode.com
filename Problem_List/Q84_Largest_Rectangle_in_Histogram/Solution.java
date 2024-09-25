package Problem_List.Q84_Largest_Rectangle_in_Histogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // Стек для збереження індексів
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Проходимо по всім елементам масиву
        for (int i = 0; i <= n; i++) {
            // Визначаємо поточну висоту (для i == n задаємо висоту 0)
            int h = (i == n ? 0 : heights[i]);

            // Якщо поточна висота менша за висоту на вершині стека
            // обчислюємо площу можливих прямокутників
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];  // Висота поточного прямокутника
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // Ширина прямокутника
                maxArea = Math.max(maxArea, height * width);  // Оновлюємо максимальну площу
            }
            // Додаємо індекс в стек
            stack.push(i);
        }

        return maxArea;  // Повертаємо максимальну площу прямокутника
    }
}

