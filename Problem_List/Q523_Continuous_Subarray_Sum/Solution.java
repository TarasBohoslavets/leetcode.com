package Problem_List.Q523_Continuous_Subarray_Sum;

import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map: (sum % k) → earliest index
        Map<Integer, Integer> modIndexMap = new HashMap<>();
        modIndexMap.put(0, -1); // важливо для випадку, коли сума сама по собі кратна k

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;

            if (modIndexMap.containsKey(mod)) {
                int prevIndex = modIndexMap.get(mod);
                if (i - prevIndex >= 2) return true; // довжина підмасиву ≥ 2
            } else {
                modIndexMap.put(mod, i); // зберігаємо лише перший індекс для цього mod
            }
        }
        return false;
    }
}
