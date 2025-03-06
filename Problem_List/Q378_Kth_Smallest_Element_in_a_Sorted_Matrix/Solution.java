package Problem_List.Q378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Мін-куча для зберігання елементів у форматі (значення, рядок, стовпчик)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Додаємо перший елемент кожного рядка в мін-кучу
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] { matrix[i][0], i, 0 });
        }

        // Знайдемо k-й найменший елемент
        int count = 0;
        while (!minHeap.isEmpty()) {
            // Отримуємо найменший елемент з мін-кучі
            int[] curr = minHeap.poll();
            int val = curr[0];  // Значення елемента
            int row = curr[1];  // Рядок елемента
            int col = curr[2];  // Стовпчик елемента

            count++;

            // Якщо ми досягли k-го елемента, повертаємо його
            if (count == k) {
                return val;
            }

            // Якщо є наступний елемент у цьому рядку, додаємо його в мін-кучу
            if (col + 1 < n) {
                minHeap.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }

        // Якщо ми не знайшли k-й елемент (що неможливо в межах задачі)
        return -1;  // це лише для випадків, коли буде помилка
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[][] matrix1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k1 = 8;
        System.out.println("Приклад 1: k-й найменший елемент: " + solution.kthSmallest(matrix1, k1));

        // Приклад 2
        int[][] matrix2 = {
                {-5}
        };
        int k2 = 1;
        System.out.println("Приклад 2: k-й найменший елемент: " + solution.kthSmallest(matrix2, k2));

        // Приклад 3: Велика матриця
        int[][] matrix3 = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {3, 5, 7, 9},
                {4, 6, 8, 10}
        };
        int k3 = 7;
        System.out.println("Приклад 3: k-й найменший елемент: " + solution.kthSmallest(matrix3, k3));

        // Приклад 4: Матриця з великими значеннями
        int[][] matrix4 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k4 = 4;
        System.out.println("Приклад 4: k-й найменший елемент: " + solution.kthSmallest(matrix4, k4));
    }
}
