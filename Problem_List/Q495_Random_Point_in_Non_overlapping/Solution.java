package Problem_List.Q495_Random_Point_in_Non_overlapping;

import java.util.Random;

public class Solution {
    private int[][] rects;
    private int[] prefixSum;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefixSum = new int[rects.length];
        this.rand = new Random();

        // Заповнюємо префіксні суми
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int count = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            sum += count;
            prefixSum[i] = sum;
        }
    }

    public int[] pick() {
        // Випадково вибираємо прямокутник за вагами
        int target = rand.nextInt(prefixSum[prefixSum.length - 1]);
        int index = binarySearch(target);

        // Генеруємо випадкову точку всередині обраного прямокутника
        int x = rects[index][0] + rand.nextInt(rects[index][2] - rects[index][0] + 1);
        int y = rects[index][1] + rand.nextInt(rects[index][3] - rects[index][1] + 1);

        return new int[]{x, y};
    }

    private int binarySearch(int target) {
        int left = 0, right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}});
        System.out.println(java.util.Arrays.toString(solution.pick())); // Випадкова точка
    }
}

