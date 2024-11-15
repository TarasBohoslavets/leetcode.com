package Problem_List.Q152_Maximum_Product_Subarray;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Перевірка на порожній масив
        }

        // Ініціалізація змінних
        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        // Проходимо через масив, починаючи з другого елемента
        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;

            // Оновлення поточного максимального і мінімального значень
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            // Оновлення глобального максимального добутку
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклади для перевірки
        int[] example1 = {2, 3, -2, 4};
        System.out.println("Example 1 Output: " + solution.maxProduct(example1)); // Очікуваний результат: 6

        int[] example2 = {-2, 0, -1};
        System.out.println("Example 2 Output: " + solution.maxProduct(example2)); // Очікуваний результат: 0

        int[] example3 = {-2, 3, -4};
        System.out.println("Example 3 Output: " + solution.maxProduct(example3)); // Очікуваний результат: 24
    }
}

