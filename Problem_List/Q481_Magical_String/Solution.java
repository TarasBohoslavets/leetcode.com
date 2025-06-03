package Problem_List.Q481_Magical_String;


class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1; // Перші 3 символи "122" — лише одна '1'

        int[] s = new int[n + 2]; // Масив для побудови рядка
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int head = 2; // Вказує, скільки разів додати наступну цифру
        int tail = 3; // Поточна довжина рядка
        int num = 1;  // Поточна цифра, яку додаємо (1 або 2)
        int count = 1; // Початкова кількість одиниць ('1')

        while (tail < n) {
            for (int i = 0; i < s[head]; i++) {
                s[tail] = num;
                if (num == 1 && tail < n) count++; // Рахуємо тільки в межах n
                tail++;
            }
            num = 3 - num; // Перемикаємо між 1 і 2
            head++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int result = solution.magicalString(n);
        System.out.println("Кількість '0' у перших " + n + " символах магічного рядка: " + result);
    }
}