package Problem_List.Q316_Remove_Duplicate_Letters;

import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // Зберігає останній індекс кожного символу
        boolean[] inStack = new boolean[26]; // Перевіряє, чи символ вже у стеку
        Stack<Character> stack = new Stack<>(); // Використовується для збереження унікальних символів у правильному порядку

        // 1️⃣ Заповнюємо lastIndex останніми позиціями появи символів
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // 2️⃣ Обробляємо кожен символ у строці
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Пропускаємо символ, якщо він вже є у стеку
            if (inStack[c - 'a']) continue;

            // 3️⃣ Видаляємо символи зі стеку, які:
            //    - Більші за поточний `c`
            //    - Зустрічаються пізніше у строці
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                inStack[stack.pop() - 'a'] = false; // Позначаємо, що символ видалений
            }

            // 4️⃣ Додаємо `c` у стек та позначаємо, що він там є
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // 5️⃣ Побудова рядка з символів у стеку
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString(); // Реверсуємо стек для отримання правильного порядку
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.removeDuplicateLetters("bcabc")); // "abc"
        System.out.println(solution.removeDuplicateLetters("cbacdcbc")); // "acdb"
        System.out.println(solution.removeDuplicateLetters("abacb")); // "abc"
        System.out.println(solution.removeDuplicateLetters("zxyxyz")); // "xyz"
    }
}

