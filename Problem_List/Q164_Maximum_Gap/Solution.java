package Problem_List.Q164_Maximum_Gap;

import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0; // Якщо масив має менше 2 елементів, різниця дорівнює 0
        }

        // Знаходимо мінімальне та максимальне значення
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0; // Усі числа однакові, різниця дорівнює 0
        }

        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1)); // Розмір кошика
        int bucketCount = (max - min) / bucketSize + 1; // Кількість кошиків

        // Ініціалізуємо кошики
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Розподіляємо елементи по кошиках
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }

        // Знаходимо максимальний розрив
        int maxGap = 0;
        int prevMax = min; // Починаємо з мінімального значення

        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue; // Пропускаємо порожні кошики
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {3, 6, 9, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.maximumGap(nums1)); // Очікується: 3

        // Приклад 2
        int[] nums2 = {10};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.maximumGap(nums2)); // Очікується: 0
    }
}

