package Problem_List.Q22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Якщо довжина поточного рядка дорівнює подвоєному значенню max, додаємо його до результату
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Якщо кількість відкритих дужок менша за max, додаємо відкриту дужку
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        // Якщо кількість закритих дужок менша за відкриті, додаємо закриту дужку
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1: n = 3
        List<String> result1 = solution.generateParenthesis(3);
        System.out.println(result1);  // Очікуваний результат: ["((()))","(()())","(())()","()(())","()()()"]

        // Приклад 2: n = 1
        List<String> result2 = solution.generateParenthesis(1);
        System.out.println(result2);  // Очікуваний результат: ["()"]
    }
}
