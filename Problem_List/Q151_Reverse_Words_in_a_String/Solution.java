package Problem_List.Q151_Reverse_Words_in_a_String;

class Solution {
    public String reverseWords(String s) {
        // Розбиваємо рядок на масив слів
        String[] words = s.trim().split("\\s+");

        // Використовуємо StringBuilder для об'єднання слів у зворотному порядку
        StringBuilder reversed = new StringBuilder();

        // Проходимо через масив слів у зворотному порядку
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        // Повертаємо результат у вигляді рядка
        return reversed.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклади для перевірки
        System.out.println("Example 1 Output: " + solution.reverseWords("the sky is blue")); // Очікуваний результат: "blue is sky the"
        System.out.println("Example 2 Output: " + solution.reverseWords("  hello world  ")); // Очікуваний результат: "world hello"
        System.out.println("Example 3 Output: " + solution.reverseWords("a good   example")); // Очікуваний результат: "example good a"
    }
}

