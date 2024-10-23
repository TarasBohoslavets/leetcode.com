package Problem_List.Q123_Best_Time_to_Buy_and_Sell_Stock_III;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Якщо масив порожній, повертаємо 0, оскільки немає можливості торгувати
        if (n == 0) return 0;

        // Масив для збереження максимального прибутку зліва направо (від початку до i-го дня)
        int[] leftProfit = new int[n];

        // Масив для збереження максимального прибутку справа наліво (від i-го дня до кінця)
        int[] rightProfit = new int[n];

        // Мінімальна ціна для покупки до i-го дня
        int minPrice = prices[0];
        // Прохід зліва направо для обчислення максимального прибутку від першої транзакції
        for (int i = 1; i < n; i++) {
            // Оновлюємо мінімальну ціну до поточного дня
            minPrice = Math.min(minPrice, prices[i]);
            // Оновлюємо максимальний прибуток на поточний день
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Максимальна ціна для продажу від i-го дня до кінця
        int maxPrice = prices[n - 1];
        // Прохід справа наліво для обчислення максимального прибутку від другої транзакції
        for (int i = n - 2; i >= 0; i--) {
            // Оновлюємо максимальну ціну до кінця
            maxPrice = Math.max(maxPrice, prices[i]);
            // Оновлюємо максимальний прибуток на поточний день
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Пошук загального максимального прибутку
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            // Об'єднуємо прибутки зліва направо та справа наліво
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        // Повертаємо максимальний можливий прибуток
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Приклад 1:
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Максимальний прибуток (Приклад 1): " + sol.maxProfit(prices1));
        // Виведе: 6 (Купівля на 4-й день, продаж на 6-й день, прибуток = 3. Купівля на 7-й день, продаж на 8-й день, прибуток = 3)

        // Приклад 2:
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Максимальний прибуток (Приклад 2): " + sol.maxProfit(prices2));
        // Виведе: 4 (Купівля на 1-й день, продаж на 5-й день)

        // Приклад 3:
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Максимальний прибуток (Приклад 3): " + sol.maxProfit(prices3));
        // Виведе: 0 (Немає можливості отримати прибуток)
    }
}
