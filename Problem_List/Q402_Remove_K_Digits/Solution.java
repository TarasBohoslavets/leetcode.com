package Problem_List.Q402_Remove_K_Digits;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0"; // Якщо видаляємо всі цифри

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Якщо залишилося видалити ще `k` цифр
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Формуємо результат
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        // Видаляємо провідні нулі
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3)); // "1219"
        System.out.println(solution.removeKdigits("10200", 1));   // "200"
        System.out.println(solution.removeKdigits("10", 2));      // "0"
    }
}

