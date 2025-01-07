package Problem_List.Q239_Sliding_Window_Maximum;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Зберігає індекси елементів у вікні

        for (int i = 0; i < n; i++) {
            // Видаляємо елементи, які виходять за межі вікна
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Видаляємо всі елементи, менші за поточний (вони більше не можуть бути максимумами)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Додаємо поточний елемент
            deque.offerLast(i);

            // Додаємо максимум до результату, якщо вікно сформоване
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        System.out.println("Output: " + Arrays.toString(result));
    }
}

