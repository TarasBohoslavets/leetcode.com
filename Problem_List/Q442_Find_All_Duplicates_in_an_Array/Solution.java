package Problem_List.Q442_Find_All_Duplicates_in_an_Array;

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  // Індекси від 0 до n-1

            // Якщо вже було відзначено як від'ємне — число вже зустрічалось
            if (nums[index] < 0) {
                result.add(index + 1);  // Додаємо оригінальне число
            } else {
                nums[index] = -nums[index];  // Позначаємо як побачене
            }
        }

        return result;
    }
}
