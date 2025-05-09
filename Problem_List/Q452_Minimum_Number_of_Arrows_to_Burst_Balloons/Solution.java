package Problem_List.Q452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Сортування за кінцевою координатою xend
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // Якщо поточна куля не перекривається — стріляємо новою стрілою
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] input2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] input3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] input4 = {{1, 10}, {2, 9}, {3, 8}, {4, 7}};

        System.out.println("Example 1 (Expected: 2): " + sol.findMinArrowShots(input1));
        System.out.println("Example 2 (Expected: 4): " + sol.findMinArrowShots(input2));
        System.out.println("Example 3 (Expected: 2): " + sol.findMinArrowShots(input3));
        System.out.println("Example 4 (Expected: 1): " + sol.findMinArrowShots(input4));
    }
}

