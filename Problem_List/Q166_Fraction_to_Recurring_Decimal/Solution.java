package Problem_List.Q166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Якщо чисельник дорівнює 0, результат завжди 0
        if (numerator == 0) {
            return "0";
        }

        // Використовуємо StringBuilder для побудови результату
        StringBuilder result = new StringBuilder();

        // Додаємо мінус, якщо результат від'ємний
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Приводимо чисельник і знаменник до типу long, щоб уникнути переповнення
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Додаємо цілу частину до результату
        result.append(num / denom);

        // Залишок після ділення
        long remainder = num % denom;

        // Якщо залишок 0, повертаємо лише цілу частину
        if (remainder == 0) {
            return result.toString();
        }

        // Додаємо десяткову крапку для дробової частини
        result.append(".");

        // Зберігаємо залишки, щоб знайти повторювану послідовність
        Map<Long, Integer> remainderMap = new HashMap<>();

        // Поки залишок не 0
        while (remainder != 0) {
            // Якщо залишок повторюється, додаємо дужки
            if (remainderMap.containsKey(remainder)) {
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }

            // Запам'ятовуємо позицію поточного залишку
            remainderMap.put(remainder, result.length());

            // Множимо залишок на 10 і додаємо наступну цифру до дробової частини
            remainder *= 10;
            result.append(remainder / denom);

            // Оновлюємо залишок
            remainder %= denom;
        }

        return result.toString();
    }

    // Основний метод для перевірки
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int numerator = 1, denominator = 2;
        System.out.println("Вхід: чисельник = " + numerator + ", знаменник = " + denominator);
        System.out.println("Результат: " + solution.fractionToDecimal(numerator, denominator));

        // Приклад 2
        numerator = 2;
        denominator = 1;
        System.out.println("\nВхід: чисельник = " + numerator + ", знаменник = " + denominator);
        System.out.println("Результат: " + solution.fractionToDecimal(numerator, denominator));

        // Приклад 3
        numerator = 4;
        denominator = 333;
        System.out.println("\nВхід: чисельник = " + numerator + ", знаменник = " + denominator);
        System.out.println("Результат: " + solution.fractionToDecimal(numerator, denominator));

        // Приклад 4
        numerator = 1;
        denominator = 6;
        System.out.println("\nВхід: чисельник = " + numerator + ", знаменник = " + denominator);
        System.out.println("Результат: " + solution.fractionToDecimal(numerator, denominator));
    }
}
