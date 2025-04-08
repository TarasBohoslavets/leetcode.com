package Problem_List.Q414_Third_Maximum_Number;

import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);  // Сортуємо масив по зростанню

        int largest = 1; // Починаємо з 1, бо nums[nums.length - 1] — це найбільше

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                largest++; // Знайшли нове унікальне значення

                if (largest == 3) {
                    return nums[i - 1]; // Третє найбільше
                }
            }
        }

// Якщо не знайшли третього унікального, повертаємо найбільше
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.thirdMax(new int[]{3, 2, 1}));       // 1
        System.out.println(sol.thirdMax(new int[]{1, 2}));          // 2
        System.out.println(sol.thirdMax(new int[]{2, 2, 3, 1}));    // 1
        System.out.println(sol.thirdMax(new int[]{1, 2, 2, 5, 3, 5})); // 2
    }
}
