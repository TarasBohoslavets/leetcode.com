package Problem_List.Q400_Nth_Digit;

class Solution {
    public int findNthDigit(int n) {
        long digitLength = 1;  // Довжина числа в цифрах (1 для [1-9], 2 для [10-99], 3 для [100-999], ...)
        long count = 9;  // Кількість чисел у поточному діапазоні (9 однозначних, 90 двозначних, 900 тризначних тощо)
        long start = 1;  // Початкове число поточного діапазону (1, 10, 100, 1000...)

        // Крок 1: Визначаємо розряд, у якому знаходиться n-та цифра
        while (n > digitLength * count) {
            n -= digitLength * count;  // Віднімаємо кількість цифр у поточному діапазоні
            digitLength++;  // Переходимо до наступного діапазону (однозначні → двозначні → ...)
            count *= 10;  // Оновлюємо кількість чисел у цьому діапазоні (9, 90, 900, ...)
            start *= 10;  // Оновлюємо початкове число (1, 10, 100, 1000...)
        }

        // Крок 2: Визначаємо число, у якому знаходиться ця цифра
        long num = start + (n - 1) / digitLength;  // Знаходимо точне число

        // Крок 3: Витягуємо відповідну цифру з числа
        String numStr = Long.toString(num);
        return numStr.charAt((int) ((n - 1) % digitLength)) - '0';  // Конвертуємо символ у число
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int result1 = solution.findNthDigit(n1);
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + result1);

        int n2 = 11;
        int result2 = solution.findNthDigit(n2);
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + result2);
    }
}