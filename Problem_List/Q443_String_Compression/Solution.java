package Problem_List.Q443_String_Compression;

import java.util.Arrays;

class Solution {
    public int compress(char[] chars) {
        int write = 0; // індекс для запису стисненого результату
        int read = 0;  // індекс для проходу по масиву

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // рахуємо кількість однакових символів підряд
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // записуємо символ
            chars[write++] = currentChar;

            // якщо count > 1, записуємо цифри по одній
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] ex1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len1 = sol.compress(ex1);
        System.out.println(len1 + " -> " + Arrays.toString(Arrays.copyOf(ex1, len1))); // [a, 2, b, 2, c, 3]

        char[] ex2 = {'a'};
        int len2 = sol.compress(ex2);
        System.out.println(len2 + " -> " + Arrays.toString(Arrays.copyOf(ex2, len2))); // [a]

        char[] ex3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len3 = sol.compress(ex3);
        System.out.println(len3 + " -> " + Arrays.toString(Arrays.copyOf(ex3, len3))); // [a, b, 1, 2]
    }
}

