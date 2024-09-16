package Problem_List.Q75_Sort_Colors;

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        // Ітеруємо доки середній вказівник не пройде через всі елементи
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Міняємо 0 на місце low
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 вже на своєму місці, рухаємось далі
                mid++;
            } else {
                // Міняємо 2 на місце high
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Допоміжний метод для обміну елементів
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}