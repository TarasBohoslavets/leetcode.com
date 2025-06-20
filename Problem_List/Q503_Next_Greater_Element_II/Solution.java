package Problem_List.Q503_Next_Greater_Element_II;

import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Заповнюємо результат -1 за замовчуванням
        java.util.Arrays.fill(res, -1);

        // Проходимо масив двічі, щоб врахувати циклічність
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            // Знаходимо всі елементи в стеку, менші за поточний
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }

            // Тільки перша половина додає індекси в стек
            if (i < n) stack.push(i);
        }

        return res;
    }
}

