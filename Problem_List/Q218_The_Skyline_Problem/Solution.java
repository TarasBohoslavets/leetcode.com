package Problem_List.Q218_The_Skyline_Problem;

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        // Формування подій
        for (int[] building : buildings) {
            events.add(new int[]{building[0], -building[2]}); // Початок
            events.add(new int[]{building[1], building[2]});  // Кінець
        }

        // Сортування подій
        events.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // Максимальна черга
        maxHeap.add(0); // Початкова висота землі
        int prevMaxHeight = 0;

        // Обхід подій
        for (int[] event : events) {
            int x = event[0];
            int height = event[1];

            if (height < 0) { // Початок будівлі
                maxHeap.add(-height);
            } else { // Кінець будівлі
                maxHeap.remove(height);
            }

            int currentMaxHeight = maxHeap.peek(); // Поточна максимальна висота
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[][] buildings1 = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println("Skyline for buildings1: " + solution.getSkyline(buildings1));
        // Вихід: [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]

        // Приклад 2
        int[][] buildings2 = {{0, 2, 3}, {2, 5, 3}};
        System.out.println("Skyline for buildings2: " + solution.getSkyline(buildings2));
        // Вихід: [[0, 3], [5, 0]]

        // Приклад 3
        int[][] buildings3 = {{1, 5, 3}, {2, 4, 4}, {3, 6, 2}};
        System.out.println("Skyline for buildings3: " + solution.getSkyline(buildings3));
        // Вихід: [[1, 3], [2, 4], [4, 3], [5, 0]]
    }
}
