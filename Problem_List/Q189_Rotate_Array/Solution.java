package Problem_List.Q189_Rotate_Array;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        // Якщо k більше за довжину масиву, зменшуємо його модулем
        k = k % nums.length;
        if (k == 0) return; // Якщо k = 0, нічого не треба робити

        // Перевертаємо весь масив
        reverse(nums, 0, nums.length - 1);

        // Перевертаємо перші k елементів
        reverse(nums, 0, k - 1);

        // Перевертаємо залишок
        reverse(nums, k, nums.length - 1);
    }

    // Метод для перевертання частини масиву
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Обмін елементів місцями
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Основний метод для тестування
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Вхід: " + Arrays.toString(nums1) + ", k = " + k1);
        solution.rotate(nums1, k1);
        System.out.println("Результат: " + Arrays.toString(nums1));

        // Приклад 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("\nВхід: " + Arrays.toString(nums2) + ", k = " + k2);
        solution.rotate(nums2, k2);
        System.out.println("Результат: " + Arrays.toString(nums2));
    }
}

