package Problem_List.Q462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // Сортуємо масив
        int median = nums[nums.length / 2];
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median); // Підрахунок відстані до медіани
        }

        return moves;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minMoves2(new int[]{1, 2, 3}));       // Output: 2
        System.out.println(sol.minMoves2(new int[]{1, 10, 2, 9}));   // Output: 16
        System.out.println(sol.minMoves2(new int[]{1}));             // Output: 0
    }
}

