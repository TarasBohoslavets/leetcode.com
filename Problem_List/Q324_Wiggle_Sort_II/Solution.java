package Problem_List.Q324_Wiggle_Sort_II;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // Сортуємо масив

        int mid = (n - 1) / 2; // Індекс середини для меншої половини
        int end = n - 1; // Індекс для більшої половини
        int[] result = new int[n];

        // Розміщуємо менші елементи на парних позиціях, а більші — на непарних
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[mid--];
            } else {
                nums[i] = sorted[end--];
            }
        }
    }

    // Метод main для тестування
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 5, 1, 1, 6, 4};
        sol.wiggleSort(nums1);
        System.out.println(Arrays.toString(nums1)); // Можливий вихід: [1,6,1,5,1,4]

        int[] nums2 = {1, 3, 2, 2, 3, 1};
        sol.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2)); // Можливий вихід: [2,3,1,3,1,2]

        int[] nums3 = {4, 5, 5, 6};
        sol.wiggleSort(nums3);
        System.out.println(Arrays.toString(nums3)); // Можливий вихід: [5,6,4,5]
    }
}

