package Problem_List.Q224_Basic_Calculator;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0; // Поточний результат
        int sign = 1;   // Поточний знак (1 для '+', -1 для '-')
        int num = 0;    // Поточне число

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Формуємо число
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                // Додаємо число до результату із поточним знаком
                result += sign * num;
                num = 0;
                sign = 1; // Змінюємо знак на додавання
            } else if (c == '-') {
                // Додаємо число до результату із поточним знаком
                result += sign * num;
                num = 0;
                sign = -1; // Змінюємо знак на віднімання
            } else if (c == '(') {
                // Зберігаємо поточний результат і знак у стек
                stack.push(result);
                stack.push(sign);
                // Скидаємо результат і знак для обчислень у дужках
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Додаємо останнє число до результату
                result += sign * num;
                num = 0;
                // Виймаємо зі стеку знак і результат до дужок
                result *= stack.pop(); // Множимо на попередній знак
                result += stack.pop(); // Додаємо попередній результат
            }
        }

        // Додаємо залишок числа після проходу рядка
        result += sign * num;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.calculate("1 + 1")); // Вивід: 2
        System.out.println(solution.calculate(" 2-1 + 2 ")); // Вивід: 3
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)")); // Вивід: 23
        System.out.println(solution.calculate("10 - (2 + 3) + 5")); // Вивід: 10
    }
}

