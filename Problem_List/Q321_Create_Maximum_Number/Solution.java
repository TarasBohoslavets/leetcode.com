package Problem_List.Q321_Create_Maximum_Number;

import java.util.Arrays;

public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        // Перебираємо всі можливі розбиття: i елементів з nums1 і k-i з nums2.
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);
        for (int i = start; i <= end; i++) {
            int[] subseq1 = maxSubsequence(nums1, i);
            int[] subseq2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(subseq1, subseq2, k);
            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }
        return best;
    }

    // Знаходить найбільшу підпослідовність довжини k
    private int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] stack = new int[k];
        int top = -1;          // Вказівник стека
        int drop = n - k;      // Скільки елементів можна відкинути
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k - 1) { // Якщо місце ще є, додаємо елемент
                stack[++top] = num;
            } else {
                drop--;
            }
        }
        return stack;
    }

    // Об'єднує дві підпослідовності в одну максимальну послідовність довжини k
    private int[] merge(int[] subseq1, int[] subseq2, int k) {
        int[] merged = new int[k];
        int i = 0, j = 0, r = 0;
        while (i < subseq1.length || j < subseq2.length) {
            if (greater(subseq1, i, subseq2, j)) {
                merged[r++] = subseq1[i++];
            } else {
                merged[r++] = subseq2[j++];
            }
        }
        return merged;
    }

    // Порівнює дві підпослідовності: чи є nums1 (починаючи з i) більше, ніж nums2 (починаючи з j)
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        int x = nums1.length, y = nums2.length;
        while (i < x && j < y && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        if (j == y) return true; // nums1 залишився довшим => більший
        if (i < x && nums1[i] > nums2[j]) return true; // nums1 має більше число
        return false;
    }

    // Метод main для тестування
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        System.out.println(Arrays.toString(sol.maxNumber(nums1, nums2, k))); // Очікуваний результат: [9, 8, 6, 5, 3]

        int[] nums3 = {6, 7};
        int[] nums4 = {6, 0, 4};
        k = 5;
        System.out.println(Arrays.toString(sol.maxNumber(nums3, nums4, k))); // Очікуваний результат: [6, 7, 6, 0, 4]

        int[] nums5 = {3, 9};
        int[] nums6 = {8, 9};
        k = 3;
        System.out.println(Arrays.toString(sol.maxNumber(nums5, nums6, k))); // Очікуваний результат: [9, 8, 9]
    }
}
