package Problem_List.Q241_Different_Ways_to_Add_Parentheses;

import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
//        // Кеш для уникнення повторних обчислень
//        Map<String, List<Integer>> memo = new HashMap<>();
//        return helper(expression, memo);
//    }
//
//    private List<Integer> helper(String expression, Map<String, List<Integer>> memo) {
//        // Якщо результат для цього виразу вже обчислено
//        if (memo.containsKey(expression)) {
//            return memo.get(expression);
//        }
//
//        List<Integer> results = new ArrayList<>();
//
//        // Перевіряємо кожен символ у виразі
//        for (int i = 0; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//            if (c == '+' || c == '-' || c == '*') {
//                // Розбиваємо вираз на дві частини
//                String left = expression.substring(0, i);
//                String right = expression.substring(i + 1);
//
//                // Рекурсивно обчислюємо результати для обох частин
//                List<Integer> leftResults = helper(left, memo);
//                List<Integer> rightResults = helper(right, memo);
//
//                // Комбінуємо результати
//                for (int leftVal : leftResults) {
//                    for (int rightVal : rightResults) {
//                        if (c == '+') {
//                            results.add(leftVal + rightVal);
//                        } else if (c == '-') {
//                            results.add(leftVal - rightVal);
//                        } else if (c == '*') {
//                            results.add(leftVal * rightVal);
//                        }
//                    }
//                }
//            }
//        }
//
//        // Якщо не знайдено жодного оператора, вираз — це число
//        if (results.isEmpty()) {
//            results.add(Integer.parseInt(expression));
//        }
//
//        // Зберігаємо результат у кеші
//        memo.put(expression, results);
//        return results;
//    }

        List<Integer> res = new ArrayList<>();
        // Перебираємо всі символи у виразі
        for (int i = 0; i < expression.length(); i++) {
            char oper = expression.charAt(i);
            // Перевіряємо, чи є символ оператором
            if (oper == '+' || oper == '-' || oper == '*') {
                // Розділяємо вираз на дві частини
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                // Комбінуємо результати обчислень
                for (int a : s1) {
                    for (int b : s2) {
                        if (oper == '+') res.add(a + b);
                        else if (oper == '-') res.add(a - b);
                        else if (oper == '*') res.add(a * b);
                    }
                }
            }
        }
        // Якщо немає операторів, додаємо числове значення
        if (res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}

