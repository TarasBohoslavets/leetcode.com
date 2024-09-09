package Problem_List.Q65_Valid_Number;

public class Solution {
    public boolean isNumber(String s) {
        // Регулярний вираз для перевірки валідного числа
        String regex = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)([eE][+-]?\\d+)?$";
        return s.matches(regex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        String s1 = "0";
        boolean result1 = solution.isNumber(s1);
        System.out.println("Input: " + s1 + "\nOutput: " + result1); // true

        // Example 2:
        String s2 = "e";
        boolean result2 = solution.isNumber(s2);
        System.out.println("Input: " + s2 + "\nOutput: " + result2); // false

        // Example 3:
        String s3 = ".";
        boolean result3 = solution.isNumber(s3);
        System.out.println("Input: " + s3 + "\nOutput: " + result3); // false
    }
}
