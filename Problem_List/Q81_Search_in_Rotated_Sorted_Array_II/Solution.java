package Problem_List.Q81_Search_in_Rotated_Sorted_Array_II;

public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Бінарний пошук з модифікаціями для роботи з оберненими та дублікатами
        while (left <= right) {
            // Середній індекс
            int mid = left + (right - left) / 2;

            // Якщо елемент по середині дорівнює цілі - повертаємо true
            if (nums[mid] == target) {
                return true;
            }

            // Якщо лівий, середній і правий елементи однакові, важко зрозуміти де півмасив впорядкований,
            // тому просто зміщуємо границі на 1 і продовжуємо пошук
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            }
            // Якщо ліва частина впорядкована
            else if (nums[left] <= nums[mid]) {
                // Якщо ціль знаходиться в межах впорядкованої частини, звужуємо пошук до цієї частини
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Якщо права частина впорядкована
            else {
                // Якщо ціль знаходиться в межах впорядкованої частини, звужуємо пошук до цієї частини
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // Якщо елемент не знайдено - повертаємо false
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Тест 1
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println(sol.search(nums1, target1)); // Виведе: true

        // Тест 2
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println(sol.search(nums2, target2)); // Виведе: false
    }
}
