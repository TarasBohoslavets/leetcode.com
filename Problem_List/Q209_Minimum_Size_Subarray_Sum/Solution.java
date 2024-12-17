package Problem_List.Q209_Minimum_Size_Subarray_Sum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0; // Ліва межа вікна
        int sum = 0; // Поточна сума елементів у вікні
        int minLength = Integer.MAX_VALUE; // Мінімальна довжина підмасиву

        for (int right = 0; right < n; right++) {
            sum += nums[right]; // Додаємо поточний елемент до суми

            // Звужуємо вікно, поки сума >= target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1); // Оновлюємо мінімальну довжину
                sum -= nums[left]; // Викидаємо лівий елемент з суми
                left++; // Рухаємось вправо
            }
        }

        // Якщо minLength залишилося незмінним, немає підмасиву, що відповідає умовам
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(target1, nums1)); // Вивід: 2

        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println(solution.minSubArrayLen(target2, nums2)); // Вивід: 1

        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.minSubArrayLen(target3, nums3)); // Вивід: 0
    }
}

