package Problem_List.Q394_Decode_String;

import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // формуємо число k
            } else if (ch == '[') {
                countStack.push(k); // зберігаємо кількість повторень
                stringStack.push(currentString); // зберігаємо поточний рядок
                currentString = new StringBuilder();
                k = 0; // скидаємо лічильник
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();

                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        System.out.println(decoder.decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(decoder.decodeString("3[a2[c]]")); // "accaccacc"
        System.out.println(decoder.decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
    }
}

