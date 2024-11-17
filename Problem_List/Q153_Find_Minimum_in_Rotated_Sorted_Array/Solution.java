package Problem_List.Q153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Якщо середній елемент більший за правий, мінімум у правій половині
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Інакше мінімум у лівій половині (включаючи середній)
            else {
                right = mid;
            }
        }

        // Мінімум буде в індексі left або right (оскільки вони однакові)
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Приклади для перевірки
        int[] example1 = {3, 4, 5, 1, 2};
        System.out.println("Example 1 Output: " + solution.findMin(example1)); // Очікуваний результат: 1

        int[] example2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Example 2 Output: " + solution.findMin(example2)); // Очікуваний результат: 0

        int[] example3 = {11, 13, 15, 17};
        System.out.println("Example 3 Output: " + solution.findMin(example3)); // Очікуваний результат: 11
    }
}

