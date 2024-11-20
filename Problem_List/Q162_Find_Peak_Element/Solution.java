package Problem_List.Q162_Find_Peak_Element;

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Порівнюємо середній елемент з правим сусідом
            if (nums[mid] < nums[mid + 1]) {
                // Пікова вершина праворуч
                left = mid + 1;
            } else {
                // Пікова вершина ліворуч або це сам середній елемент
                right = mid;
            }
        }

        // Повертаємо індекс пікової вершини
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak Index (Example 1): " + solution.findPeakElement(nums1)); // Output: 2

        // Example 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index (Example 2): " + solution.findPeakElement(nums2)); // Output: 5 (or 1)
    }
}


