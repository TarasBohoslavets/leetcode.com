package Problem_List.Q330_Patching_Array;

class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // Найменше число, яке ще не можна отримати
        int patches = 0, i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // Якщо поточний елемент nums[i] можна використати для покриття `miss`
                miss += nums[i];
                i++;
            } else {
                // Якщо не можемо отримати `miss`, додаємо його в масив
                miss += miss;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 3};
        System.out.println(sol.minPatches(nums1, 6)); // Очікуваний результат: 1

        int[] nums2 = {1, 5, 10};
        System.out.println(sol.minPatches(nums2, 20)); // Очікуваний результат: 2

        int[] nums3 = {1, 2, 2};
        System.out.println(sol.minPatches(nums3, 5)); // Очікуваний результат: 0
    }
}

