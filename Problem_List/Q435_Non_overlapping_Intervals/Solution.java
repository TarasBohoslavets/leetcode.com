package Problem_List.Q435_Non_overlapping_Intervals;

import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Сортуємо за кінцем інтервалу
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                // не перетинається, зберігаємо
                end = interval[1];
                count++;
            }
        }

        // Всі - ті, що не перетинаються = ті, що потрібно видалити
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] test1 = {{1,2},{2,3},{3,4},{1,3}};
        int[][] test2 = {{1,2},{1,2},{1,2}};
        int[][] test3 = {{1,2},{2,3}};

        System.out.println(sol.eraseOverlapIntervals(test1)); // → 1
        System.out.println(sol.eraseOverlapIntervals(test2)); // → 2
        System.out.println(sol.eraseOverlapIntervals(test3)); // → 0
    }
}

