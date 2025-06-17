package Problem_List.Q500_Keyboard_Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        // Створюємо множини для кожного рядка клавіатури
        Set<Character> row1 = Set.of('q','w','e','r','t','y','u','i','o','p');
        Set<Character> row2 = Set.of('a','s','d','f','g','h','j','k','l');
        Set<Character> row3 = Set.of('z','x','c','v','b','n','m');

        List<String> result = new ArrayList<>();

        // Перевіряємо кожне слово
        for (String word : words) {
            String lowerWord = word.toLowerCase(); // Робимо слово нижнім регістром
            Set<Character> currentRow = null;

            // Визначаємо, до якого рядка належить перший символ слова
            if (row1.contains(lowerWord.charAt(0))) {
                currentRow = row1;
            } else if (row2.contains(lowerWord.charAt(0))) {
                currentRow = row2;
            } else {
                currentRow = row3;
            }

            // Перевіряємо, чи всі символи слова знаходяться в одному рядку
            boolean isValid = true;
            for (char c : lowerWord.toCharArray()) {
                if (!currentRow.contains(c)) {
                    isValid = false;
                    break;
                }
            }

            // Якщо слово задовольняє умову, додаємо його в список
            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]); // Перетворюємо список у масив
    }

    public static void main(String[] args) {
        KeyboardRow solver = new KeyboardRow();
        String[] words1 = {"Hello","Alaska","Dad","Peace"};
        System.out.println(java.util.Arrays.toString(solver.findWords(words1))); // ["Alaska", "Dad"]

        String[] words2 = {"omk"};
        System.out.println(java.util.Arrays.toString(solver.findWords(words2))); // []

        String[] words3 = {"adsdf", "sfd"};
        System.out.println(java.util.Arrays.toString(solver.findWords(words3))); // ["adsdf", "sfd"]
    }
}

