package Problem_List.Q53_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Якщо додавання поточного елемента зменшує суму, починаємо новий підмасив
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Оновлюємо максимальну знайдену суму
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклад 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + java.util.Arrays.toString(nums1));
        System.out.println("Output: " + solution.maxSubArray(nums1));
        // Очікуваний вихід: 6

        // Приклад 2
        int[] nums2 = {1};
        System.out.println("\nInput: " + java.util.Arrays.toString(nums2));
        System.out.println("Output: " + solution.maxSubArray(nums2));
        // Очікуваний вихід: 1

        // Приклад 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("\nInput: " + java.util.Arrays.toString(nums3));
        System.out.println("Output: " + solution.maxSubArray(nums3));
        // Очікуваний вихід: 23
    }
}

