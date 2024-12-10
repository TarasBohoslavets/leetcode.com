package Problem_List.Q198_House_Robber;

class Solution {
    public int rob(int[] nums) {
        // Якщо немає будинків, повертай 0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Якщо лише один будинок, то грабуй його
        if (nums.length == 1) {
            return nums[0];
        }

        // Ініціалізуємо дві змінні для оптимізації пам'яті
        int prev1 = 0; // dp[i-1]: максимальна сума до попереднього будинку
        int prev2 = 0; // dp[i-2]: максимальна сума до будинку через один

        // Проходимо через усі будинки
        for (int num : nums) {
            int temp = prev1; // Зберігаємо попереднє значення dp[i-1]
            // Обираємо між:
            // - залишити поточний будинок (prev1)
            // - взяти гроші з цього будинку + сума до будинку через один (num + prev2)
            prev1 = Math.max(prev1, num + prev2);
            // Оновлюємо dp[i-2] для наступної ітерації
            prev2 = temp;
        }

        // Повертаємо максимальну суму
        return prev1;
    }

    // Приклади використання
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Приклад 1: " + solution.rob(nums1)); // Виведе: 4

        // Приклад 2
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Приклад 2: " + solution.rob(nums2)); // Виведе: 12

        // Приклад 3
        int[] nums3 = {2};
        System.out.println("Приклад 3: " + solution.rob(nums3)); // Виведе: 2
    }
}
