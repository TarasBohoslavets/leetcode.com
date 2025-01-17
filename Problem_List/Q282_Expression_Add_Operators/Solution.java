package Problem_List.Q282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target, int index, long currentValue, long prevOperand, String expression) {
        // Якщо дійшли до кінця рядка
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        // Перебір кожного можливого операнда
        for (int i = index; i < num.length(); i++) {
            // Пропускаємо числа з ведучими нулями
            if (i > index && num.charAt(index) == '0') break;

            // Поточне число
            long currentNum = Long.parseLong(num.substring(index, i + 1));

            // Якщо це перший операнд
            if (index == 0) {
                backtrack(result, num, target, i + 1, currentNum, currentNum, expression + currentNum);
            } else {
                // Додавання
                backtrack(result, num, target, i + 1, currentValue + currentNum, currentNum, expression + "+" + currentNum);
                // Віднімання
                backtrack(result, num, target, i + 1, currentValue - currentNum, -currentNum, expression + "-" + currentNum);
                // Множення
                backtrack(result, num, target, i + 1, currentValue - prevOperand + prevOperand * currentNum, prevOperand * currentNum, expression + "*" + currentNum);
            }
        }
    }
}

