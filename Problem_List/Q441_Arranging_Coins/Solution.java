package Problem_List.Q441_Arranging_Coins;

class Solution {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;

        // Використовуємо бінарний пошук для знаходження максимальної кількості повних рівнів
        while (left <= right) {
            long mid = left + (right - left) / 2;

            // Обчислюємо кількість монет, які потрібні для побудови mid повних рівнів
            long coinsUsed = mid * (mid + 1) / 2;

            if (coinsUsed == n) {
                // Точно знайшли кількість рівнів
                return (int) mid;
            } else if (coinsUsed < n) {
                // Можна ще добудувати — рухаємось правіше
                left = mid + 1;
            } else {
                // Забагато монет — рухаємось лівіше
                right = mid - 1;
            }
        }

        // right — останнє значення, яке задовольняє умову coinsUsed <= n
        return (int) right;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testCases = {5, 8, 1, 15, 0, 3, 6, 10};
        for (int n : testCases) {
            int result = solution.arrangeCoins(n);
            System.out.println("n = " + n + " → Повні ряди: " + result);
        }
    }
}
