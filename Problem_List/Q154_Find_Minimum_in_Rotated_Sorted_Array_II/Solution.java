package Problem_List.Q154_Find_Minimum_in_Rotated_Sorted_Array_II;

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Якщо елементи на межах однакові, просто зменшуємо межу, щоб позбутися дубліката
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Якщо середній елемент більший за правий, мінімум у правій половині
            else if (nums[mid] > nums[right]) {
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
        int[] example1 = {1, 3, 5};
        System.out.println("Example 1 Output: " + solution.findMin(example1)); // Очікуваний результат: 1

        int[] example2 = {2, 2, 2, 0, 1};
        System.out.println("Example 2 Output: " + solution.findMin(example2)); // Очікуваний результат: 0
    }
}
