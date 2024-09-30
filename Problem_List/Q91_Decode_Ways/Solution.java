package Problem_List.Q91_Decode_Ways;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Порожній рядок має 1 спосіб декодування
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // Якщо перший символ не 0, його можна декодувати

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i)); // Одноцифрове декодування
            int twoDigits = Integer.parseInt(s.substring(i - 2, i)); // Двоцифрове декодування

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1]; // Якщо цифра в діапазоні 1-9, додаємо кількість способів
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2]; // Якщо дві цифри в діапазоні 10-26, додаємо кількість способів
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Приклад 1
        String s1 = "12";
        System.out.println("Приклад 1:");
        System.out.println("Вхід: " + s1);
        System.out.println("Вихід: " + solution.numDecodings(s1));
        System.out.println("Очікуване: 2"); // "AB" (1 2) або "L" (12)

        // Приклад 2
        String s2 = "226";
        System.out.println("\nПриклад 2:");
        System.out.println("Вхід: " + s2);
        System.out.println("Вихід: " + solution.numDecodings(s2));
        System.out.println("Очікуване: 3"); // "BZ" (2 26), "VF" (22 6), або "BBF" (2 2 6)

        // Приклад 3
        String s3 = "06";
        System.out.println("\nПриклад 3:");
        System.out.println("Вхід: " + s3);
        System.out.println("Вихід: " + solution.numDecodings(s3));
        System.out.println("Очікуване: 0"); // Невалідне декодування через '0' в "06"
    }
}
