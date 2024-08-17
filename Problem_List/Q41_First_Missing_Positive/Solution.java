package Problem_List.Q41_First_Missing_Positive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Переставляємо елементи на їх "правильні" місця
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Перевіряємо, де порушується порядок
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Якщо всі елементи на своїх місцях, повертаємо n + 1
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 0};
        System.out.println(sol.firstMissingPositive(nums1)); // Виведе 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(sol.firstMissingPositive(nums2)); // Виведе 2

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(sol.firstMissingPositive(nums3)); // Виведе 1
    }
}
