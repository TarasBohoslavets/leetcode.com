package Problem_List.Q68_Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); // Список для збереження результату
        int index = 0; // Індекс для обходу слів

        // Цикл, який триває, поки не обробимо всі слова
        while (index < words.length) {
            int count = words[index].length(); // Довжина поточного слова
            int last = index + 1; // Індекс наступного слова

            // Додаємо слова до поточного рядка, поки не досягнемо maxWidth
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) break; // Якщо наступне слово не поміщається, виходимо
                count += words[last].length() + 1; // Оновлюємо загальну довжину з урахуванням пробілу
                last++;
            }

            StringBuilder line = new StringBuilder(); // Формуємо поточний рядок
            int numOfWords = last - index; // Кількість слів у рядку

            // Якщо це останній рядок або рядок містить одне слово
            if (last == words.length || numOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]); // Додаємо слово
                    if (i != last - 1) line.append(" "); // Додаємо пробіл після слова
                }
                // Заповнюємо рядок пробілами до maxWidth
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Якщо рядок містить більше одного слова і це не останній рядок
                int spaces = (maxWidth - count) / (numOfWords - 1); // Середня кількість пробілів між словами
                int extraSpaces = (maxWidth - count) % (numOfWords - 1); // Додаткові пробіли для вирівнювання

                // Додаємо слова і розподіляємо пробіли
                for (int i = index; i < last - 1; i++) {
                    line.append(words[i]);
                    line.append(" "); // Основний пробіл між словами
                    // Додаємо додаткові пробіли до лівих слотів
                    for (int j = 0; j < spaces + (i - index < extraSpaces ? 1 : 0); j++) {
                        line.append(" ");
                    }
                }
                line.append(words[last - 1]); // Додаємо останнє слово
            }

            result.add(line.toString()); // Додаємо сформований рядок до результату
            index = last; // Оновлюємо індекс для наступного слова
        }

        return result; // Повертаємо список з вирівняними рядками
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println(solution.fullJustify(words1, maxWidth1));
        // Output: ["This    is    an", "example  of text", "justification.  "]

        // Example 2
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        System.out.println(solution.fullJustify(words2, maxWidth2));
        // Output: ["What   must   be", "acknowledgment  ", "shall be        "]

        // Example 3
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        System.out.println(solution.fullJustify(words3, maxWidth3));
        // Output: ["Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  "]
    }
}

