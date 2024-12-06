package Problem_List.Q167_Two_Sum_II_Input_Array_Is_Sorted;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Ініціалізація двох вказівників
        int left = 0;
        int right = numbers.length - 1;

        // Перебір до знаходження рішення
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            // Якщо сума дорівнює цільовому значенню, повертаємо результат
            if (sum == target) {
                return new int[] {left + 1, right + 1}; // Повертаємо індекси +1, бо індексація 1-орієнтована
            }
            // Якщо сума менша за цільове значення, збільшуємо лівий вказівник
            else if (sum < target) {
                left++;
            }
            // Якщо сума більша за цільове значення, зменшуємо правий вказівник
            else {
                right--;
            }
        }

        // За умовою завжди є рішення, тому цей рядок не виконується
        return new int[] {-1, -1};
    }

    // Основний метод для тестування
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Вхід: " + Arrays.toString(numbers1) + ", target = " + target1);
        System.out.println("Результат: " + Arrays.toString(solution.twoSum(numbers1, target1)));

        // Приклад 2
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        System.out.println("\nВхід: " + Arrays.toString(numbers2) + ", target = " + target2);
        System.out.println("Результат: " + Arrays.toString(solution.twoSum(numbers2, target2)));

        // Приклад 3
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        System.out.println("\nВхід: " + Arrays.toString(numbers3) + ", target = " + target3);
        System.out.println("Результат: " + Arrays.toString(solution.twoSum(numbers3, target3)));
    }
}

