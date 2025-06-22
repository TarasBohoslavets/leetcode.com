package Problem_List.Q506_Relative_Ranks;

import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        // Масив пар [score, index]
        int[][] ranks = new int[n][2];
        for (int i = 0; i < n; i++) {
            ranks[i][0] = score[i];
            ranks[i][1] = i;
        }

        // Сортуємо за спаданням оцінок
        Arrays.sort(ranks, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int index = ranks[i][1];
            if (i == 0) res[index] = "Gold Medal";
            else if (i == 1) res[index] = "Silver Medal";
            else if (i == 2) res[index] = "Bronze Medal";
            else res[index] = String.valueOf(i + 1);
        }

        return res;
    }
}
