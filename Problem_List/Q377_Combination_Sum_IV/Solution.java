package Problem_List.Q377_Combination_Sum_IV;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Ініціалізація масиву dp, де dp[i] буде кількістю способів отримати число i
        int[] dp = new int[target + 1];
        dp[0] = 1; // Є один спосіб отримати 0 — не використовувати жодного елемента

        // Для кожного значення від 1 до target
        for (int i = 1; i <= target; i++) {
            // Перевіряємо всі числа з масиву nums
            for (int num : nums) {
                // Якщо поточне значення можна отримати, додаємо відповідну кількість способів
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        // Повертаємо кількість способів отримати target
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println(solution.combinationSum4(nums1, target1)); // Виведе 7

        // Приклад 2
        int[] nums2 = {9};
        int target2 = 3;
        System.out.println(solution.combinationSum4(nums2, target2)); // Виведе 0
    }
}
