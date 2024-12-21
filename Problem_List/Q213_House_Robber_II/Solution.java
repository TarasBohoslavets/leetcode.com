package Problem_List.Q213_House_Robber_II;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Якщо лише один будинок
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    // Метод для знаходження максимальної суми в межах діапазону [start, end]
    private int robRange(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]); // Максимум між "не грабувати" і "грабувати"
            prev2 = prev1; // Оновлюємо попередні значення
            prev1 = current;
        }
        return prev1; // Максимальна сума для цього діапазону
    }
}

