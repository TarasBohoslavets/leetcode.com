package Problem_List.Q29_Divide_Two_Integers;

class Solution {
    public int divide(int dividend, int divisor) {
        // Обробка спеціальних випадків
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Переповнення
        }

        // Визначаємо знак результату
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Приведення до додатних значень
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Використовуємо бітові операції для поділу
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            absDividend -= temp;
            result += multiple;
        }

        return isNegative ? -result : result;
    }
}