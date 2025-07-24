package Problem_List.Q532_K_diff_Pairs_in_an_Array;

import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int key : freq.keySet()) {
            if (k == 0) {
                // Шукаємо парні елементи, тобто однакові числа
                if (freq.get(key) >= 2) count++;
            } else {
                // Шукаємо key + k
                if (freq.containsKey(key + k)) count++;
            }
        }
        return count;
    }
}

