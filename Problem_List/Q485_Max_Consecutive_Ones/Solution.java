package Problem_List.Q485_Max_Consecutive_Ones;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;      // Максимальна кількість 1 підряд
        int count = 0;    // Поточний лічильник 1

        for (int num : nums) {
            if (num == 1) {
                count++;           // Збільшуємо лічильник, якщо знайшли 1
                max = Math.max(max, count); // Оновлюємо максимум
            } else {
                count = 0;         // Скидаємо лічильник, якщо зустріли 0
            }
        }

        return max;
    }
}

