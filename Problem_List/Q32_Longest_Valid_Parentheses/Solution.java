package Problem_List.Q32_Longest_Valid_Parentheses;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Ініціалізуємо стек з -1 для коректного підрахунку довжини.
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);  // Додаємо індекс відкритої дужки.
            } else {
                stack.pop();  // Вилучаємо верхній елемент зі стеку.
                if (stack.isEmpty()) {
                    stack.push(i);  // Якщо стек порожній, додаємо поточний індекс.
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("(()"));        // Виведе 2
        System.out.println(sol.longestValidParentheses(")()())"));     // Виведе 4
        System.out.println(sol.longestValidParentheses(""));           // Виведе 0
    }
}

