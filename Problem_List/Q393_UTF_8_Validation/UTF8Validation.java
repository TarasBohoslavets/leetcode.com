package Problem_List.Q393_UTF_8_Validation;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int count = 0; // Лічильник байтів, які повинні починатися з '10'

        for (int num : data) {
            if (count == 0) {
                if ((num >> 5) == 0b110) count = 1; // 2-байтний символ
                else if ((num >> 4) == 0b1110) count = 2; // 3-байтний символ
                else if ((num >> 3) == 0b11110) count = 3; // 4-байтний символ
                else if ((num >> 7) != 0) return false; // 1-байтний символ повинен починатися з '0'
            } else {
                if ((num >> 6) != 0b10) return false; // Перевірка продовжувальних байтів
                count--;
            }
        }

        return count == 0; // Маємо закінчити без незавершених багатобайтових символів
    }

    public static void main(String[] args) {
        UTF8Validation validator = new UTF8Validation();

        int[] data1 = {197, 130, 1};
        System.out.println(validator.validUtf8(data1)); // true

        int[] data2 = {235, 140, 4};
        System.out.println(validator.validUtf8(data2)); // false
    }
}
