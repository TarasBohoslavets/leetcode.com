package Problem_List.Q467_Unique_Substrings_in_Wraparound_String;

class Solution {
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.length() == 0) return 0;

        // Масив для зберігання максимальної довжини валідного підрядка,
        // що закінчується на літеру 'a'..'z'
        int[] maxLen = new int[26];

        int currLen = 0; // поточна довжина безперервної послідовності

        for (int i = 0; i < s.length(); i++) {
            // Перевіряємо, чи символ s[i] є наступним у wraparound-алфавіті після s[i - 1]
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                currLen++;
            } else {
                currLen = 1;
            }

            // Індекс символу (від 0 для 'a' до 25 для 'z')
            int index = s.charAt(i) - 'a';

            // Оновлюємо лише якщо поточна довжина більша за вже збережену
            maxLen[index] = Math.max(maxLen[index], currLen);
        }

        // Сума максимальних довжин — це кількість унікальних підрядків
        int result = 0;
        for (int len : maxLen) {
            result += len;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Результат 1: " + sol.findSubstringInWraproundString("a"));      // 1
        System.out.println("Результат 2: " + sol.findSubstringInWraproundString("cac"));    // 2
        System.out.println("Результат 3: " + sol.findSubstringInWraproundString("zab"));    // 6
    }
}

