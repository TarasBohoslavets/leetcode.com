package Problem_List.Q80_Remove_Duplicates_from_Sorted_Array_II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        // Якщо довжина масиву менша за 3, немає потреби в модифікації, оскільки максимум два повтори допускаються
        if (nums.length <= 2) {
            return nums.length;
        }

        // Вказівник на позицію для запису наступного унікального або другого елемента
        int writeIndex = 2;

        // Проходимо по масиву, починаючи з третього елемента (i = 2)
        for (int i = 2; i < nums.length; i++) {
            // Перевіряємо, чи поточний елемент відрізняється від елемента на позиції writeIndex - 2
            // Це дозволяє залишати не більше двох однакових елементів
            if (nums[i] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        // Повертаємо кількість унікальних елементів з максимально двома повтореннями
        return writeIndex;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Тест 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println(k1); // Виведе: 5
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // Виведе: 1 1 2 2 3
        }
        System.out.println();

        // Тест 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println(k2); // Виведе: 7
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " "); // Виведе: 0 0 1 1 2 3 3
        }
    }
}