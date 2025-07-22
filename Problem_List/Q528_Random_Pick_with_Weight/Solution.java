package Problem_List.Q528_Random_Pick_with_Weight;

import java.util.*;

class Solution {
    private int[] prefix;
    private Random rand;
    private int total;

    public Solution(int[] w) {
        int n = w.length;
        prefix = new int[n];
        rand = new Random();

        prefix[0] = w[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        total = prefix[n - 1];
    }

    public int pickIndex() {
        int r = rand.nextInt(total) + 1; // [1, total]
        int left = 0, right = prefix.length - 1;

        // Бінарний пошук по prefix-сумі
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] < r) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}

