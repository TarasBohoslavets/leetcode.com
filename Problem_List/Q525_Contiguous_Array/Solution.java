package Problem_List.Q525_Contiguous_Array;

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1); // для випадку, коли subarray починається з індексу 0

        int maxLength = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;

            if (prefixMap.containsKey(sum)) {
                int prevIndex = prefixMap.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                prefixMap.put(sum, i);
            }
        }

        return maxLength;
    }
}

