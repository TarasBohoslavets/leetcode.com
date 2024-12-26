package Problem_List.Q220_Contains_Duplicate_III;

import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // Використовуємо TreeSet для зберігання чисел у поточному вікні
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Перевіряємо, чи існує елемент у вікні, що відповідає умові abs(nums[i] - nums[j]) <= valueDiff
            Long floor = set.floor((long) nums[i] + valueDiff);
            Long ceil = set.ceiling((long) nums[i] - valueDiff);

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            // Додаємо поточний елемент у вікно
            set.add((long) nums[i]);

            // Видаляємо елемент, якщо вікно перевищує `indexDiff`
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {1, 2, 3, 1};
        int indexDiff1 = 3, valueDiff1 = 0;
        System.out.println("Result (Example 1): " + solution.containsNearbyAlmostDuplicate(nums1, indexDiff1, valueDiff1)); // Вихід: true

        // Приклад 2
        int[] nums2 = {1, 5, 9, 1, 5, 9};
        int indexDiff2 = 2, valueDiff2 = 3;
        System.out.println("Result (Example 2): " + solution.containsNearbyAlmostDuplicate(nums2, indexDiff2, valueDiff2)); // Вихід: false
    }
}

