package Problem_List.Q34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                firstPosition = mid;
                right = mid - 1; // Продовжуємо пошук на лівій половині
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstPosition;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastPosition = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lastPosition = mid;
                left = mid + 1; // Продовжуємо пошук на правій половині
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastPosition;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Приклади тестів
        int[] nums1 = {5,7,7,8,8,10};
        int target1 = 8;
        System.out.println(Arrays.toString(sol.searchRange(nums1, target1)));  // Виведе [3, 4]

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        System.out.println(Arrays.toString(sol.searchRange(nums2, target2)));  // Виведе [-1, -1]

        int[] nums3 = {};
        int target3 = 0;
        System.out.println(Arrays.toString(sol.searchRange(nums3, target3)));  // Виведе [-1, -1]
    }
}

