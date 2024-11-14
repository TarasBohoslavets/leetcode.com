package Problem_List.Q150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

/*
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;

        // Проходимо через всі елементи масиву
        for (int i = 0; i < tokens.length; i++) {
            // Якщо зустрічаємо оператор, виконуємо відповідну операцію
            if (tokens[i].equals("+")) {
                temp = stack.pop();
                temp = temp + stack.pop();
                stack.push(temp);
            } else if (tokens[i].equals("-")) {
                temp = stack.pop();
                temp = stack.pop() - temp;
                stack.push(temp);
            } else if (tokens[i].equals("*")) {
                temp = stack.pop();
                temp = temp * stack.pop();
                stack.push(temp);
            } else if (tokens[i].equals("/")) {
                temp = stack.pop();
                temp = stack.pop() / temp;
                stack.push(temp);
            } else {
                // Якщо поточний елемент - число, додаємо його в стек
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        // Повертаємо результат з вершини стеку
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклади для перевірки
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Example 1 Output: " + solution.evalRPN(tokens1)); // Очікуваний результат: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Example 2 Output: " + solution.evalRPN(tokens2)); // Очікуваний результат: 6

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Example 3 Output: " + solution.evalRPN(tokens3)); // Очікуваний результат: 22
    }
}

