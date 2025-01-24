package Problem_List.Q300_Longest_Increasing_Subsequence;

import java.util.*;

public class LongestIncreasingSubsequence {
    // Метод для знаходження довжини найдовшої зростаючої підпослідовності (O(n^2))
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] зберігає довжину найдовшої підпослідовності, яка закінчується на i-му елементі
        Arrays.fill(dp, 1); // Ініціалізуємо всі значення як 1 (мінімальна довжина підпослідовності)

        int maxLength = 1; // Максимальна довжина зростаючої підпослідовності

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Оновлюємо dp[i], якщо знайдено більший елемент
                }
            }
            maxLength = Math.max(maxLength, dp[i]); // Оновлюємо загальну максимальну довжину
        }

        return maxLength;
    }

    // Метод для знаходження довжини найдовшої зростаючої підпослідовності (O(n log n))
    public static int lengthOfLISOptimized(int[] nums) {
        List<Integer> sub = new ArrayList<>(); // Список для побудови зростаючої підпослідовності

        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num); // Пошук позиції для вставки
            if (pos < 0) {
                pos = -(pos + 1); // Якщо елемент не знайдено, перетворюємо позицію
            }
            if (pos == sub.size()) {
                sub.add(num); // Додаємо елемент, якщо він більший за всі елементи в списку
            } else {
                sub.set(pos, num); // Замінюємо елемент, щоб зберегти мінімальний варіант
            }
        }

        return sub.size(); // Розмір списку sub дорівнює довжині найдовшої зростаючої підпослідовності
    }

    public static void main(String[] args) {
        // Приклад 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Example 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + lengthOfLIS(nums1));
        System.out.println("Optimized Output: " + lengthOfLISOptimized(nums1));
        System.out.println("Explanation: Найдовша зростаюча підпослідовність - [2, 3, 7, 101]");

        // Приклад 2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("\nExample 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + lengthOfLIS(nums2));
        System.out.println("Optimized Output: " + lengthOfLISOptimized(nums2));
        System.out.println("Explanation: Найдовша зростаюча підпослідовність - [0, 1, 2, 3]");

        // Приклад 3
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("\nExample 3:");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + lengthOfLIS(nums3));
        System.out.println("Optimized Output: " + lengthOfLISOptimized(nums3));
        System.out.println("Explanation: Найдовша зростаюча підпослідовність - [7]");
    }
}
