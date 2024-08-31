package Problem_List.Q55_Jump_Game;

public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // Якщо поточна позиція більша за максимальне досягнення, ми не можемо далі йти
            if (i > maxReach) {
                return false;
            }
            // Оновлюємо максимальне досягнення
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true; // Якщо дійшли до кінця циклу, значить ми можемо досягти останнього індексу
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Input: " + java.util.Arrays.toString(nums1));
        System.out.println("Output: " + solution.canJump(nums1));
        // Очікуваний вихід: true

        // Приклад 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Input: " + java.util.Arrays.toString(nums2));
        System.out.println("Output: " + solution.canJump(nums2));
        // Очікуваний вихід: false
    }
}

