package Problem_List.Q90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Сортуємо масив для полегшення пропуску дублікатів
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Додаємо поточний стан tempList до результату

        for (int i = start; i < nums.length; i++) {
            // Пропускаємо дублікат, якщо він такий самий як попередній елемент (але після першого запуску циклу)
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]); // Додаємо поточний елемент до тимчасового списку
            backtrack(result, tempList, nums, i + 1); // Рекурсивно викликаємо для наступних елементів
            tempList.remove(tempList.size() - 1); // Видаляємо останній елемент перед поверненням до попереднього рівня
        }
    }
}
