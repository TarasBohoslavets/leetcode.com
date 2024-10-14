package Problem_List.Q1_Two_Sum;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order
* */

import java.util.HashMap;

public class Two_Sum {
    static class Solution {
        public int[] twoSum ( int[] nums, int target ) {
            // Створюємо хеш-таблицю для зберігання чисел і їх індексів
            HashMap<Integer, Integer> map = new HashMap<> ( );

            // Проходимо по масиву
            for (int i = 0; i < nums.length; i++) {
                // Обчислюємо різницю між цільовим числом і поточним числом
                int complement = target - nums[i];
                // Якщо різниця вже є в хеш-таблиці, це означає, що ми знайшли пару чисел
                if ( map.containsKey ( complement ) ) {
                    // Повертаємо індекси знайдених чисел
                    return new int[]{map.get ( complement ), i};
                }
                // Додаємо поточне число і його індекс в хеш-таблицю
                map.put ( nums[i], i );
            }
            // Якщо рішення не знайдено, повертаємо пустий масив
            return new int[0];
        }
    }
    public static void main(String[] args) {
        // Створюємо об'єкт класу Solution
        Solution solution = new Solution();

        // Тестові дані
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Example 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Example 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Example 3: [" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {10, 2, 9, 7, 11, 15};
        int target4 = 13;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Example 4: [" + result4[0] + ", " + result4[1] + "]");

    }
}