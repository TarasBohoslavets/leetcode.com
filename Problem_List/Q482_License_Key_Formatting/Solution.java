package Problem_List.Q482_License_Key_Formatting;

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Видаляємо всі тире та перетворюємо літери на великі
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }

        // Отримуємо довжину очищеного рядка
        int len = sb.length();
        // Створюємо новий StringBuilder для результату
        StringBuilder result = new StringBuilder();

        // Ідемо з кінця і додаємо символи по k, вставляючи тире
        int firstGroupLen = len % k;
        int i = 0;

        // Додаємо першу групу, яка може бути коротшою
        if (firstGroupLen != 0) {
            result.append(sb.substring(0, firstGroupLen));
            i = firstGroupLen;
            if (i < len) result.append("-");
        }

        // Додаємо решту груп по k символів
        while (i < len) {
            result.append(sb.substring(i, i + k));
            i += k;
            if (i < len) result.append("-");
        }

        return result.toString();
    }
}

