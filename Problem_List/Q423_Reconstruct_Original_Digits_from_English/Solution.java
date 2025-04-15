package Problem_List.Q423_Reconstruct_Original_Digits_from_English;

class Solution {
    public String originalDigits(String s) {
        // Рахуємо кількість кожної букви
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Масив для зберігання кількості кожної цифри
        int[] digitCount = new int[10];

        // Унікальні символи для певних цифр
        digitCount[0] = count['z' - 'a']; // zero
        digitCount[2] = count['w' - 'a']; // two
        digitCount[4] = count['u' - 'a']; // four
        digitCount[6] = count['x' - 'a']; // six
        digitCount[8] = count['g' - 'a']; // eight

        // Інші цифри, враховуючи вже знайдені
        digitCount[1] = count['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4];
        digitCount[3] = count['h' - 'a'] - digitCount[8];
        digitCount[5] = count['f' - 'a'] - digitCount[4];
        digitCount[7] = count['s' - 'a'] - digitCount[6];
        digitCount[9] = count['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8];

        // Побудова результату
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            while (digitCount[i]-- > 0) {
                result.append(i);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Відновлені цифри з 'owoztneoer': " + solution.originalDigits("owoztneoer")); // 012
        System.out.println("Відновлені цифри з 'fviefuro': " + solution.originalDigits("fviefuro"));     // 45
    }
}
