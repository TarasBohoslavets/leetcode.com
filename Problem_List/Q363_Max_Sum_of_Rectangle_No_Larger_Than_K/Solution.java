package Problem_List.Q363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.*;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;

        // Iterate through all pairs of left and right columns
        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[m]; // This will store the sum of elements between the columns 'left' and 'right'

            for (int right = left; right < n; right++) {
                // Update rowSum to include elements from the current right column
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][right];
                }

                // Now, we need to find the maximum sum of a subarray in rowSum that does not exceed 'k'
                TreeSet<Integer> prefixSumSet = new TreeSet<>();
                prefixSumSet.add(0); // Add the initial prefix sum (which is 0)

                int currentSum = 0;
                for (int sum : rowSum) {
                    currentSum += sum;

                    // We want the largest prefix sum that is <= currentSum - k
                    Integer target = prefixSumSet.ceiling(currentSum - k);
                    if (target != null) {
                        result = Math.max(result, currentSum - target);
                    }

                    prefixSumSet.add(currentSum);
                }
            }
        }

        return result;
    }
}
