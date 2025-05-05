package Problem_List.Q448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Маркуємо побачені числа
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // -1 бо індекси від 0
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // позначаємо як відвідане
            }
        }

        // Ті, що залишились позитивні — їх індекси +1 і є зниклі числа
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {4,3,2,7,8,2,3,1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + sol.findDisappearedNumbers(nums1)); // [5,6]

        int[] nums2 = {1,1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + sol.findDisappearedNumbers(nums2)); // [2]

        int[] nums3 = {2,2,2,2};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + sol.findDisappearedNumbers(nums3)); // [1,3,4]
    }
}
