package Problem_List.Q456_132_Pattern;

import java.util.Stack;

public class Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;

        // Проходимо масив справа наліво
        for (int i = n - 1; i >= 0; i--) {
            // nums[i] — це потенційний nums[i] з шаблону 132
            if (nums[i] < second) {
                return true;
            }

            // Поки стек не порожній і nums[i] > вершини стеку
            // ми знайшли новий кращий second (тобто nums[k])
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }

            // Додаємо nums[i] у стек як потенційний nums[j]
            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Example 1 (Expected: false): " + sol.find132pattern(nums1));

        int[] nums2 = {3, 1, 4, 2};
        System.out.println("Example 2 (Expected: true): " + sol.find132pattern(nums2));

        int[] nums3 = {-1, 3, 2, 0};
        System.out.println("Example 3 (Expected: true): " + sol.find132pattern(nums3));

        int[] nums4 = {1, 0, 1, -4, -3};
        System.out.println("Example 4 (Expected: false): " + sol.find132pattern(nums4));
    }
}

