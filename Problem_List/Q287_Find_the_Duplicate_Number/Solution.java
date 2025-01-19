package Problem_List.Q287_Find_the_Duplicate_Number;

class Solution {
    public int findDuplicate(int[] nums) {
        // Ініціалізуємо вказівники
        int slow = nums[0];
        int fast = nums[0];

        // Зустріч в циклі
        do {
            slow = nums[slow];       // Рухаємося на 1 крок
            fast = nums[nums[fast]]; // Рухаємося на 2 кроки
        } while (slow != fast);

        // Знаходимо початок циклу
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // Повертаємо повторюване число
    }
}
