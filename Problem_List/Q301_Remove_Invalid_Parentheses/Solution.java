package Problem_List.Q301_Remove_Invalid_Parentheses;

import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        // Використовується черга для BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // Для унікальних варіантів
        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                if (found) continue;

                // Генеруємо нові рядки, видаляючи одну дужку
                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) != '(' && current.charAt(j) != ')') continue;

                    String next = current.substring(0, j) + current.substring(j + 1);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            // Якщо знайдено перший рівень з валідними рядками, завершуємо
            if (found) break;
        }

        return result;
    }

    // Перевірка чи є рядок валідним
    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        String s1 = "()())()";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.removeInvalidParentheses(s1));

        // Приклад 2
        String s2 = "(a)())()";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + solution.removeInvalidParentheses(s2));

        // Приклад 3
        String s3 = ")(";
        System.out.println("\nInput: " + s3);
        System.out.println("Output: " + solution.removeInvalidParentheses(s3));
    }
}

