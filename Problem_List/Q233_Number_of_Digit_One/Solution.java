package Problem_List.Q233_Number_of_Digit_One;

class Solution {
    public int countDigitOne(int n) {
        int count = 0; // Змінна для підрахунку одиниць
        long place = 1; // Розряд (1, 10, 100 і т.д.)

        while (place <= n) {
            long higher = n / (place * 10); // Цифри вище поточного розряду
            long current = (n / place) % 10; // Поточна цифра
            long lower = n % place; // Цифри нижче поточного розряду

            // Додаємо одиниці з вищих розрядів
            count += higher * place;

            // Якщо поточна цифра > 1, додаємо всі одиниці на цьому розряді
            if (current > 1) {
                count += place;
            }
            // Якщо поточна цифра == 1, додаємо одиниці нижчих розрядів + 1
            else if (current == 1) {
                count += lower + 1;
            }

            // Переходимо до наступного розряду
            place *= 10;
        }

        return count;
    }
}

