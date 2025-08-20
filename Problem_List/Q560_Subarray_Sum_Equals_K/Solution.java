package Problem_List.Q560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);  // базовий випадок: сума 0 зустрілась один раз

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum - k);
            }

            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}