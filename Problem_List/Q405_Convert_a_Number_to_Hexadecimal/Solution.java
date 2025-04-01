package Problem_List.Q405_Convert_a_Number_to_Hexadecimal;

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0"; // Випадок для 0

        String hexChars = "0123456789abcdef";
        StringBuilder hexString = new StringBuilder();

        // Обробка від'ємних чисел
        long n = num;
        if (n < 0) {
            n = (long) num + (1L << 32); // Перетворення у беззнаковий long
        }

        // Ділення на 16
        while (n > 0) {
            int remainder = (int) (n % 16);
            hexString.append(hexChars.charAt(remainder));
            n /= 16;
        }

        return hexString.reverse().toString(); // Реверсуємо відповідь
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int num1 = 26;
        System.out.println("Input: " + num1);
        System.out.println("Output: " + solution.toHex(num1)); // Очікуваний вивід: "1a"

        // Example 2
        int num2 = -1;
        System.out.println("Input: " + num2);
        System.out.println("Output: " + solution.toHex(num2)); // Очікуваний вивід: "ffffffff"
    }
}
