package Problem_List.Q406_Queue_Reconstruction_by_Height;

import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 1. Сортуємо: спочатку за висотою `h` (за спаданням), потім за `k` (за зростанням)
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        // 2. Додаємо людей у список за `k` як позицією
        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person); // Вставка на позицію `k`
        }
        // 3. Перетворюємо список у масив
        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] input1 = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println("Output: " + Arrays.deepToString(solution.reconstructQueue(input1)));
        // Очікуваний результат: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        int[][] input2 = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        System.out.println("Output: " + Arrays.deepToString(solution.reconstructQueue(input2)));
        // Очікуваний результат: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
    }
}
