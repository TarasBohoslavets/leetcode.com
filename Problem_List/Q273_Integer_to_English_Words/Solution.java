package Problem_List.Q273_Integer_to_English_Words;

class Solution {
    // Масив для чисел менше 20
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    // Масив для десятків
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        // Якщо число дорівнює 0, повертаємо "Zero"
        if (num == 0) {
            return "Zero";
        }
        // Викликаємо допоміжний метод для побудови текстового представлення числа
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();

        // Числа менше 20
        if (num < 20) {
            result.append(belowTwenty[num]);
        }
        // Числа від 20 до 99
        else if (num < 100) {
            result.append(tens[num / 10]) // Додаємо десятки
                    .append(" ")
                    .append(belowTwenty[num % 10]); // Додаємо одиниці
        }
        // Числа від 100 до 999
        else if (num < 1000) {
            result.append(helper(num / 100)) // Обчислюємо сотні
                    .append(" Hundred ")
                    .append(helper(num % 100)); // Обчислюємо залишок
        }
        // Числа від 1000 до 999,999
        else if (num < 1000000) {
            result.append(helper(num / 1000)) // Обчислюємо тисячі
                    .append(" Thousand ")
                    .append(helper(num % 1000)); // Обчислюємо залишок
        }
        // Числа від 1,000,000 до 999,999,999
        else if (num < 1000000000) {
            result.append(helper(num / 1000000)) // Обчислюємо мільйони
                    .append(" Million ")
                    .append(helper(num % 1000000)); // Обчислюємо залишок
        }
        // Числа від 1,000,000,000 до 2,147,483,647 (максимальне значення int)
        else {
            result.append(helper(num / 1000000000)) // Обчислюємо мільярди
                    .append(" Billion ")
                    .append(helper(num % 1000000000)); // Обчислюємо залишок
        }
        // Повертаємо результат без зайвих пробілів
        return result.toString().trim();
    }
}

