package Problem_List.Q436_Find_Right_Interval;

import java.util.*;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // Масив пар (start, index)
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // start
            starts[i][1] = i;               // index
        }

        // Сортуємо за start
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            result[i] = binarySearch(starts, end);
        }

        return result;
    }

    private int binarySearch(int[][] starts, int target) {
        int left = 0, right = starts.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (starts[mid][0] >= target) {
                ans = starts[mid][1];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.findRightInterval(new int[][]{{1,2}})));               // [-1]
        System.out.println(Arrays.toString(sol.findRightInterval(new int[][]{{3,4},{2,3},{1,2}})));   // [-1,0,1]
        System.out.println(Arrays.toString(sol.findRightInterval(new int[][]{{1,4},{2,3},{3,4}})));   // [-1,2,-1]
    }
}

