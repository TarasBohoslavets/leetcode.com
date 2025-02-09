package Problem_List.Q327_Count_of_Range_Sum;

import java.util.Arrays;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]; // Обчислюємо префіксну суму
        }
        return mergeSort(prefixSum, 0, prefixSum.length - 1, lower, upper);
    }

    private int mergeSort(long[] sum, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(sum, left, mid, lower, upper) + mergeSort(sum, mid + 1, right, lower, upper);

        long[] temp = new long[right - left + 1];
        int index = 0, j = mid + 1, k = mid + 1, t = mid + 1;

        // Підраховуємо кількість сум в допустимому діапазоні
        for (int i = left; i <= mid; i++) {
            while (k <= right && sum[k] - sum[i] < lower) k++;
            while (j <= right && sum[j] - sum[i] <= upper) j++;
            count += j - k;

            // Виконуємо злиття двох відсортованих частин
            while (t <= right && sum[t] < sum[i]) temp[index++] = sum[t++];
            temp[index++] = sum[i];
        }

        // Додаємо залишок елементів
        while (t <= right) temp[index++] = sum[t++];
        System.arraycopy(temp, 0, sum, left, temp.length);

        return count;
    }

    // Метод main для тестування
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {-2, 5, -1};
        System.out.println(sol.countRangeSum(nums1, -2, 2)); // Вихід: 3

        int[] nums2 = {0};
        System.out.println(sol.countRangeSum(nums2, 0, 0)); // Вихід: 1

        int[] nums3 = {1, -1, 2, -2, 3, -3};
        System.out.println(sol.countRangeSum(nums3, -2, 2)); // Вихід: 9
    }
}

