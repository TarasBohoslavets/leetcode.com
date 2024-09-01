package Problem_List.Q55_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Спочатку сортуємо інтервали за їх початком
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // Якщо список об'єднаних інтервалів порожній або останній інтервал не перекривається з поточним
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Інакше, об'єднуємо поточний інтервал з попереднім
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
//        if (intervals == null || intervals.length == 0) return new int[0][];
//
//        // Сортуємо інтервали за початковими значеннями
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//
//        // Використовуємо Stream API для об'єднання інтервалів
//        LinkedList<int[]> merged = Arrays.stream(intervals)
//            .collect(Collectors.toCollection(LinkedList::new));
//
//        return merged.stream()
//            .reduce((res, interval) -> {
//                int[] last = res.getLast();
//                if (last[1] >= interval[0]) {
//                    last[1] = Math.max(last[1], interval[1]);
//                } else {
//                    res.add(interval);
//                }
//                return res;
//            })
//            .get()
//            .toArray(new int[merged.size()][]);
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println("Input: " + Arrays.deepToString(intervals1));
        System.out.println("Output: " + Arrays.deepToString(result1));
        // Очікуваний вихід: [[1, 6], [8, 10], [15, 18]]

        // Приклад 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println("Input: " + Arrays.deepToString(intervals2));
        System.out.println("Output: " + Arrays.deepToString(result2));
        // Очікуваний вихід: [[1, 5]]
    }
}
