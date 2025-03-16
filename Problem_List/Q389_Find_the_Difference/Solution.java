package Problem_List.Q389_Find_the_Difference;

public class Solution {
    public char findTheDifference(String s, String t) {
        int charCode = 0;

        // Додаємо всі символи з t і віднімаємо всі символи з s
        for (char c : t.toCharArray()) {
            charCode += c;
        }

        for (char c : s.toCharArray()) {
            charCode -= c;
        }

        return (char) charCode; // Залишається лише зайвий символ
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde")); // Очікуваний вивід: 'e'
        System.out.println(solution.findTheDifference("", "y")); // Очікуваний вивід: 'y'
    }
}

