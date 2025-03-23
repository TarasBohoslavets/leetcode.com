package Problem_List.Q396_Rotate_Function;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, F = 0;

        // Обчислюємо F(0) та загальну суму всіх елементів nums
        for (int i = 0; i < n; i++) {
            sum += nums[i];      // Підсумовуємо всі елементи
            F += i * nums[i];    // Обчислюємо початкове значення F(0)
        }

        int maxF = F;  // Ініціалізуємо змінну для збереження максимального значення F(k)

        // Обчислюємо F(k) для k = 1, 2, ..., n-1
        for (int k = 1; k < n; k++) {
            // Формула: F(k) = F(k-1) + sum - n * nums[n - k]
            F = F + sum - n * nums[n - k];
            maxF = Math.max(maxF, F);  // Оновлюємо максимум, якщо знайшли більше значення
        }

        return maxF;  // Повертаємо максимальне знайдене значення
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {4, 3, 2, 6};
        System.out.println("Вхідні дані: [4, 3, 2, 6]");
        System.out.println("Очікуваний результат: 26");
        System.out.println("Отриманий результат: " + solution.maxRotateFunction(nums1));
        System.out.println();

        // Приклад 2
        int[] nums2 = {100};
        System.out.println("Вхідні дані: [100]");
        System.out.println("Очікуваний результат: 0");
        System.out.println("Отриманий результат: " + solution.maxRotateFunction(nums2));
        System.out.println();

        // Приклад 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Вхідні дані: [1, 2, 3, 4, 5]");
        System.out.println("Очікуваний результат: 40");
        System.out.println("Отриманий результат: " + solution.maxRotateFunction(nums3));
        System.out.println();

        // Приклад 4 (від'ємні числа)
        int[] nums4 = {-1, -2, -3, -4, -5};
        System.out.println("Вхідні дані: [-1, -2, -3, -4, -5]");
        System.out.println("Очікуваний результат: -10");
        System.out.println("Отриманий результат: " + solution.maxRotateFunction(nums4));
    }
}

