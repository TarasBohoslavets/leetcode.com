package Problem_List.Q33_Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Якщо знайдено елемент
            if (nums[mid] == target) {
                return mid;
            }

            // Перевіряємо, чи ліва частина відсортована
            if (nums[left] <= nums[mid]) {
                // Якщо таргет в межах відсортованої частини
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Якщо права частина відсортована
            else {
                // Якщо таргет в межах відсортованої частини
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; // Якщо таргет не знайдено
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Приклади тестів
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(sol.search(nums1, target1));  // Виведе 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(sol.search(nums2, target2));  // Виведе -1

        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(sol.search(nums3, target3));  // Виведе -1
    }
}

