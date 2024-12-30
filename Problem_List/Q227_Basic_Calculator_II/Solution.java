package Problem_List.Q227_Basic_Calculator_II;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // Поточний знак, початково '+'
        s = s.replaceAll(" ", ""); // Видалення пробілів для простоти

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Якщо це цифра, будуємо число
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // Якщо це оператор або останній символ
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c; // Оновлення знака
                num = 0; // Скидання числа
            }
        }

        // Обчислюємо фінальний результат
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.calculate("3+2*2")); // Вивід: 7
        System.out.println(solution.calculate(" 3/2 ")); // Вивід: 1
        System.out.println(solution.calculate(" 3+5 / 2 ")); // Вивід: 5
    }
}

