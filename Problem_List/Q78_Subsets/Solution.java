package Problem_List.Q78_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Створюємо список для збереження всіх підмножин
        List<List<Integer>> result = new ArrayList<>();
        // Викликаємо рекурсивну функцію для генерації підмножин
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    // Рекурсивна функція для генерації всіх можливих підмножин
    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Додаємо поточну підмножину до результату
        result.add(new ArrayList<>(current));

        // Проходимо всі елементи масиву, починаючи з поточного індексу
        for (int i = index; i < nums.length; i++) {
            // Додаємо поточний елемент до поточної підмножини
            current.add(nums[i]);
            // Рекурсивно обробляємо наступний індекс
            generateSubsets(i + 1, nums, current, result);
            // Видаляємо останній доданий елемент для того, щоб повернутись до попереднього стану
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(sol.subsets(nums)); // Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
    }
}

